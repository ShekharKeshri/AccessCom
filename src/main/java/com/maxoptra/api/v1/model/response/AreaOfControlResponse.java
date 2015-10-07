package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AreaOfControlResponse
{
    private Aocs aocs;

    @XmlElement
    public Aocs getAocs ()
    {
        return aocs;
    }

    public void setAocs (Aocs aocs)
    {
        this.aocs = aocs;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [aocs = "+aocs+"]";
    }
}