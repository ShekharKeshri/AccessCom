package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;

public class Performers
{
    private Performer[] performer;

    @XmlElement
    public Performer[] getPerformer ()
    {
        return performer;
    }

    public void setPerformer (Performer[] performer)
    {
        this.performer = performer;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [performer = "+performer+"]";
    }
}