package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Aocs
{
    private Aoc[] aoc;

    @XmlElement
    public Aoc[] getAoc ()
    {
        return aoc;
    }

    public void setAoc (Aoc[] aoc)
    {
        this.aoc = aoc;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [aoc = "+aoc+"]";
    }
}
