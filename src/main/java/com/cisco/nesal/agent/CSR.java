/**
 * 
 */
package com.cisco.nesal.agent;

import java.security.PublicKey;

/**
 * This class represent a Certificate Signing Request (CSR).
 *
 */
public class CSR {
    /**
     * Output format type of Certificate Signing Request.
     * 
     */
    public enum CSRFormat {
        /** Certificate in PEM format. */
        PEM,
        /** Certificate in DER format. */
        DER,
        /** Certificate in B64 format. */
        B64
    }

    private PublicKey publicKey;
    private String rawCSR;
    

    /**
     * The constructor.
     * 
     * @param publicKey The public key.
     * @param rawCSR The raw CSR string.
     */
    public CSR(PublicKey publicKey, String rawCSR) {
        super();
        this.publicKey = publicKey;
        this.rawCSR = rawCSR;
    }


    /**
     * Gets the public key associated with this CSR.
     *
     * @return The public key.
     */
    public PublicKey getPublicKey() {
        return publicKey;
    }


    /**
     * Gets the CSR string.
     *
     * @return The CSR string.
     */
    public String getRawCSR() {
        return rawCSR;
    }
    
}
