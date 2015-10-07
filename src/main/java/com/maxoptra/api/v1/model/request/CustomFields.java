package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomFields implements Serializable
{
    private Field[] field;

    @XmlElement
    public Field[] getField ()
    {
        return field;
    }

    public void setField (Field[] field)
    {
        this.field = field;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [field = "+field+"]";
    }
}