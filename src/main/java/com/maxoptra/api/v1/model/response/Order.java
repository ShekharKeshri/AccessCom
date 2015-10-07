package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order
{
    private String status;
    private String orderReference;
    private Errors errors;
    private Warnings warnings;
    private String duration;
    private String price;
    private String instructions;
    private String bookedTimeStart;
    private String customerLocationDescription;
    private String comments;
    private String bookedTimeEnd;
    
    @XmlElement
    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @XmlElement
    public String getOrderReference ()
    {
        return orderReference;
    }

    public void setOrderReference (String orderReference)
    {
        this.orderReference = orderReference;
    }

    @XmlElement
    public Errors getErrors ()
    {
        return errors;
    }

    public void setErrors (Errors errors)
    {
        this.errors = errors;
    }
    
    @XmlElement
    public Warnings getWarnings ()
    {
        return warnings;
    }

    public void setWarnings (Warnings warnings)
    {
        this.warnings = warnings;
    }

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getBookedTimeStart() {
		return bookedTimeStart;
	}

	public void setBookedTimeStart(String bookedTimeStart) {
		this.bookedTimeStart = bookedTimeStart;
	}

	public String getCustomerLocationDescription() {
		return customerLocationDescription;
	}

	public void setCustomerLocationDescription(String customerLocationDescription) {
		this.customerLocationDescription = customerLocationDescription;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getBookedTimeEnd() {
		return bookedTimeEnd;
	}

	public void setBookedTimeEnd(String bookedTimeEnd) {
		this.bookedTimeEnd = bookedTimeEnd;
	}

	@Override
	public String toString() {
		return "Order [status=" + status + ", orderReference=" + orderReference
				+ ", errors=" + errors + ", warnings=" + warnings
				+ ", duration=" + duration + ", price=" + price
				+ ", instructions=" + instructions + ", bookedTimeStart="
				+ bookedTimeStart + ", customerLocationDescription="
				+ customerLocationDescription + ", comments=" + comments
				+ ", bookedTimeEnd=" + bookedTimeEnd + "]";
	}

}