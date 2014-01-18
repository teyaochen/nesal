package com.cisco.nesal.agent;

/**
 * This interface represents a listener for receiving EntitlementNotification.
 * The class that is interested in processing EntitlementNotification should
 * implement this interface.
 */
public interface IEntitlementNotificationListener {

    /**
     * Invoked when EntitlementNotification arrives.
     * 
     * @param notification
     *            The notification for the entitlement.
     */
    public void onNotify(SmartAgentNotification notification);

}
