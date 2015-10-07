package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Skills implements Serializable
{
    private Skill[] skill;

    @XmlElement
    public Skill[] getSkill ()
    {
        return skill;
    }

    public void setSkill (Skill[] skill)
    {
        this.skill = skill;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [skill = "+skill+"]";
    }
}