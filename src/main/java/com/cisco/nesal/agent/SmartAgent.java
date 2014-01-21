package com.cisco.nesal.agent;

import java.util.List;

import com.cisco.nesal.agent.Entitlement.EntitlementEnforceMode;
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

    private UDI udi;
    private List<Entitlement> entitlementList;
    private Certificate idCert;
    private Certificate signingCert;
    private String version;
    private TechSupportInfo techSupportInfo;

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
     *            optional and can be set to null.
     */
    public SmartAgent(ICommunication commImpl, IPlatformIndependent piImpl,
            IPlatformDependent pdImpl, ICrypto cryptoImpl,
            ISmartAgentNotificationListener listener) {

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
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void shutdown() throws SmartAgentException {

    }

    /**
     * Enable Smart Licensing on the product instance and turn off any other
     * licensing technology on the product if any.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void enable() throws SmartAgentException {

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
     * agent will remove certificate, inform Cisco Licensing Cloud. If the agent
     * is registered this will also cause a de-registeration.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void disable() throws SmartAgentException {

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
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void register(String token, boolean force)
            throws SmartAgentException {

    }

    /**
     * De-register this product instance with the Cisco Licensing Cloud. Upon
     * successful de-registration, the agent will send the current entitlement
     * usage information to Cisco.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void deregister() throws SmartAgentException {

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
     * @param entitlementTag
     *            The entitlement tag for which to request for.
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
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void requestEntitlement(String entitlementTag,
            String entitlementVersion, int count,
            EntitlementEnforceMode enforceMode,
            IEntitlementNotificationListener notifyListener, Object appData)
            throws SmartAgentException {

    }

    /**
     * Releases the entitlement. Software product can release an entitlement if
     * it is not needed any more to smart agent and then agent can contact Cisco
     * backend for information updates etc.
     * 
     * @param entitlement The entitlement to release.
     * 
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void releaseEntitlement(Entitlement entitlement) throws SmartAgentException {

    }

    /**
     * Renews the ID certificate by sending renew message to the Cisco Licensing
     * Cloud.
     * <p>
     * Normally the renew operation is automatic and occurs as specified in the
     * previous register or renew response message. There may be times that
     * application needs to trigger a renew operation.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void renewIdCert() throws SmartAgentException {

    }

    /**
     * Renews the authorization by sending renew message to the Cisco Licensing
     * Cloud.
     * <p>
     * Normally the authorization renew operation is automatic and occurs as
     * specified in the previous AUTH response message (usually 30 days). There
     * may be times that application needs to trigger a renew operation.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void renewAuth() throws SmartAgentException {

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
    public TechSupportInfo getSmartAgentInfo() {
        return techSupportInfo;
    }

    /**
     * Gets the UDI information.
     * 
     * @return The UDI object containing the information.
     */
    public UDI getUDI() {
        return udi;
    }

    /**
     * Gets the list of entitlement that has been requested..
     * 
     * @return The entitlement list.
     */
    public List<Entitlement> getEntitlementList() {
        return entitlementList;
    }

    /**
     * Gets the ID Certificate.
     * 
     * @return The ID Certificate.
     */
    public Certificate getIDCertificate() {
        return idCert;
    }

    /**
     * Gets the Signing Certificate.
     * 
     * @return The Signing Certificate.
     */
    public Certificate getSigningCertificate() {
        return signingCert;
    }

    /**
     * Gets the version of the agent.
     * 
     * @return The version string.
     */
    public String getVersion() {
        return version;
    }

}
