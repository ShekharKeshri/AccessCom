package com.maxoptra.api.v1.model.response;

public class Warnings
{
    private Warning warning;

    public Warning getWarning ()
    {
        return warning;
    }

    public void setWarning (Warning warning)
    {
        this.warning = warning;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [warning = "+warning+"]";
    }
}