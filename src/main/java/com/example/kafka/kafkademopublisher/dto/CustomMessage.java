package com.example.kafka.kafkademopublisher.dto;

import java.util.List;
import java.util.Map;

public class CustomMessage {
	private String messageType;
	private Map<String, String> configMap;
	private List<User> usersList;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public Map<String, String> getConfigMap() {
		return configMap;
	}

	public void setConfigMap(Map<String, String> configMap) {
		this.configMap = configMap;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	@Override
	public String toString() {
		return "CustomMessage [messageType=" + messageType + 
				", configMap=" + configMap + 
				", usersList=" + usersList + 
				"]";
	}
}
