package com.maxoptra.api.v1.model.order.status.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order
{
    private String status;

    private String referenceNumber;

    @XmlAttribute
    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @XmlAttribute
    public String getReferenceNumber ()
    {
        return referenceNumber;
    }

    public void setReferenceNumber (String referenceNumber)
    {
        this.referenceNumber = referenceNumber;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", referenceNumber = "+referenceNumber+"]";
    }
}