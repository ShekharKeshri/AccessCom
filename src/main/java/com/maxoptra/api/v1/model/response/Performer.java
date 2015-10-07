package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Performer
{
    private String planDuration;

    private String id;

    private String availabilityEndTime;

    private Location[] location;

    private String aocId;

    private String name;

    private String planDistance;

    private String vehicle;

    private String runEndTime;

    private String runStartTime;

    private String cost;

    private String availabilityStartTime;

    private String runDay;

    @XmlAttribute
    public String getPlanDuration ()
    {
        return planDuration;
    }

    public void setPlanDuration (String planDuration)
    {
        this.planDuration = planDuration;
    }

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

    @XmlElement
    public Location[] getLocation ()
    {
        return location;
    }

    public void setLocation (Location[] location)
    {
        this.location = location;
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
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @XmlAttribute
    public String getPlanDistance ()
    {
        return planDistance;
    }

    public void setPlanDistance (String planDistance)
    {
        this.planDistance = planDistance;
    }

    @XmlAttribute
    public String getVehicle ()
    {
        return vehicle;
    }

    public void setVehicle (String vehicle)
    {
        this.vehicle = vehicle;
    }

    @XmlAttribute
    public String getRunEndTime ()
    {
        return runEndTime;
    }

    public void setRunEndTime (String runEndTime)
    {
        this.runEndTime = runEndTime;
    }

    @XmlAttribute
    public String getRunStartTime ()
    {
        return runStartTime;
    }

    public void setRunStartTime (String runStartTime)
    {
        this.runStartTime = runStartTime;
    }

    @XmlAttribute
    public String getCost ()
    {
        return cost;
    }

    public void setCost (String cost)
    {
        this.cost = cost;
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
    public String getRunDay ()
    {
        return runDay;
    }

    public void setRunDay (String runDay)
    {
        this.runDay = runDay;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [planDuration = "+planDuration+", id = "+id+", availabilityEndTime = "+availabilityEndTime+", location = "+location+", aocId = "+aocId+", name = "+name+", planDistance = "+planDistance+", vehicle = "+vehicle+", runEndTime = "+runEndTime+", runStartTime = "+runStartTime+", cost = "+cost+", availabilityStartTime = "+availabilityStartTime+", runDay = "+runDay+"]";
    }
}
