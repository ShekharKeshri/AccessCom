package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;

public class ScheduleResponse
{
    private Performers performers;

    private Units units;

    @XmlElement
    public Performers getPerformers ()
    {
        return performers;
    }

    public void setPerformers (Performers performers)
    {
        this.performers = performers;
    }

    @XmlElement
    public Units getUnits ()
    {
        return units;
    }

    public void setUnits (Units units)
    {
        this.units = units;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [performers = "+performers+", units = "+units+"]";
    }
}