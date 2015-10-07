package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerLocation implements Serializable
{
    private Position position;

    private String phoneNumber;

    private String email;

    private String contactName;

    private String description;

    private String name;

    private Customer customer;

    private AccessTimes accessTimes;

    @XmlElement
    public Position getPosition ()
    {
    	if(position == null){
    		position = new Position();
    	}
        return position;
    }

    public void setPosition (Position position)
    {
        this.position = position;
    }

    @XmlElement
    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    @XmlElement
    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @XmlElement
    public String getContactName ()
    {
        return contactName;
    }

    public void setContactName (String contactName)
    {
        this.contactName = contactName;
    }

    @XmlElement
    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    @XmlElement
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @XmlElement
    public Customer getCustomer ()
    {
    	if(customer == null){
    		customer = new Customer();
    	}
        return customer;
    }

    public void setCustomer (Customer customer)
    {
        this.customer = customer;
    }

    @XmlElement
    public AccessTimes getAccessTimes ()
    {
    	if(accessTimes == null){
    		accessTimes = new AccessTimes();
    	}
        return accessTimes;
    }

    public void setAccessTimes (AccessTimes accessTimes)
    {
        this.accessTimes = accessTimes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [position = "+position+", phoneNumber = "+phoneNumber+", email = "+email+", contactName = "+contactName+", description = "+description+", name = "+name+", customer = "+customer+", accessTimes = "+accessTimes+"]";
    }
}