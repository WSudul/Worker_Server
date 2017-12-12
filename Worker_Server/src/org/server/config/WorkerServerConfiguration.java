package org.server.config;

import java.util.List;

public class WorkerServerConfiguration {

    private String name;
    private Integer socket;
    private List<WorkerConfiguration> workerConfigurations;

    public WorkerServerConfiguration(){}

    public WorkerServerConfiguration(String name, Integer socket, List<WorkerConfiguration> workerConfigurations) {
        this.name = name;
        this.socket = socket;
        this.workerConfigurations = workerConfigurations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSocket() {
        return socket;
    }

    public void setSocket(Integer socket) {
        this.socket = socket;
    }

    public List<WorkerConfiguration> getWorkerConfigurations() {
        return workerConfigurations;
    }

    public void setWorkerConfigurations(List<WorkerConfiguration> workerConfigurations) {
        this.workerConfigurations = workerConfigurations;
    }





}
