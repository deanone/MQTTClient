package com.asal.mqttclient;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for PropertiesParser class.
 */
@DisplayName("The class that tests the PropertiesParser class.")
public class PropertiesParserTest {
	PropertiesParser propertiesParser;
	
	@BeforeEach
	void setUp() {
		// mock properties
		String broker = "broker_url";
		String port = "1883";
		String topic = "test/topic";
		String clientId = "Reporter";
		String qos = "1";
		
		HashMap<String, String> propertiesMap = new HashMap<String, String>();
		propertiesMap.put("broker", broker);
		propertiesMap.put("port", port);
		propertiesMap.put("topic", topic);
		propertiesMap.put("clientId", clientId);
		propertiesMap.put("qos", qos);
		
		propertiesParser = new PropertiesParser(propertiesMap);
	}
	
	@Test
	@DisplayName("Test if all values from the properties file are correctly loaded into memory.")
	public void testPropertiesMap() {			
		assertEquals("broker_url", propertiesParser.getPropertyAsString("broker"));
		assertEquals(1883, propertiesParser.getPropertyAsInteger("port"));
		assertEquals("test/topic", propertiesParser.getPropertyAsString("topic"));
		assertEquals("Reporter", propertiesParser.getPropertyAsString("clientId"));
		assertEquals(1, propertiesParser.getPropertyAsInteger("qos"));
	}
}
