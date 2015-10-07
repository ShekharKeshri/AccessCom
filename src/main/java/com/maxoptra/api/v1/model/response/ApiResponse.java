package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiResponse
{
    private AuthResponse authResponse;

    private AreaOfControlResponse areaOfControlResponse;
    
    private VehiclesResponse vehiclesResponse;
    
    private ScheduleResponse scheduleResponse;
    
    private String version;
    
    private Error error;

    private Orders orders;

    @XmlElement
    public AuthResponse getAuthResponse ()
    {
        return authResponse;
    }

    public void setAuthResponse (AuthResponse authResponse)
    {
        this.authResponse = authResponse;
    }

    @XmlAttribute
    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }
    
    @XmlElement
    public Error getError ()
    {
        return error;
    }

    public void setError (Error error)
    {
        this.error = error;
    }

    @XmlElement
    public Orders getOrders ()
    {
        return orders;
    }

    public void setOrders (Orders orders)
    {
        this.orders = orders;
    }

    @XmlElement
	public AreaOfControlResponse getAreaOfControlResponse() {
		return areaOfControlResponse;
	}

	public void setAreaOfControlResponse(AreaOfControlResponse areaOfControlResponse) {
		this.areaOfControlResponse = areaOfControlResponse;
	}

	@XmlElement
	public VehiclesResponse getVehiclesResponse ()
    {
        return vehiclesResponse;
    }

    public void setVehiclesResponse (VehiclesResponse vehiclesResponse)
    {
        this.vehiclesResponse = vehiclesResponse;
    }
    
    @XmlElement
    public ScheduleResponse getScheduleResponse ()
    {
        return scheduleResponse;
    }

    public void setScheduleResponse (ScheduleResponse scheduleResponse)
    {
        this.scheduleResponse = scheduleResponse;
    }

	@Override
	public String toString() {
		return "ApiResponse [authResponse=" + authResponse
				+ ", areaOfControlResponse=" + areaOfControlResponse
				+ ", vehiclesResponse=" + vehiclesResponse
				+ ", scheduleResponse=" + scheduleResponse + ", version="
				+ version + ", error=" + error + ", orders=" + orders + "]";
	}
	
}