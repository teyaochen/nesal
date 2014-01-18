/**
 * 
 */
package com.cisco.nesal.plugin;

import java.security.MessageDigest;

import com.cisco.nesal.agent.CSR;
import com.cisco.nesal.agent.CSR.CSRFormat;
import com.cisco.nesal.agent.Certificate;

/**
 * This class provides the default reference implementation for ICrypto
 * interface. Software product can use this class as example when customizing
 * its own implementation.
 */
public class DefaultCrypto implements ICrypto {

    /**
     * The constructor.
     */
    public DefaultCrypto() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#init(java.lang.String)
     */
    @Override
    public void init(String rootCA) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#shutdown()
     */
    @Override
    public void shutdown() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#generateSignature(java.lang.String,
     * java.lang.String, com.cisco.nesal.plugin.MessageDigestAlgorithm)
     */
    @Override
    public String generateSignature(String key, String data,
            MessageDigestAlgorithm digestHash) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#getCSR(java.lang.String,
     * com.cisco.nesal.plugin.CSRFormat, com.cisco.nesal.plugin.MessageDigestAlgorithm)
     */
    @Override
    public CSR getCSR(String udi, CSRFormat csrOutputFormat,
            MessageDigestAlgorithm digestHash) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#hashMessage(java.lang.String,
     * com.cisco.nesal.plugin.MessageDigestAlgorithm)
     */
    @Override
    public MessageDigest hashMessage(String message, MessageDigestAlgorithm hashType) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#parseCertificate(java.lang.String)
     */
    @Override
    public Certificate parseCertificate(String cert) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.ICrypto#validateNodeCertificate(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public boolean validateNodeCertificate(String cert, String subCA,
            String privateKey) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICrypto#validateSignature(java.lang.String,
     * java.lang.String, java.lang.String,
     * com.cisco.nesal.plugin.MessageDigestAlgorithm)
     */
    @Override
    public boolean validateSignature(String cert, String data,
            String signature, MessageDigestAlgorithm digestHash) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.ICrypto#validateSigningCertificate(java.lang.String
     * )
     */
    @Override
    public boolean validateSigningCertificate(String cert) {
        // TODO Auto-generated method stub
        return false;
    }

}
