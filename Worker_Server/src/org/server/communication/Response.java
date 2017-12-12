package org.server.communication;

import org.server.calculations.Result;

import java.util.Map;

public class Response extends SocketMessage {

    //job's id and result
    private Map<String, Result> results;

    public Response(Map<String, Result> results) {
        this.results = results;
    }

    public Map<String, Result> getResults() {
        return results;
    }

}
