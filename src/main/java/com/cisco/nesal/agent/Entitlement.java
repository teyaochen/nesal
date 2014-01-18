package com.cisco.nesal.agent;

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

    /**
     * Constructs an instance of Entitlement class.
     * 
     * @param entitlementTag
     *            The entitlement tag for which to create an instance for.
     * @param entitlementVersion
     *            The version of the entitlement tag.
     * @param notifyListener
     *            The listener that will be invoked to when entitlement
     *            notifications arrives.
     * @param appData
     *            This pointer will be passed to the listeners for the
     *            application to use. This is optional and can be null.
     */
    public Entitlement(String entitlementTag, String entitlementVersion,
            IEntitlementNotificationListener notifyListener,
            Object appData) {

    }

    /**
     * Requests an entitlement. If the agent has already connected and
     * registered with the Cisco Licensing Cloud then this method will return
     * success and request the entitlement from the Licensing Cloud in the
     * background. When the Licensing Cloud responds the agent will invoke the
     * onNotify method of the listener object that was passed into the
     * constructor if the enforcement mode changes from what was returned in the
     * enforceMode parameter.
     * <p>
     * If the Agent has not already connected to the Licensing Cloud it will
     * return success and the enforcement mode will be either
     * SmartAgentEnforceModeEval or SmartAgentEnforceModeEvalExpired.
     * <p>
     * If the Agent later connects to the Licensing Cloud the it will send the
     * list of all entitlements in use.
     * 
     * @param count
     *            The total count to be consumed. Repeated calls to this method
     *            with the same Entitlement instance will simply reset the total
     *            count.
     * @param enforceMode
     *            The enforcement mode to be used for this entitlement request. If
     *            and when the mode changes a SmartAgentEntitlementEnforceMode_t
     *            notification will be sent.
     *            
     * @return The status of the operation.
     */
    public SmartAgentStatusCode requestEntitlement(int count,
            EntitlementEnforceMode enforceMode) {
        return null;
    }

    /**
     * Releases the entitlement. Software product can release an entitlement if
     * it is not needed any more to smart agent and then agent can contact Cisco
     * backend for information updates etc.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode releaseEntitlement() {
        return null;
    }

}
