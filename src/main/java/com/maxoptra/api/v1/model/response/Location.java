package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Location
{
    private String address;
    private String locationType;
    private String name;
    private String longitude;
    private String latitude;
    private String planArrivalTime;
    private String planDepartureTime;
    private Order order;
    private String number;

    @XmlAttribute
    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    @XmlAttribute
    public String getLocationType ()
    {
        return locationType;
    }

    public void setLocationType (String locationType)
    {
        this.locationType = locationType;
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
    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    @XmlAttribute
    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    @XmlAttribute
    public String getPlanDepartureTime ()
    {
        return planDepartureTime;
    }

    public void setPlanDepartureTime (String planDepartureTime)
    {
        this.planDepartureTime = planDepartureTime;
    }

    @XmlElement
    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@XmlAttribute
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPlanArrivalTime() {
		return planArrivalTime;
	}

	public void setPlanArrivalTime(String planArrivalTime) {
		this.planArrivalTime = planArrivalTime;
	}

	@Override
	public String toString() {
		return "Location [address=" + address + ", locationType="
				+ locationType + ", name=" + name + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", planArrivalTime="
				+ planArrivalTime + ", planDepartureTime=" + planDepartureTime
				+ ", order=" + order + ", number=" + number + "]";
	}
}