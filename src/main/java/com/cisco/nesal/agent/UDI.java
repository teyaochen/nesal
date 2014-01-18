package com.cisco.nesal.agent;

/**
 * UDI/SUDI/VUDI structure.
 * <p>
 * This structure contains the device identifier. Different types of values will
 * be used for different products. Most products use the PID:SN format
 * (product id and serial number).
 * <p>
 * Any product may have one or more of these members as elements in the UDI.
 * <p>
 * When setting the UDI in this structure all fields not in use should be set to
 * null.
 * 
 * 
 */
public class UDI {

    private String pid;
    private String sn;
    private String vid;
    private String suvi;
    private String uuid;
    private String hostIdentifier;
    private String macAddress;
    private String ipAddress;

    /**
     * Gets the Product ID.
     * 
     * @return The Product ID.
     */
    public String getPID() {
        return pid;
    }

    /**
     * Gets the Serial Number.
     * 
     * @return The Serial Number.
     */
    public String getSN() {
        return sn;
    }

    /**
     * Gets the VID.
     * 
     * @return The VID.
     */
    public String getVID() {
        return vid;
    }

    /**
     * Gets the SUVI.
     * 
     * @return The SUVI.
     */
    public String getSUVI() {
        return suvi;
    }

    /**
     * Gets the UUID.
     * 
     * @return The UUID.
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Gets the host identifier.
     * 
     * @return The host identifier.
     */
    public String getHostIdentifier() {
        return hostIdentifier;
    }

    /**
     * Gets the MAC address.
     * 
     * @return The MAC address.
     */
    public String getMACAddress() {
        return macAddress;
    }

    /**
     * Gets the IP address.
     * 
     * @return The IP address.
     */
    public String getIPAddress() {
        return ipAddress;
    }

}
