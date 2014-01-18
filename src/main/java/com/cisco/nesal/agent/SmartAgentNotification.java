package com.cisco.nesal.agent;

/**
 * This class represents a notification from Smart Agent.
 * 
 */
public class SmartAgentNotification {
    /**
     * Notification types used for both entitlement notifications and global
     * notifications.
     */
    public enum NotificationType {
        /** */
        NotifyInvalid,
        /** */
        NotifyReady,
        /** */
        NotifyEnabled,
        /** */
        NotifyDisabled,
        /** */
        NotifyRegisterFailed,
        /** */
        NotifyEnforcementMode,
        /** */
        NotifyRegisterSuccess,
        /** */
        NotifyIdCertExpired,
        /** */
        NotifyIdCertRenewSuccess,
        /** */
        NotifyIdCertRenewFail,
        /** */
        NotifyAuthRenewSuccess,
        /** */
        NotifyAuthRenewFailure,
        /** */
        NotifyCommFailure,
        /** */
        CommRestored,
        /** */
        NotifyIdCertNotStarted,
        /** */
        NotifyHARole,
        /** */
        NotifyHAChassisRole;
    }

    NotificationType notificationType;

    /**
     * Get the type of notification.
     * 
     * @return Type of notification.
     */
    public NotificationType getNotificationType() {
        return notificationType;
    }

}
