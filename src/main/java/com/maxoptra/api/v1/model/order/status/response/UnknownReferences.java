package com.maxoptra.api.v1.model.order.status.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UnknownReferences
{
    private String reference;

    @XmlElement
    public String getReference ()
    {
        return reference;
    }

    public void setReference (String reference)
    {
        this.reference = reference;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [reference = "+reference+"]";
    }
}