package com.cisco.nesal.agent;

/**
 * This class represents Secured Unique Device Identifier (SUDI).
 */
public class SUDI {

    private String pid;
    private String serialNumber;
    private String vid;
    private String suvi;
    private String uuid;
    private String hostIdentifier;
    private String macAddress;

    /**
     * The Constructor.
     * 
     * @param pid
     *            Product Identifier.
     * @param serialNumber
     *            Serial number.
     * @param vid
     *            Version Identifier.
     * @param suvi
     *            Virtural identifier often used by software only devices such as
     *            software routers.
     * @param uuid
     *            Universally unique identifier.   
     * @param hostIdentifier
     *            The system Host Identifier.
     * @param macAddress
     *            The system MAC address.
     */
    public SUDI(String pid, String serialNumber, String vid, String suvi,
            String uuid, String hostIdentifier, String macAddress) {
        super();
        this.pid = pid;
        this.serialNumber = serialNumber;
        this.vid = vid;
        this.suvi = suvi;
        this.uuid = uuid;
        this.hostIdentifier = hostIdentifier;
        this.macAddress = macAddress;
    }

    /**
     * Gets the Product Identifier.
     *
     * @return The Product Identifier.
     */
    public String getPid() {
        return pid;
    }

    /**
     * Gets the serial number.
     *
     * @return The serial number.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Gets the Version Identifier.
     *
     * @return The Version Identifier.
     */
    public String getVid() {
        return vid;
    }

    /**
     * Gets the virtural identifier often used by software only devices.
     *
     * @return The SUVI string.
     */
    public String getSuvi() {
        return suvi;
    }

    /**
     * Gets the universally unique identifier.
     *
     * @return The universally unique identifier.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Gets the system Host Identifier.
     * 
     * @return The system Host Identifier.
     */
    public String getHostIdentifier() {
        return hostIdentifier;
    }

    /**
     * Gets the system MAC address.
     *
     * @return The system MAC address.
     */
    public String getMacAddress() {
        return macAddress;
    }

    
    
}
