package com.cisco.nesal.agent;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.squirrelframework.foundation.fsm.ConverterProvider;

public class AbstractSFMTest {
    
    @BeforeClass
    public static void beforeTest() {
    }
    
    @AfterClass
	public static void afterTest() {
		ConverterProvider.INSTANCE.clearRegistry();
	}
}
