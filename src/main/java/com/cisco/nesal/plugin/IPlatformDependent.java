package com.cisco.nesal.plugin;

import java.util.Locale;

import com.cisco.nesal.agent.UDI;

/**
 * This interface will be implemented by the software product so the agent can
 * get Platform Dependent (PD) information.
 * 
 */
public interface IPlatformDependent {

    /**
     * Gets the software product name and version. This will be sent back to the
     * licensing cloud to help identify this software product
     * 
     * @return The Software tag name.
     */
    public String getSoftwareID();

    /**
     * Gets the path to the trusted storage directory.
     * <p>
     * The Agent will use this path to write out data that needs to be
     * protected. The customer should not have access to this area. This will be
     * called during init method.
     * <p>
     * As of version 1.0 the Agent will write two certificates and some other
     * persistence data. Three files will be created and will use approximately
     * 6k of space.
     * 
     * @return The path to the trusted storage directory.
     */
    public String getTrustedStorePath();

    /**
     * Gets the UDI of this device.
     * <p>
     * Calls the PD code to get the UDI of this device. This will be called
     * during system boot and periodically at run time.
     * <p>
     * Example: if the UDI consists of the PID and SN then the implementation
     * will fill the pid and sn members of the returnUDI object. All other
     * members will be set to null.
     * 
     * @return The UDI of this device.
     */
    public UDI getUDI();

//    /**
//     * Initializes the object.
//     * <p>
//     * This is the first call made to the software product. The software
//     * product can do any initialization at this time. This call will be made
//     * only after Smart Licensing has been enabled.
//     */
//    public void init();

    /**
     * Shuts down the object..
     * <p>
     * This is the last call made to the software product library. It will be
     * called if the agent is shutdown gracefully.
     */
    public void shutdown();

}
