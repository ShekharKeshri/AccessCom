package com.maxoptra.api.v1.enums;

/**
 * 
 * HTTP_METHOD
 * 
 */
public enum HTTP_METHOD {
    /**
     * Http method enum value
     */
    POST;

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     */
    public String value() {
        return name();
    }

    /**
     * Gets the value of the v property.
     * 
     * @param v
     *            allowed object is {@link String }
     * @return possible object is {@link HTTP_METHOD }
     */
    public static HTTP_METHOD fromValue(String v) {
        return valueOf(v);
    }
}