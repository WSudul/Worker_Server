package org.server.communication;


import java.time.LocalDateTime;
import java.util.UUID;

public class SocketMessage {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private UUID uuid=UUID.randomUUID();
    private int priority=1;

    SocketMessage(){
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
