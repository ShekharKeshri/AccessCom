package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiRequest implements Serializable
{
    private String sessionID;
    private String accountID;
    private Orders orders;
    private String user;
    private String password;

    @XmlElement
    public String getSessionID ()
    {
        return sessionID;
    }

    public void setSessionID (String sessionID)
    {
        this.sessionID = sessionID;
    }

    @XmlElement
    public Orders getOrders ()
    {
    	if(orders == null){
    		orders = new Orders();
    	}
        return orders;
    }

    public void setOrders (Orders orders)
    {
        this.orders = orders;
    }

    @XmlElement
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getUser() {
		return user;
	}

	@XmlElement
	public void setUser(String user) {
		this.user = user;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ApiRequest [sessionID=" + sessionID + ", accountID="
				+ accountID + ", orders=" + orders + ", user=" + user
				+ ", password=" + password + ", getSessionID()="
				+ getSessionID() + ", getOrders()=" + getOrders()
				+ ", getAccountID()=" + getAccountID() + ", getUser()="
				+ getUser() + ", getPassword()=" + getPassword() + "]";
	}
}