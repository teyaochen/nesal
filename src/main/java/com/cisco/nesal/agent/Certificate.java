package com.cisco.nesal.agent;

import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.List;

/**
 * Certificate class contains information of a certificate. The information is
 * usually from the result of parsing a certificate.
 * 
 */
public class Certificate {
    private String commonName;
    private String serialNumber;
    private List<SUDI> haSudiList;
    private int versionNumber;
    private Date issuedDate;
    private Date expiredDate;

    
    /**
     * Gets the common name of the certificate.
     *
     * @return The common name of the certificate.
     */
    public String getCommonName() {
        return commonName;
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
     * Gets the HA SUDI list.
     * 
     * @return The HA SUDI list.
     */
    public List<SUDI> getHaSudiList() {
        return haSudiList;
    }

    /**
     * Gets the version number.
     * 
     * @return The version number.
     */
    public int getVersionNumber() {
        return versionNumber;
    }

    /**
     * Gets the issued date, with millisecond precision.
     * 
     * @return The the issued date.
     */
    public Date getIssuedDate() {
        return issuedDate;
    }

    /**
     * Gets the expired date, with millisecond precision.
     * 
     * @return The expired date.
     */
    public Date getExpiredDate() {
        return expiredDate;
    }
}
