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

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICommunication#init()
     */
    @Override
    public void init() throws SmartAgentException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.cisco.nesal.plugin.ICommunication#sendMessage(com.cisco.nesal.plugin
     * .MessageType, java.lang.String, java.lang.String)
     */
    @Override
    public String sendMessage(MessageType messageType, String messageData,
            String idToken) throws SmartAgentException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.cisco.nesal.plugin.ICommunication#shutdown()
     */
    @Override
    public void shutdown() {
        // TODO Auto-generated method stub

    }

}
