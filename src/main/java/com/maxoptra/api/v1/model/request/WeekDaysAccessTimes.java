package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeekDaysAccessTimes implements Serializable
{
    private AccessTime[] accessTime;

    @XmlElement
    public AccessTime[] getAccessTime ()
    {
        return accessTime;
    }

    public void setAccessTime (AccessTime[] accessTime)
    {
        this.accessTime = accessTime;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [accessTime = "+accessTime+"]";
    }
}