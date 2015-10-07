package com.maxoptra.api.v1.model.order.status.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderStatusResponse
{
    private Orders orders;

    private UnknownReferences unknownReferences;

    @XmlElement
    public Orders getOrders ()
    {
        return orders;
    }

    public void setOrders (Orders orders)
    {
        this.orders = orders;
    }

    @XmlElement
    public UnknownReferences getUnknownReferences ()
    {
        return unknownReferences;
    }

    public void setUnknownReferences (UnknownReferences unknownReferences)
    {
        this.unknownReferences = unknownReferences;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [orders = "+orders+", unknownReferences = "+unknownReferences+"]";
    }
}