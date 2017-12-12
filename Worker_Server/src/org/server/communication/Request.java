package org.server.communication;

import org.server.job.Job;

import java.util.List;

public class Request extends SocketMessage{


    public Request(List<Job> jobs, int priority){
        super();
        setPriority(priority);
        this.jobs=jobs;
    }

    public Request(List<Job> jobs){
        super();
        this.jobs=jobs;
    }

    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
