package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;

public class Vehicles
{
    private Vehicle[] vehicle;

    @XmlElement
    public Vehicle[] getVehicle ()
    {
        return vehicle;
    }

    public void setVehicle (Vehicle[] vehicle)
    {
        this.vehicle = vehicle;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vehicle = "+vehicle+"]";
    }
}