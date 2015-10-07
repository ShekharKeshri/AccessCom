package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IncludeList implements Serializable
{
    private String[] driver;

    @XmlElement
    public String[] getDriver ()
    {
        return driver;
    }

    public void setDriver (String[] driver)
    {
        this.driver = driver;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [driver = "+driver+"]";
    }
}