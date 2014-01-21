package com.cisco.nesal.agent;

import java.util.Date;

/**
 * The Entitlement class provides the interface for an application or feature in
 * software product to request an entitlement (also called a license).
 * <p>
 * The term entitlement is used to distinguish this interface from previous node
 * locked licensing solutions.
 */
public class Entitlement {

    /**
     * The enforcement mode to be use for an entitlement.
     * 
     */
    public enum EntitlementEnforceMode {
        /** Error condition state. */
        SmartAgentEnforceModeInvalid,
        /**  */
        SmartAgentEnforceModeInit,
        /**  */
        SmartAgentEnforceModeWaiting,
        /**  */
        SmartAgentEnforceModeInCompliance,
        /**  */
        SmartAgentEnforceModeOutOfCompliance,
        /**  */
        SmartAgentEnforceModeOverage,
        /**  */
        SmartAgentEnforceModeEval,
        /**  */
        SmartAgentEnforceModeEvalExpired,
        /**  */
        SmartAgentEnforceModeGracePeriod,
        /**  */
        SmartAgentEnforceModeGracePeriodExpired,
        /**  */
        SmartAgentEnforceModeDisabled,
        /**  */
        SmartAgentEnforceModeInvalidTag
    }

    private String entitlementTag;
    private String entitlementVersion;
    private EntitlementEnforceMode enforceMode;
    private long daysLeft;
    private Date requestedDate;
    private int requestedCount;
    private String vendor;
    private IEntitlementNotificationListener notifyListener;
    private Object appData;
    
    /**
     * Constructs an instance of Entitlement class. For internal use only.
     * 
     * @param entitlementTag
     *            The entitlement tag for which to create an instance for.
     * @param entitlementVersion
     *            The version of the entitlement tag.
     * @param count
     *            The total count to be consumed. Repeated calls to this method
     *            with the same Entitlement instance will simply reset the total
     *            count.
     * @param enforceMode
     *            The enforcement mode to be used for this entitlement request.
     *            If and when the mode changes a
     *            SmartAgentEntitlementEnforceMode_t notification will be sent.
     * @param notifyListener
     *            The listener that will be invoked to when entitlement
     *            notifications arrives.
     * @param appData
     *            This pointer will be passed to the listeners for the
     *            application to use. This is optional and can be null.
     */
    Entitlement(String entitlementTag, String entitlementVersion,
            int requestedCount, EntitlementEnforceMode enforceMode, 
            IEntitlementNotificationListener notifyListener,
            Object appData) {
        super();
        this.entitlementTag = entitlementTag;
        this.entitlementVersion = entitlementVersion;
        this.enforceMode = enforceMode;
        this.requestedCount = requestedCount;
        this.vendor = entitlementVersion;
        this.notifyListener = notifyListener;
        this.appData = appData;   
    }

    /**
     * Gets the entitlement tag.
     * 
     * @return The entitlement tag.
     */
    public String getEntitlementTag() {
        return entitlementTag;
    }

    /**
     * Gets the entitlement version.
     * 
     * @return The entitlement version.
     */
    public String getEntitlementVersion() {
        return entitlementVersion;
    }

    /**
     * Gets the current enforce mode.
     * 
     * @return The enforce mode.
     */
    public EntitlementEnforceMode getEnforceMode() {
        return enforceMode;
    }

    /**
     * Gets the days left for the current enforce mode.
     * 
     * @return Number of days left.
     */
    public long getDaysLeft() {
        return daysLeft;
    }

    /**
     * Gets the requested date, with millisecond precision.
     * 
     * @return The requested date.
     */
    public Date getRequestedDate() {
        return requestedDate;
    }

    /**
     * Gets the requested count.
     * 
     * @return The requested count.
     */
    public int getRequestedCount() {
        return requestedCount;
    }

    /**
     * Gets the vendor string.
     * 
     * @return The vendor string.
     */
    public String getVendor() {
        return vendor;
    }

}
