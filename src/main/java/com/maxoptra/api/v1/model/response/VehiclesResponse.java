package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;

public class VehiclesResponse
{
    private Vehicles vehicles;

    private Units units;

    @XmlElement
    public Vehicles getVehicles ()
    {
        return vehicles;
    }

    public void setVehicles (Vehicles vehicles)
    {
        this.vehicles = vehicles;
    }

    @XmlElement
    public Units getUnits ()
    {
        return units;
    }

    public void setUnits (Units units)
    {
        this.units = units;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vehicles = "+vehicles+", units = "+units+"]";
    }
}