package com.maxoptra.api.v1.model.response;

public class Errors
{
    private Error error;

    public Error getError ()
    {
        return error;
    }

    public void setError (Error error)
    {
        this.error = error;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [error = "+error+"]";
    }
}