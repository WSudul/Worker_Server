package org.server.worker;

import org.server.calculations.Result;
import org.server.communication.Request;
import org.server.communication.Response;
import org.server.config.WorkerConfiguration;
import org.server.job.Job;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class Worker implements Callable<Response> {

    private final static Logger logger = Logger.getLogger(Worker.class.getName());

    private Request request;
    private WorkerConfiguration workerConfiguration;

    public Worker(Request request){
        this.request=request;
    }

    public Worker(Request request, WorkerConfiguration workerConfiguration){
        this.request=request;
        this.workerConfiguration=workerConfiguration;
    }


    @Override
    public Response call() throws Exception {

        logger.info("Worker: " + workerConfiguration.getName() +" is started");

        Map<String,Result> results=new HashMap<>();

        for(Job job:request.getJobs()){
            Instant instantStart = Instant.now();


            //do stuff

            Instant instantEnd = instantStart.plusSeconds(3600);
            Duration duration = Duration.between(instantStart, instantEnd);

            Result result=new Result(duration,"1.0");
            results.put(job.getId(),result);

        }

        //do stuff

        return new Response(results);

    }
}
