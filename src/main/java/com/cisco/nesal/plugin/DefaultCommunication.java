/**
 * 
 */
package com.cisco.nesal.plugin;

import com.cisco.nesal.agent.SmartAgentException;

/**
 * This class provides the default reference implementation for ICommunication
 * interface. Software product can use this class as example when customizing
 * its own implementation.
 */
public class DefaultCommunication implements ICommunication {

    /**
     * The constructor.
     */
    public DefaultCommunication() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws SmartAgentException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String sendMessage(MessageType messageType, String messageData,
            String idToken) throws SmartAgentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void shutdown() throws SmartAgentException {
        // TODO Auto-generated method stub
        
    }

    
}
