package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthResponse
{
    private String sessionID;

    @XmlElement
    public String getSessionID ()
    {
        return sessionID;
    }

    public void setSessionID (String sessionID)
    {
        this.sessionID = sessionID;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sessionID = "+sessionID+"]";
    }
}