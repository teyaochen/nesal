package com.cisco.nesal.internal;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cisco.nesal.plugin.ICommunication;
import com.cisco.nesal.plugin.ICrypto;
import com.cisco.nesal.plugin.IPlatformDependent;
import com.cisco.nesal.plugin.IPlatformIndependent;

public class RubySampleTest {

    @Test
    public void test() {
        
        // Remove these test code
        RubySample rubySample = new RubySample(1.0, 2.0);
        
        ICrypto cryptoImpl = null;
        IPlatformIndependent piImpl = null;
        ICommunication commImpl = null;
        IPlatformDependent pdImpl = null;
        rubySample.configure(commImpl, piImpl, pdImpl, cryptoImpl);
        
        rubySample.bar(1, 2);

    }

}
