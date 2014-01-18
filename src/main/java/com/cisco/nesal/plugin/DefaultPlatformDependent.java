/**
 * 
 */
package com.cisco.nesal.plugin;

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

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformDependent#getSoftwareId()
     */
    @Override
    public String getSoftwareID() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformDependent#getTrustedStorePath()
     */
    @Override
    public String getTrustedStorePath() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformDependent#getUDI()
     */
    @Override
    public UDI getUDI() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformDependent#shutdown()
     */
    @Override
    public void shutdown() {
        // TODO Auto-generated method stub

    }

}
