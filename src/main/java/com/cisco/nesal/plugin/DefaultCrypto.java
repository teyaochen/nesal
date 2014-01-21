/**
 * 
 */
package com.cisco.nesal.plugin;

import java.security.MessageDigest;

import com.cisco.nesal.agent.CSR;
import com.cisco.nesal.agent.CSR.CSRFormat;
import com.cisco.nesal.agent.Certificate;
import com.cisco.nesal.agent.SmartAgentException;

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

    @Override
    public void init(String rootCA) throws SmartAgentException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void shutdown() throws SmartAgentException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String generateSignature(String key, String data,
            MessageDigestAlgorithm algorithm) throws SmartAgentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CSR getCSR(String udi, CSRFormat csrOutputFormat,
            MessageDigestAlgorithm algorithm) throws SmartAgentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageDigest hashMessage(String message,
            MessageDigestAlgorithm algorithm) throws SmartAgentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Certificate parseCertificate(String cert) throws SmartAgentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean validateNodeCertificate(String cert, String subCA,
            String privateKey) throws SmartAgentException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validateSignature(String cert, String data,
            String signature, MessageDigestAlgorithm algorithm)
            throws SmartAgentException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean validateSigningCertificate(String cert)
            throws SmartAgentException {
        // TODO Auto-generated method stub
        return false;
    }

}
