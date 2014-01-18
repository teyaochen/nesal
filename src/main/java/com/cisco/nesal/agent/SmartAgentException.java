package com.cisco.nesal.agent;

/**
 * Exception to be thrown when error occurred in License Agent operations.
 * 
 */
public class SmartAgentException extends Exception {

    private static final long serialVersionUID = 1L;
    private SmartAgentStatusCode statusCode;

    /**
     * Constructor of the exception.
     * 
     * @param statuCode
     */
    public SmartAgentException(SmartAgentStatusCode statuCode) {
        super();
        this.statusCode = statuCode;
    }

    /**
     * Gets the status code of the exception.
     * 
     * @return the statuCode
     */
    public SmartAgentStatusCode getStatuCode() {
        return statusCode;
    }
}
