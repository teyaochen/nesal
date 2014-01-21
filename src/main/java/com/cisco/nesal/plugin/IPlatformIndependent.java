package com.cisco.nesal.plugin;

import java.util.Locale;

import com.cisco.nesal.agent.SmartAgentException;

/**
 * This interface will be implemented by the software product so the agent can
 * get Platform Independent (PD) information.
 * 
 * <p>
 * <b>Notes about enabling Smart Agent debug logs:</b>
 * </p>
 * Debug logging in the API can be enabled at runtime to display more
 * information to your logger, for example, log4j, java.util.logging, etc. The
 * API uses SLF4J (http://www.slf4j.org/) internally as a facade for various
 * logging frameworks and allows the application to plug in the desired logging
 * framework at deployment time. If no logging framework is found on the class
 * path, then SLF4J defaults to a no-operation implementation.
 * <p>
 * You should use the mechanism provided by your logging framework to configure
 * logging level and output destination. The following example shows how to
 * configure API debug logging if you use log4j.
 * </p>
 * <ol>
 * <li>Edit your log4j.properties file and add have these lines in the file.
 * This example will set the logging level of the API to DEBUG, and display the
 * output to console:
 * 
 * <pre>
 *      log4j.rootLogger=DEBUG, A1
 *      log4j.appender.A1=org.apache.log4j.ConsoleAppender
 *      log4j.logger.come.cisco.nesal=DEBUG
 * </pre>
 * 
 * </li>
 * <li>Run you application with the following JAR files in classpath:
 * 
 * <pre>
 *      java -cp .:slf4j-api-1.6.1.jar:slf4j-log4j12-1.6.1.jar:log4j-1.2.16.jar MyApp
 * </pre>
 * 
 * 
 */
public interface IPlatformIndependent {

    /**
     * Severity of a syslog message.
     * 
     */
    public enum SysLogSeverity {
        /** system is unusable */
        EMERG,
        /** action must be taken immediately */
        ALERT,
        /** critical conditions */
        CRIT,
        /** error conditions */
        ERR,
        /** warning conditions */
        WARNING,
        /** normal but significant condition */
        NOTICE,
        /** informational */
        INFO,
        /** debug-level messages */
        DEBUG
    }

//    /**
//     * Has the software product finished initializing?
//     * <p>
//     * After the agent is enabled during the init sequence it will call this
//     * function every 30 seconds until it returns true in the isInit parameter.
//     * When true is returned the agent will assume the following:
//     * <ul>
//     * <li>all interfaces in the device are up and functioning so it can attempt
//     * to contact the Cisco licensing receiver.
//     * <li>the config has been parsed. This is important because the agent needs
//     * to know if the SmartAgentEnable and SmartAgentIdTokenRegister are called
//     * as a result of the config being parsed at boot time or because the user
//     * used the CLI.
//     */
//    public void isInit();

    /**
     * Shuts down the PI interface to the agent.
     * <p>
     * This is the last call the agent will make before it shuts down to free
     * any resources allocated by init method.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void shutdown() throws SmartAgentException;

    //    /**
//     * Initializes the PI interface to the agent.
//     * <p>
//     * The agent will call this during SmartAgent.init(). It will be called
//     * before SmartAgent.init().
//     * <p>
//     * It's very likely that the PI code will not need to do anything in this
//     * init routine but it is available just in case.
//     */
//    public void init();

    /**
     * Gets the Locale object represents a specific geographical, political, or
     * cultural region.
     * <p>
     * This locale is sent in every message to the Cisco licensing receiver and
     * so this function will be called for every message sent.
     * 
     * @return The Locale object represents a specific geographical, political,
     *         or cultural region.
     */
    public Locale getLocale();

    /**
     * Gets the hostname string for the device.
     * <p>
     * This hostname will be sent, in the registration message, to Cisco.
     * 
     * @return The hostname string.
     */
    String getHostname();

    /**
     * Gets the version of Smart Agent and dependent components.
     * 
     * @return The version of Smart Agent and dependent components in string
     *         form.
     */
    String getCompVersion();

    /**
     * Writes a syslog message.
     * <p>
     * Extra information such as time stamp should be added by the software product.
     * 
     * @param severity
     *            The severity level of the message.
     * @param message
     *            The message to write to syslog.
     */
    public void syslog(SysLogSeverity severity, String message);

    /**
     * Writes a debug message to the debug log or the console if debugging is
     * enabled.
     * 
     * @param message
     *            The message to write.
     */
    public void debugMessage(String message);

    /**
     * Writes an error message to the error log or the console.
     * 
     * @param message
     *            The message to write.
     */
    public void errorMessage(String message);

    /**
     * Writes the trace message into the system trace buffer.
     * 
     * @param message
     *            The message to add to the trace buffer.
     */
    public void traceMessage(String message);

}
