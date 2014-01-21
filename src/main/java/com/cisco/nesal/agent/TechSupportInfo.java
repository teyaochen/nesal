package com.cisco.nesal.agent;

import java.util.List;

import com.cisco.nesal.agent.Entitlement.EntitlementEnforceMode;

/**
 * This class represents the structured information of the Smart Agent.
 * 
 */
public class TechSupportInfo {

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

    /**
     * This inner class of SmartAgentInfo contains scheduled job information.
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
     * This inner class of SmartAgentInfo contains all test related information.
     * 
     */
    public static class TestInfo {
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


    private List<ScheduledJobInfo> scheduledJobInfoList;
    private TestInfo otherInfo;

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
    public TestInfo getOtherInfo() {
        return otherInfo;
    }
}
