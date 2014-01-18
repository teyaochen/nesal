package com.cisco.nesal.agent;

/**
 * This is the interface for receiving Smart Agent notification. The application
 * should implement the onNotify method and add it with SmartAgent's
 * addNotificationListener method. The agent will call this method when any
 * global notification occurs.
 */
public interface ISmartAgentNotificationListener {

    /**
     * The application should implement the onNotification method to receive
     * notification.
     * 
     * @param notification
     *            The notification object.
     */
    public void onNotify(SmartAgentNotification notification);
}
