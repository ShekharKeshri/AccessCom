package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DefaultAccessTime implements Serializable
{
    private String start;

    private String start2;

    private String end2;

    private String end;

    @XmlElement
    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    @XmlElement
    public String getStart2 ()
    {
        return start2;
    }

    public void setStart2 (String start2)
    {
        this.start2 = start2;
    }

    @XmlElement
    public String getEnd2 ()
    {
        return end2;
    }

    public void setEnd2 (String end2)
    {
        this.end2 = end2;
    }

    @XmlElement
    public String getEnd ()
    {
        return end;
    }

    public void setEnd (String end)
    {
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [start = "+start+", start2 = "+start2+", end2 = "+end2+", end = "+end+"]";
    }
}