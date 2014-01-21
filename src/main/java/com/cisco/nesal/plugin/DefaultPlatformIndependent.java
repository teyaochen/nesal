/**
 * 
 */
package com.cisco.nesal.plugin;

import java.util.Locale;

import com.cisco.nesal.agent.SmartAgentException;

/**
 * This class provides the default reference implementation for
 * IPlatformIndependent interface. Software product can use this class as
 * example when customizing its own implementation.
 */
public class DefaultPlatformIndependent implements IPlatformIndependent {

    /**
     * The constructor.
     */
    public DefaultPlatformIndependent() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void shutdown() throws SmartAgentException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Locale getLocale() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getHostname() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCompVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void syslog(SysLogSeverity severity, String message) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void debugMessage(String message) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void errorMessage(String message) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void traceMessage(String message) {
        // TODO Auto-generated method stub
        
    }  
}
