package com.asal.mqttclient;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author A. Salamanis (asal@iti.gr)
 * @version 0.1
 * @since 2018-05-12
 *
 * MQTTClient class: A class representing an MQTT client.
 */
public class MQTTClient  {
	private String broker;
	private int port;
	private String topic;
	private String clientId;
	private int qos;
	private PropertiesParser propertiesParser;
	
    /**
     * Constructor.
     */
	public MQTTClient() {
		String propertiesFilename = "\\mqtt-client.properties";
		propertiesParser = new PropertiesParser(propertiesFilename);
		propertiesParser.readPropertiesValues();
		this.broker = propertiesParser.getPropertyAsString("broker");
		this.port = propertiesParser.getPropertyAsInteger("port");
		this.topic = propertiesParser.getPropertyAsString("topic");
		this.clientId = propertiesParser.getPropertyAsString("clientId");
		this.qos = propertiesParser.getPropertyAsInteger("qos");
	}
	
    /**
     * Constructor.
     * @param broker the ip or URL of the MQTT broker
     * @param port the port of the MQTT broker
     * @param topic the MQTT topic
     * @param clientId the Id of the client
     * @param qos the level of Quality of Service (QoS) (0, 1 or 2)
     */
	public MQTTClient(String broker, int port, String topic, String clientId, int qos) {
		this.broker = broker;
		this.port = port;
		this.topic = topic;
		this.clientId = clientId;
		this.qos = qos;
	}
	
	/**
	 * Setter for the MQTT broker ip or URL.
	 * @param broker the ip or URL of the MQTT broker
	 */
	public void setBroker(String broker) {
		this.broker = broker;
	}
	
	/**
	 * Getter for the ip or URL of the MQTT broker
	 * @return the ip or URL of the MQTT broker
	 */
	public String getBroker() {
		return broker;
	}
	
	/**
	 * Setter for the port of the MQTT broker.
	 * @param port the port of the MQTT broker
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * Getter for the port of the MQTT broker.
	 * @return the port of the MQTT broker
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Setter for the MQTT topic.
	 * @param topic the MQTT topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	/**
	 * Getter for the MQTT topic.
	 * @return the MQTT topic
	 */
	public String getTopic() {
		return topic;
	}
	
	/**
	 * Setter for the client Id.
	 * @param clientId the client Id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * Getter for the client Id.
	 * @return the client Id
	 */
	public String getClientId() {
		return clientId;
	}
	
	/**
	 * Setter for the QoS.
	 * @param qos the QoS
	 */
	public void setQos(int qos) {
		this.qos = qos;
	}
	
	/**
	 * Getter for the QoS.
	 * @return the QoS
	 */
	public int getQos() {
		return qos;
	}

	public static void main(String[] args) {
	  	MQTTClient mqttClient = new MQTTClient();	  
	    MemoryPersistence persistence = new MemoryPersistence();
	    try {
	    	// broker URL
	    	String broker = mqttClient.getBroker();
	    	int port = mqttClient.getPort();
	    	broker = "tcp://" + broker + ':' + Integer.toString(port);
	    	
	    	// broker topic
	    	String topic = mqttClient.getTopic();
	    	
	    	// client Id
	    	String clientId = mqttClient.getClientId();
	    	
	    	int qos = mqttClient.getQos();
	    	
	    	// message to publish
	    	String content = "Message from " + mqttClient.getClientId();
	    	
	        MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
	        
	        MqttConnectOptions connOpts = new MqttConnectOptions();

	        connOpts.setCleanSession(true);
	        
	        System.out.println("Connecting to broker: " + broker);
	        
	        sampleClient.connect(connOpts);
	        
	        System.out.println("Connected");
	        
	        System.out.println("Publishing message: " + content);
	        
	        MqttMessage message = new MqttMessage(content.getBytes());
	        
	        message.setQos(qos);
	        
	        sampleClient.publish(topic, message);
	        
	        System.out.println("Message published");
	        
	        sampleClient.disconnect();
	        
	        System.out.println("Disconnected");
	        
	        System.exit(0);
	    } catch(MqttException me) {
	        System.out.println("reason " + me.getReasonCode());
	        System.out.println("msg " + me.getMessage());
	        System.out.println("loc " + me.getLocalizedMessage());
	        System.out.println("cause " + me.getCause());
	        System.out.println("excep " + me);
	        me.printStackTrace();
	    }
	 }
}