package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client implements Serializable
{
    private String contactNumber;

    private String name;

    private String contactPerson;

    @XmlElement
    public String getContactNumber ()
    {
        return contactNumber;
    }

    public void setContactNumber (String contactNumber)
    {
        this.contactNumber = contactNumber;
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
    public String getContactPerson ()
    {
        return contactPerson;
    }

    public void setContactPerson (String contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [contactNumber = "+contactNumber+", name = "+name+", contactPerson = "+contactPerson+"]";
    }
}