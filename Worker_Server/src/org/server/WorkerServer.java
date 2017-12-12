package org.server;

import org.server.communication.Request;
import org.server.communication.Response;
import org.server.job.Job;
import org.server.config.WorkerConfiguration;
import org.server.config.WorkerServerConfiguration;
import org.server.worker.Worker;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;


public class WorkerServer implements Runnable {

    //afaik according to SO - it's safe and desired to have 1 logger
    private final static Logger logger = Logger.getLogger(WorkerServer.class.getName());

    private ServerSocket serverSocket;
    private List<WorkerConfiguration> workerConfigurations;
    private String name;
    ExecutorService executors;
    private int workerPoolSize=3;


    public WorkerServer(WorkerServerConfiguration configuration){

        this.name=configuration.getName();
        workerConfigurations=  configuration.getWorkerConfigurations();
            try {
                serverSocket=new ServerSocket(configuration.getSocket());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(name + " " + e.getMessage());


            }

        workerPoolSize=workerConfigurations.size();

    }

    @Override
    public void run() {
        //call looping method

        logger.info("WorkerServer "+ this.name +" is started");

        handleSocket();

    }


    private void handleSocket(){

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


        while(shouldLive){



            //#TODO - use java EE JsonReader + create a shared container (LIFO ) to give response

            Request request=new Request(new ArrayList<Job>());

            //#TODO better config passing
            FutureTask<Response>task=new FutureTask<Response>(new Worker(request,workerConfigurations.get(0)));
            executors.submit(task);



            //implement logic
        }


    }




}
