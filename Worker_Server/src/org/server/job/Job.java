package org.server.job;

import java.util.List;

//base class for all tasks
public abstract class Job{

    private JobType jobtype;
    private String id;
    private List<String> arguments; //arguments need to follow some rules - eg occurence - provide list of regex(?) words/rules
    //mean - give a name for param and type for eg valueName, valueType, via Map- it will be extracted like this:
    // Select data from table where table.author in (authors.toString());
    // data -> substring
    //update valueType is worthless - result will always be float. BUUUT parsing the parameters as float might produce different result!
    //So should argument be like for statisticsal calcs: valueName=foo valueType=Integer,
    //VISITOR PATTERN for different types?
    public abstract String getArguments();



    public JobType getJobtype() {
        return jobtype;
    }

    public void setJobtype(JobType jobtype) {
        this.jobtype = jobtype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
