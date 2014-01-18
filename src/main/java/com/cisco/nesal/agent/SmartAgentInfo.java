package com.cisco.nesal.agent;

import java.util.List;

import com.cisco.nesal.agent.Entitlement.EntitlementEnforceMode;

/**
 * This class represents the structured information of the Smart Agent.
 * 
 */
public class SmartAgentInfo {

    /**
     * This inner class of SmartAgentInfo contains entitlement information in a
     * data structure.
     * 
     */
    public static class EntitlementInfo {
        private String entitlementTag;
        private String entitlementVersion;
        private EntitlementEnforceMode enforceMode;
        private long requestedDate;
        private int requestedCount;
        private String vendorString;

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
         * Gets the enforce mode.
         * 
         * @return The enforce mode.
         */
        public EntitlementEnforceMode getEnforceMode() {
            return enforceMode;
        }


        /**
         * Gets the requested date, with millisecond precision.
         * 
         * @return The requested date.
         */
        public long getRequestedDate() {
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
        public String getVendorString() {
            return vendorString;
        }
    }
    
    /**
     * This inner class of SmartAgentInfo contains version information in a data
     * structure.
     * 
     * <p>
     * TODO - simply this since it contains only one attribute?
     */
    public static class VersionInfo {
        private String version;

        /**
         * Gets the version.
         * 
         * @return The version.
         */
        public String getVersion() {
            return version;
        }
    }

    /**
     * This inner class of SmartAgentInfo contains certificate information in a
     * data structure.
     * 
     */
    public static class CertificateInfo {

        private Certificate idCert;
        private Certificate signingCert;

        /**
         * Gets the ID Certificate.
         * 
         * @return The ID Certificate.
         */
        public Certificate getIdCert() {
            return idCert;
        }

        /**
         * Gets the Signing Certificate.
         * 
         * @return The Signing Certificate.
         */
        public Certificate getSigningCert() {
            return signingCert;
        }
    }

    /**
     * This inner class of SmartAgentInfo contains scheduled job information in
     * a data structure.
     * 
     */
    public static class ScheduledJobInfo {
        private String jobName;
        private boolean recurringFlag;
        private boolean canceledFlag;
        private long nextOccurrenceDate;

        /**
         * Gets the job name.
         * 
         * @return The job name.
         */
        public String getJobName() {
            return jobName;
        }

        /**
         * Gets the recurring flag.
         * 
         * @return The recurring flag.
         */
        public boolean isRecurringFlag() {
            return recurringFlag;
        }

        /**
         * Gets the canceled flag.
         * 
         * @return The canceled flag.
         */
        public boolean isCanceledFlag() {
            return canceledFlag;
        }

        /**
         * Gets the next occurrence date, with millisecond precision.
         * 
         * @return The next occurrence date.
         */
        public long getNextOccurrenceDate() {
            return nextOccurrenceDate;
        }
    }

    /**
     * This inner class of SmartAgentInfo contains "enable: information in a
     * data structure.
     * 
     * <p>
     * TODO - simply this since it contains only one attribute?
     */
    public static class EnableInfo {
        private boolean enableFlag;

        /**
         * Gets the enable flag.
         * 
         * @return The enable flag.
         */
        public boolean isEnableFlag() {
            return enableFlag;
        }
    }

    /**
     * This inner class of SmartAgentInfo contains all other related information
     * in a data structure.
     * 
     * <p>
     * TODO - The naming of the class is dubious. Any better suggestion?
     */
    public static class OtherInfo {
        /**
         * The transport to use when sending and receiving messages for.
         */
        public enum TransportMode {
            /** Invalid type, this is an error */
            SmartAgentTestTransportInvalid,
            /**
             * Send the messages to the unit test which will reply with a dummy
             * response.
             */
            SmartAgentTestTransportLoopBack,
            /** Use the proper Call Home send routine. */
            SmartAgentTestTransportCallHome,
            /** Use the direct HTTP to the cloud receiver. */
            SmartAgentTestTransportHTTP
        }


        private String componentVersion;
        private int currentStateId;
        private TransportMode transportMode;
        private String httpURL;

        /**
         * Gets the component version.
         * 
         * @return The component version.
         */
        public String getComponentVersion() {
            return componentVersion;
        }

        /**
         * Gets the current state ID.
         * 
         * @return The current state ID.
         */
        public int getCurrentStateId() {
            return currentStateId;
        }

        /**
         * Gets the transport mode.
         * 
         * @return The transport mode.
         */
        public TransportMode getTransportMode() {
            return transportMode;
        }

        /**
         * Gets the HTTP URL.
         * 
         * @return The HTTP URL.
         */
        public String getHttpURL() {
            return httpURL;
        }
    }

    /**
     * This inner class of SmartAgentInfo contains status information in a data
     * structure.
     * 
     */
    public static class StatusInfo {
        private EntitlementEnforceMode status;
        private String statusName;
        private long daysLeft;

        /**
         * Gets the status.
         * 
         * @return The status.
         */
        public EntitlementEnforceMode getStatus() {
            return status;
        }

        /**
         * Gets the status name.
         * 
         * @return The status name.
         */
        public String getStatusName() {
            return statusName;
        }

        /**
         * Gets the days left.
         * 
         * @return The days left.
         */
        public long getDaysLeft() {
            return daysLeft;
        }
    }

    private List<EntitlementInfo> entitlementInfoList;
    private UDI udiInfo;
    private VersionInfo versionInfo;
    private CertificateInfo certificateInfo;
    private StatusInfo statusInfo;
    private List<ScheduledJobInfo> scheduledJobInfoList;
    private OtherInfo otherInfo;

    /**
     * Gets the entitlement information list.
     * 
     * @return The entitlement information list.
     */
    public List<EntitlementInfo> getEntitlementInfoList() {
        return entitlementInfoList;
    }

    /**
     * Gets the UDI information.
     * 
     * @return The UDI information.
     */
    public UDI getUdiInfo() {
        return udiInfo;
    }

    /**
     * Gets the version information.
     * 
     * @return The version information.
     */
    public VersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * Gets the certificate information.
     * 
     * @return The certificate information.
     */
    public CertificateInfo getCertificateInfo() {
        return certificateInfo;
    }

    /**
     * Gets the status information.
     * 
     * @return The status information.
     */
    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    /**
     * Gets the scheduled job information list.
     * 
     * @return The scheduled job information list.
     */
    public List<ScheduledJobInfo> getScheduledJobInfoList() {
        return scheduledJobInfoList;
    }

    /**
     * Gets the other information.
     * 
     * @return The other information.
     */
    public OtherInfo getOtherInfo() {
        return otherInfo;
    }
}
