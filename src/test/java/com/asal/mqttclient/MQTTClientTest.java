package com.asal.mqttclient;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for MQTTClient.
 */
public class MQTTClientTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MQTTClientTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MQTTClientTest.class );
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
