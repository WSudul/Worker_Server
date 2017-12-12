package org.server.calculations;

import java.time.Duration;

public class Result {

    private Duration duration;
    private String value;
    private boolean successful;

    public Result(Duration duration, String value) {
        this.duration = duration;
        this.value = value;
        this.successful=true;
    }

    public Result(Duration duration, String value,boolean successful) {
        this.duration = duration;
        this.value = value;
        this.successful=successful;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
