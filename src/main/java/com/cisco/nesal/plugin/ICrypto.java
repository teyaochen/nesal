package com.cisco.nesal.plugin;

import java.security.MessageDigest;

import com.cisco.nesal.agent.CSR;
import com.cisco.nesal.agent.SmartAgentException;
import com.cisco.nesal.agent.CSR.CSRFormat;
import com.cisco.nesal.agent.Certificate;


/**
 * This is the interface between the agent and the Crypto/Certificate services
 * available on the software product.
 * <p>
 * Brief description of how the Certificates are used: The CSR request is sent
 * to backend after generating a key pair. The response received will have the
 * Node Certificate, Signing Certificate and the Licensing SubCa. The Signing
 * Certificate also known as MMI Respone Signing Certificate. The Node
 * Certificate a.k.a ID Certificate is the MMI Request Signing Certificate.
 * <p>
 * MMI Request messages from the Smart Agent are signed using the Node
 * Certificate's private key and backend will verify the signature on them to
 * prove they were not alter enroute.
 * <p>
 * MMI response message from backend are signed using the Signing Certificate's
 * private key and the Smart Agent verified the signature on the message using the
 * Signing Certificate previously received as a part of CSR process.
 * 
 */
public interface ICrypto {

    /**
     * Type of algorithm supported for message digest.
     */
    public enum MessageDigestAlgorithm {
        /** MD5 is to be used for the hash. */
        MD5,
        /** SHA1 is to be used for the hash. */
        SHA1,
        /** SHA256 is to be used for the hash. */
        SHA256;
    }

    /**
     * Initializes the Crypto with the root CA to be used for validation of node
     * certitificate and signing certificate To replace the existing rootCA,
     * call this API with new rootCA.
     * 
     * @param rootCA
     *            The Root certificate to import into the trust store for
     *            validation of the trust chain of Node Certificate.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void init(String rootCA) throws SmartAgentException;

    /**
     * Shuts down Crypto. This will be called when the agent shuts down. it
     * should free any resources that were allocated.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public void shutdown() throws SmartAgentException ;

    /**
     * Creates a message signature.
     * <p>
     * Use this method to create a signature for data. MMI Request sent to the
     * backend are signed using the Node Certificate's private Key.
     * 
     * @param key
     *            The private key to use for signature generation. This
     *            parameter will be null in case the caller is not taking care
     *            of private key trusted storage.
     * @param data
     *            The data to sign for.
     * @param algorithm
     *            Hash algorithm to be used, one of MessageDigestAlgorithm.
     * 
     * @return The signature in String format.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public String generateSignature(String key, String data,
            MessageDigestAlgorithm algorithm) throws SmartAgentException;

    /**
     * Creates a Certificate Signing Request (CSR).
     * <p>
     * Use this method to create a Certificate Signing Request.
     * 
     * @param udi
     *            The UDI or GUID of the product, which is used to populate the
     *            Common Name in CSR.
     * @param csrOutputFormat
     *            The format of the output of CSR .
     * @param algorithm
     *            The message digest algorithm to be used while signing the CSR.
     * 
     * @return A CSR object which containss a public key and raw CSR string.
     * 
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public CSR getCSR(String udi, CSRFormat csrOutputFormat,
                      MessageDigestAlgorithm algorithm) throws SmartAgentException ;

    /**
     * Creates a message digest with the specified algorithm.
     * 
     * @param message
     *            The message data to be hashed.
     * @param algorithm
     *            The message digest algorithm to use (e.g., MD5, SHA256, etc).
     * 
     * @return The message digest.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public MessageDigest hashMessage(String message,
            MessageDigestAlgorithm algorithm) throws SmartAgentException ;

    /**
     * Parses a certificate.
     * <p>
     * Use this method to parse a certificate and return a Certificate object.
     * 
     * @param cert
     *            The certificate to parse in any of the formats, e,g, DER, PEM.
     * @return A CertificateInfo object
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public Certificate parseCertificate(String cert) throws SmartAgentException;

    /**
     * Validates Node Certificate with the root CA.
     * <p>
     * Use the method to validate Node Certificate with the root CA. The Node
     * Certificate is signed with Licensing Sub CA certificate which in turns is
     * signed using the Root CA certificate. So the certificate chain has to be
     * validated. Also a double check is done to make sure the public key
     * contained in the Node certificate is the other half of the key pair
     * generate as part of CSR by signing a test message with private key and
     * verifying the signature using the public key present in the Node
     * certificate.
     * 
     * @param cert
     *            The Node certificate to use for validation in any of the
     *            formats of DER, Base64, PEM.
     * @param subCA
     *            The Licensing SubCA Cert to use in any of the formats of DER,
     *            Base64 and PEM.
     * @param privateKey
     *            The private key stored in trust storage by caller is passed
     *            else will be null.
     * @return True if the cert is valid; false otherwise.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public boolean validateNodeCertificate(String cert, String subCA,
            String privateKey) throws SmartAgentException ;

    /**
     * Validate a message signature Using the Crypto functions validate a
     * signature using the public keys.
     * <p>
     * MMI Response message received are signed by the Signing Certificate's
     * private key So we need to validate the signature using the public key
     * embedded in the Signing Certificate.
     * 
     * @param cert
     *            The Node certificate to use for validation in any of the
     *            formats of DER, Base64, PEM.
     * @param data
     *            The data to verify the signature for
     * @param signature
     *            The signature to validate
     * @param algorithm
     *            The message digest algorithm to be used while signing the CSR.
     *            
     * @return True if the signature is valid; false otherwise.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public boolean validateSignature(String cert, String data,
            String signature, MessageDigestAlgorithm algorithm) throws SmartAgentException;

    /**
     * Validate Signing Certificate with the root CA.
     * 
     * Using the Crypto functions validate Signing certificate with the root CA
     * The signing cert is signed by the root CA directly and hence we need to
     * validate against the root CA only.
     * 
     * @param cert
     *            The Signing certificate to use for validation in any of the
     *            formats of DER, Base64, PEM.
     * 
     * @return True if the cert is valid; false otherwise.
     * 
     * @throws SmartAgentException
     *             The exception is thrown when error occurs in the operation.
     *             getStatusCode() method in the exception will return the
     *             status code.
     */
    public boolean validateSigningCertificate(String cert) throws SmartAgentException;

}
