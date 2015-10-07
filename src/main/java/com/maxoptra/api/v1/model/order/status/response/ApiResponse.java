package com.maxoptra.api.v1.model.order.status.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiResponse
{
    private OrderStatusResponse orderStatusResponse;

    private String version;

    @XmlElement
    public OrderStatusResponse getOrderStatusResponse ()
    {
        return orderStatusResponse;
    }

    public void setOrderStatusResponse (OrderStatusResponse orderStatusResponse)
    {
        this.orderStatusResponse = orderStatusResponse;
    }

    @XmlAttribute
    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [orderStatusResponse = "+orderStatusResponse+", version = "+version+"]";
    }
}
