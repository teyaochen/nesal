/**
 * 
 */
package com.cisco.nesal.plugin;

import java.util.Locale;

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

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformIndependent#getLocale()
     */
    @Override
    public Locale getLocale() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformIndependent#shutdown()
     */
    @Override
    public void shutdown() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformIndependent#getHostname()
     */
    @Override
    public String getHostname() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.IPlatformIndependent#getCompVersion()
     */
    @Override
    public String getCompVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.IPlatformIndependent#syslog(com.cisco.nesal.plugin
     * .SysLogSeverity, java.lang.String)
     */
    @Override
    public void syslog(SysLogSeverity severity, String message) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.IPlatformIndependent#debugMessage(java.lang.String
     * )
     */
    @Override
    public void debugMessage(String message) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.IPlatformIndependent#errorMessage(java.lang.String
     * )
     */
    @Override
    public void errorMessage(String message) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.IPlatformIndependent#traceMessage(java.lang.String
     * )
     */
    @Override
    public void traceMessage(String message) {
        // TODO Auto-generated method stub

    }

}
