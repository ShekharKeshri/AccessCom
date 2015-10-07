package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlAttribute;

public class Vehicle
{
    private String id;

    private String availabilityEndTime;

    private String name;

    private String aocId;

    private String active;

    private String driverPhone;

    private String driverName;

    private String availabilityStartTime;

    private String costByDistance;

    @XmlAttribute
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @XmlAttribute
    public String getAvailabilityEndTime ()
    {
        return availabilityEndTime;
    }

    public void setAvailabilityEndTime (String availabilityEndTime)
    {
        this.availabilityEndTime = availabilityEndTime;
    }

    @XmlAttribute
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @XmlAttribute
    public String getAocId ()
    {
        return aocId;
    }

    public void setAocId (String aocId)
    {
        this.aocId = aocId;
    }

    @XmlAttribute
    public String getActive ()
    {
        return active;
    }

    public void setActive (String active)
    {
        this.active = active;
    }

    @XmlAttribute
    public String getDriverPhone ()
    {
        return driverPhone;
    }

    public void setDriverPhone (String driverPhone)
    {
        this.driverPhone = driverPhone;
    }

    @XmlAttribute
    public String getDriverName ()
    {
        return driverName;
    }

    public void setDriverName (String driverName)
    {
        this.driverName = driverName;
    }

    @XmlAttribute
    public String getAvailabilityStartTime ()
    {
        return availabilityStartTime;
    }

    public void setAvailabilityStartTime (String availabilityStartTime)
    {
        this.availabilityStartTime = availabilityStartTime;
    }

    @XmlAttribute
    public String getCostByDistance ()
    {
        return costByDistance;
    }

    public void setCostByDistance (String costByDistance)
    {
        this.costByDistance = costByDistance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", availabilityEndTime = "+availabilityEndTime+", name = "+name+", aocId = "+aocId+", active = "+active+", driverPhone = "+driverPhone+", driverName = "+driverName+", availabilityStartTime = "+availabilityStartTime+", costByDistance = "+costByDistance+"]";
    }
}