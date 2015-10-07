package com.maxoptra.api.v1.model.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobTypes
{
    private JobType jobType;

    @XmlElement
    public JobType getJobType ()
    {
        return jobType;
    }

    public void setJobType (JobType jobType)
    {
        this.jobType = jobType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [jobType = "+jobType+"]";
    }
}