package com.cisco.nesal.agent;

import com.cisco.nesal.internal.RubySample;
import com.cisco.nesal.plugin.ICommunication;
import com.cisco.nesal.plugin.ICrypto;
import com.cisco.nesal.plugin.IPlatformDependent;
import com.cisco.nesal.plugin.IPlatformIndependent;

/**
 * This class represents the Admin and Management services provided by Smart
 * Agent.
 * 
 */
public class SmartAgent {

    /**
     * Constructs an instance of SmartAgent class. Product that wants to use
     * Smart Agent services needs to supplied the implementation of the required
     * interface as parameters to this SmartAgent constructor.
     * 
     * @param commImpl
     *            The implementation of ICommunication interface provided by the
     *            plugin.
     * @param piImpl
     *            The implementation of IPlatformIndependent interface provided
     *            by the plugin.
     * @param pdImpl
     *            The implementation of IPlatformDependent interface provided by
     *            the plugin.
     * @param cryptoImpl
     *            The implementation of ICrypto interface provided by the
     *            plugin.
     * @param listener
     *            The listener that will receive global notification. This is
     *            optional and can be set yo null.
     */
    public SmartAgent(ICommunication commImpl, IPlatformIndependent piImpl,
            IPlatformDependent pdImpl, ICrypto cryptoImpl,
            ISmartAgentNotificationListener listener) {

        // Remove these test code
        RubySample rubySample = new RubySample(1, 2);
        rubySample.configure(commImpl, piImpl, pdImpl, cryptoImpl);
        rubySample.bar(1, 2);

    }

    /**
     * Shuts down the Smart Agent.
     * <p>
     * During Smart Agent shutdown, it will:
     * <ol>
     * <li>Release allocated resources</li>
     * <li>Reject all the subsequence requests</li>
     * </ol>
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode shutdown() {
        return null;
    }

    /**
     * Enable Smart Licensing on the product instance and turn off any other
     * licensing technology on the product if any.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode enable() {
        return null;
    }

    /**
     * Check whether the Samrt Agent is enabled.
     * 
     * @return True if Smart Agent is enabled; false otherwise.
     */
    public boolean isEnabled() {
        return false;
    }

    /**
     * Disable Smart Licensing on the product instance. During disable, smart
     * agent will remove certificate, inform Cisco Licensing Cloud. If the
     * agent is registered this will also cause a deregister.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode disable() {
        return null;
    }

    /**
     * Register this product instance with Cisco Licensing Cloud using the given
     * token. Upon successful registration the agent will send the current
     * entitlement usage information to Cisco. Every 30 days the agent will
     * automatically renew the registration. The token are sent to Cisco in the
     * registration message but are not saved on the storage.
     * 
     * @param token
     *            The token obtained from the Cisco Smart Licensing portal.
     * @param force
     *            If true, force the registration even if it has been
     *            registered.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode register(String token, boolean force) {
        return null;
    }

    /**
     * De-register this product instance with the Cisco Licensing Cloud. Upon
     * successful de-registration, the agent will send the current entitlement
     * usage information to Cisco.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode deregister() {
        return null;
    }

    /**
     * Renews the ID certificate by sending renew message to the Cisco Licensing
     * Cloud.
     * <p>
     * Normally the renew operation is automatic and occurs as specified in the
     * previous register or renew response message. There may be times that
     * application needs to trigger a renew operation.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode renewIdCert() {
        return null;
    }

    /**
     * Renews the authorization by sending renew message to the Cisco Licensing
     * Cloud.
     * <p>
     * Normally the authorization renew operation is automatic and occurs as
     * specified in the previous AUTH response message (usually 30 days). There
     * may be times that application needs to trigger a renew operation.
     * 
     * @return The status of the operation.
     */
    public SmartAgentStatusCode renewAuth() {
        return null;
    }

    /**
     * Registers the listener for global event.
     * <p>
     * The onNotify() method in the listener will be called when there is global
     * event triggered.
     * 
     * @param listener
     *            The listener (callback) that will receive the notification.
     */
    public void addNotificationListener(ISmartAgentNotificationListener listener) {

    }

    /**
     * Gets the structured information associated with the agent.
     * 
     * @return The SmartAgentInfo object.
     */
    public SmartAgentInfo getSmartAgentInfo() {
        return null;
    }
}
