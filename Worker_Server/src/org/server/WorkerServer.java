package org.server;

import com.sun.net.httpserver.HttpServer;
import org.server.communication.Request;
import org.server.communication.Response;
import org.server.config.WorkerConfiguration;
import org.server.config.WorkerServerConfiguration;
import org.server.job.Job;
import org.server.worker.Worker;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;


public class WorkerServer implements Runnable {


    private final static Logger logger = Logger.getLogger(WorkerServer.class.getName());
    ExecutorService executors;
    private List<WorkerConfiguration> workerConfigurations;
    private String name;
    private int workerPoolSize = 3;
    private int serverPoolSize = 5;
    private Integer port = 8080;

    public WorkerServer(WorkerServerConfiguration configuration){

        this.name=configuration.getName();
        workerConfigurations=  configuration.getWorkerConfigurations();

        this.port = configuration.getSocket();


        workerPoolSize=workerConfigurations.size();

    }

    @Override
    public void run() {
        //call looping method

        logger.info("WorkerServer "+ this.name +" is started");


        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", port);
        ErrorHandler errorHandler = new ErrorHandler();
        RequestHandler requestHandler = new RequestHandler(errorHandler, executors);

        try {
            HttpServer httpServer = HttpServer.create(socketAddress, 0);
            httpServer.createContext("/request", requestHandler);
            httpServer.createContext("/", errorHandler);
            httpServer.setExecutor(Executors.newFixedThreadPool(serverPoolSize));
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //handleRequests();

    }


    //old implementation for socket - should be moved to handle http requests
    private void handleRequests() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(name + " " + e.getMessage());


        }
        //make it thread safe variable
        boolean shouldLive=true;

        executors =  Executors.newFixedThreadPool(workerPoolSize);
        Socket client=new Socket();
        InputStream inputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        //JsonReader jsonReader;

        logger.info("WorkerServer "+ this.name +" is waiting for client");
        try {
            client=serverSocket.accept();  //only 1 connection allowed to serverSocket
            inputStream =client.getInputStream();
            objectOutputStream =new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception caught when handling socket "+e.getMessage());
            return;
        }


        //#TODO implement pooling method
        List<Future<Response>> futureResponses=new LinkedList<>();

        while(shouldLive){


            //#TODO - use java EE JsonReader + create a shared container (LIFO ) to give response

            //reading and writing needs to be synchronized!

            Request request=new Request(new ArrayList<Job>());

            //#TODO better config passing
            Worker workerCallable=new Worker(request,workerConfigurations.get(0));
            futureResponses.add(executors.submit(workerCallable));


            //implement pooling throught futureResponses and send response when isDone() returns true;
            Iterator<Future<Response>> iterator=futureResponses.iterator();
            while(iterator.hasNext()){
                Future<Response> response=iterator.next();
                if(response.isDone()) {
                    try {
                        Response result=response.get();
                        iterator.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }else{
                    //skip or try waiting for short time ?
                }


            }

        }


    }




}
