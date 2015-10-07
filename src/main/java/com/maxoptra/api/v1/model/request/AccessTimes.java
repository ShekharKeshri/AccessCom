
package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccessTimes implements Serializable
{
    private DefaultAccessTime defaultAccessTime;
    private WeekDaysAccessTimes weekDaysAccessTimes;

    @XmlElement
    public DefaultAccessTime getDefaultAccessTime ()
    {
        return defaultAccessTime;
    }

    public void setDefaultAccessTime (DefaultAccessTime defaultAccessTime)
    {
        this.defaultAccessTime = defaultAccessTime;
    }

    @XmlElement
    public WeekDaysAccessTimes getWeekDaysAccessTimes ()
    {
        return weekDaysAccessTimes;
    }

    public void setWeekDaysAccessTimes (WeekDaysAccessTimes weekDaysAccessTimes)
    {
        this.weekDaysAccessTimes = weekDaysAccessTimes;
    }
    
    @Override
    public String toString()
    {
        return "ClassPojo [defaultAccessTime = "+defaultAccessTime+"]";
    }
}