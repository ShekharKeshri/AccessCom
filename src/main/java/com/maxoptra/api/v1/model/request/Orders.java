package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Orders implements Serializable
{
    private Order[] order;

    @XmlElement
    public Order[] getOrder() {
		return order;
	}

	public void setOrder(Order[] order) {
		this.order = order;
	}
	
    @Override
    public String toString()
    {
        return "ClassPojo [order = "+order+"]";
    }
}