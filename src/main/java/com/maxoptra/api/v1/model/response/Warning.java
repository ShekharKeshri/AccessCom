package com.maxoptra.api.v1.model.response;

public class Warning
{
    private String warningCode;

    private String warningMessage;

    public String getWarningCode ()
    {
        return warningCode;
    }

    public void setWarningCode (String warningCode)
    {
        this.warningCode = warningCode;
    }

    public String getWarningMessage ()
    {
        return warningMessage;
    }

    public void setWarningMessage (String warningMessage)
    {
        this.warningMessage = warningMessage;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [warningCode = "+warningCode+", warningMessage = "+warningMessage+"]";
    }
}