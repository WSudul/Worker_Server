package org.server.config;

import java.util.concurrent.TimeUnit;

public class WorkerConfiguration {


    private String name;
    private TimeUnit timeoutUnit;
    private int executorShutdownTimeout;
    private int threadPoolSize;


    public WorkerConfiguration(String name, TimeUnit timeoutUnit, int executorShutdownTimeout, int threadPoolSize) {
        this.name = name;
        this.timeoutUnit = timeoutUnit;
        this.executorShutdownTimeout = executorShutdownTimeout;
        this.threadPoolSize = threadPoolSize;
    }

    public int getExecutorShutdownTimeout() {
        return executorShutdownTimeout;
    }

    public void setExecutorShutdownTimeout(int executorShutdownTimeout) {
        this.executorShutdownTimeout = executorShutdownTimeout;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeUnit getTimeoutUnit() {
        return timeoutUnit;
    }

    public void setTimeoutUnit(TimeUnit timeoutUnit) {
        this.timeoutUnit = timeoutUnit;
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }
}
