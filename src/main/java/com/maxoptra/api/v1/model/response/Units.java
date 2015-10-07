package com.maxoptra.api.v1.model.response;

import javax.xml.bind.annotation.XmlAttribute;

public class Units
{
    private String durationUnits;

    private String distanceUnits;

    private String timeZoneOffset;

    private String speedUnits;

    private String timeZone;

    private String currency;

    @XmlAttribute
    public String getDurationUnits ()
    {
        return durationUnits;
    }

    public void setDurationUnits (String durationUnits)
    {
        this.durationUnits = durationUnits;
    }

    @XmlAttribute
    public String getDistanceUnits ()
    {
        return distanceUnits;
    }

    public void setDistanceUnits (String distanceUnits)
    {
        this.distanceUnits = distanceUnits;
    }

    @XmlAttribute
    public String getTimeZoneOffset ()
    {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset (String timeZoneOffset)
    {
        this.timeZoneOffset = timeZoneOffset;
    }

    @XmlAttribute
    public String getSpeedUnits ()
    {
        return speedUnits;
    }

    public void setSpeedUnits (String speedUnits)
    {
        this.speedUnits = speedUnits;
    }

    @XmlAttribute
    public String getTimeZone ()
    {
        return timeZone;
    }

    public void setTimeZone (String timeZone)
    {
        this.timeZone = timeZone;
    }

    @XmlAttribute
    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [durationUnits = "+durationUnits+", distanceUnits = "+distanceUnits+", timeZoneOffset = "+timeZoneOffset+", speedUnits = "+speedUnits+", timeZone = "+timeZone+", currency = "+currency+"]";
    }
}