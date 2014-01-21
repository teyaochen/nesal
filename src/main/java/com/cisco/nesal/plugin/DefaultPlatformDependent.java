/**
 * 
 */
package com.cisco.nesal.plugin;

import com.cisco.nesal.agent.SmartAgentException;
import com.cisco.nesal.agent.UDI;

/**
 * This class provides the default reference implementation for
 * IPlatformDependent interface. Software product can use this class as example
 * when customizing its own implementation.
 */
public class DefaultPlatformDependent implements IPlatformDependent {

    /**
     * The constructor.
     */
    public DefaultPlatformDependent() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getSoftwareID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTrustedStorePath() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UDI getUDI() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void shutdown() throws SmartAgentException {
        // TODO Auto-generated method stub
        
    }
}
