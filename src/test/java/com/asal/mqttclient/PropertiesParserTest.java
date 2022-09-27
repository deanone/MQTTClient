package com.asal.mqttclient;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for PropertiesParser.
 */
public class PropertiesParserTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PropertiesParserTest( String testName )
    {
        super( testName );
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PropertiesParserTest.class );
    }
    
    /**
     * Rigorous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
