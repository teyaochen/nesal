package com.cisco.nesal.agent;

/**
 * This enum represents the status code that may be returned or contained in the
 * exception after a call to the services provided Smart Agent.
 * 
 */
public enum SmartAgentStatusCode {
    SmartAgentSuccess(0),
    SmartAgentErrorMalloc(1),
    SmartAgentErrorNullPointer(2),
    SmartAgentErrorBadInputParams(6),
    SmartAgentErrorBadHandle(8),
    SmartAgentErrorNotFound(9),
    SmartAgentErrorNotSupported(10),
    SmartAgentErrorAlreadyInit(11),
    SmartAgentErrorNotInit(12),
    SmartAgentErrorSMFailToCreate(13),
    SmartAgentErrorSMFailToRun(14),
    SmartAgentErrorSMFailToInit(15),
    SmartAgentErrorSMFailToDestroy(16),
    SmartAgentErrorMsgParse(17),
    SmartAgentErrorMsgBuild(18),
    SmartAgentErrorNotEnabled(19),
    SmartAgentErrorInvalidRequest(20),
    SmartAgentErrorInit(21),
    SmartAgentErrorFailToSetState(22),
    SmartAgentErrorUnsupportedResponse(23),
    SmartAgentErrorInvalidResponse(24),
    SmartAgentErrorStorageFailToStore(25),
    SmartAgentErrorStorageFailToRetrieve(26),
    SmartAgentErrorNullCcoIdToken(27),
    SmartAgentErrorMatchIdentifier(28),
    SmartAgentErrorMatchVendor(29),
    SmartAgentErrorMatchNonce(30),
    SmartAgentErrorCommDisabled(31),
    SmartAgentErrorCommSend(32),
    SmartAgentErrorCommResponse(33),
    SmartAgentErrorCommUnkown(34),
    SmartAgentErrorSMPostNotAllow(35),
    SmartAgentReqMsgMissingMandatoryField(36),
    SmartAgentResponseError(37),

    /* PI not initialized */
    SmartAgentErrorPINotInit(38),
    SmartAgentErrorAlreadyEnabled(39),
    SmartAgentErrorAlreadyRegistered(40),
    SmartAgentCertInvalid(41),
    SmartAgentCertExpired(42),
    SmartAgentErrorNotRegistered(43),
    SmartAgentCSRGenerationError(44),
    SmartAgentVerifySignatureFailed(45),
    SmartAgentGenerateSignatureFailed(46),
    SmartAgentSignCertVerificationFailed(47),
    SmartAgentNodeCertVerificationFailed(48),
    SmartAgentParseCertificateFailed(49),
    SmartAgentCryptoRootCAImportFailed(50);

    private final int value;

    SmartAgentStatusCode(int value) {
        this.value = value;
    }

    /**
     * Get the value associated with the enum instance.
     * 
     * @return Integer value of the enum instance.
     */
    public int getValue() {
        return value;
    }

}
