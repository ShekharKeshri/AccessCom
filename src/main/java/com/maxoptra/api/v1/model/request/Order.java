package com.maxoptra.api.v1.model.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order implements Serializable
{
	private String partsOrdered;
    private String toolAndSpareParts;
    private Skills skills;
    private String partsDeliveryTime;
    private JobTypes jobTypes;
    private Client client;
    private CustomFields customFields;
    private CustomerLocation customerLocation;
    private String partsShipped;
    private String resource;
    private String orderReference;
    private ExcludeList excludeList;
    private IncludeList includeList;
    private String workDescription;
    private String allocatedDate;
    private String price;
    private String releaseDate;
    private String areaOfControl;
    private String priority;
    private String dueDate;
    private String onHold;
    private String durationDrop;
    private String partsOrderedFor;
    private String content;
    
    @XmlElement
    public String getToolAndSpareParts ()
    {
        return toolAndSpareParts;
    }

    public void setToolAndSpareParts (String toolAndSpareParts)
    {
        this.toolAndSpareParts = toolAndSpareParts;
    }

    @XmlElement
    public String getAreaOfControl ()
    {
        return areaOfControl;
    }

    public void setAreaOfControl (String areaOfControl)
    {
        this.areaOfControl = areaOfControl;
    }

    @XmlElement
    public String getReleaseDate ()
    {
        return releaseDate;
    }

    public void setReleaseDate (String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    @XmlElement
    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    @XmlElement
    public Client getClient ()
    {
    	if(client == null){
    		client = new Client();
    	}
        return client;
    }

    public void setClient (Client client)
    {
        this.client = client;
    }

    @XmlElement
    public CustomerLocation getCustomerLocation ()
    {
    	if(customerLocation == null){
    		customerLocation = new CustomerLocation();
    	}
        return customerLocation;
    }

    public void setCustomerLocation (CustomerLocation customerLocation)
    {
        this.customerLocation = customerLocation;
    }

    @XmlElement
    public CustomFields getCustomFields ()
    {
    	if(customFields == null){
    		customFields = new CustomFields();
    	}
        return customFields;
    }

    public void setCustomFields (CustomFields customFields)
    {
        this.customFields = customFields;
    }

    @XmlElement
    public String getPriority ()
    {
        return priority;
    }

    public void setPriority (String priority)
    {
        this.priority = priority;
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
    public String getDueDate ()
    {
        return dueDate;
    }

    public void setDueDate (String dueDate)
    {
        this.dueDate = dueDate;
    }

    @XmlElement
    public String getDurationDrop ()
    {
        return durationDrop;
    }

    public void setDurationDrop (String durationDrop)
    {
        this.durationDrop = durationDrop;
    }

    @XmlElement
    public String getWorkDescription ()
    {
        return workDescription;
    }

    public void setWorkDescription (String workDescription)
    {
        this.workDescription = workDescription;
    }

    @XmlElement
	public String getPartsOrdered() {
		return partsOrdered;
	}

	public void setPartsOrdered(String partsOrdered) {
		this.partsOrdered = partsOrdered;
	}

	@XmlElement
	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	@XmlElement
	public String getPartsDeliveryTime() {
		return partsDeliveryTime;
	}

	public void setPartsDeliveryTime(String partsDeliveryTime) {
		this.partsDeliveryTime = partsDeliveryTime;
	}

	@XmlElement
	public JobTypes getJobTypes() {
		return jobTypes;
	}

	public void setJobTypes(JobTypes jobTypes) {
		this.jobTypes = jobTypes;
	}

	@XmlElement
	public String getPartsShipped() {
		return partsShipped;
	}

	public void setPartsShipped(String partsShipped) {
		this.partsShipped = partsShipped;
	}

	@XmlElement
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	@XmlElement
	public ExcludeList getExcludeList() {
		return excludeList;
	}

	public void setExcludeList(ExcludeList excludeList) {
		this.excludeList = excludeList;
	}

	@XmlElement
	public IncludeList getIncludeList() {
		return includeList;
	}

	public void setIncludeList(IncludeList includeList) {
		this.includeList = includeList;
	}

	@XmlElement
	public String getAllocatedDate() {
		return allocatedDate;
	}

	public void setAllocatedDate(String allocatedDate) {
		this.allocatedDate = allocatedDate;
	}

	@XmlElement
	public String getOnHold() {
		return onHold;
	}

	public void setOnHold(String onHold) {
		this.onHold = onHold;
	}

	@XmlElement
	public String getPartsOrderedFor() {
		return partsOrderedFor;
	}

	public void setPartsOrderedFor(String partsOrderedFor) {
		this.partsOrderedFor = partsOrderedFor;
	}

	@XmlElement
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}