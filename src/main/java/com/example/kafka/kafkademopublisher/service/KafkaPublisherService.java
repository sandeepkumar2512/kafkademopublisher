package com.example.kafka.kafkademopublisher.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.kafkademopublisher.constants.Constants;
import com.example.kafka.kafkademopublisher.dto.CustomMessage;
import com.example.kafka.kafkademopublisher.dto.User;

@Service
public class KafkaPublisherService {
	
	@Autowired 
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void publishStringMessage(String message) {
		kafkaTemplate.send(Constants.STRING_MESSAGE_KAFKA_TOPIC, message);
		System.out.println("### Published message : " + message);
	}
	
	public void publishObjectMessage() {
		CustomMessage message = buildCustomMessage();
		kafkaTemplate.send(Constants.OBJECT_MESSAGE_KAFKA_TOPIC, message);
		System.out.println("### Published message : " + message);
	}
	
	private CustomMessage buildCustomMessage() {
		Map<String,String> configMap = new HashMap<>();
		configMap.put("key1", "value1");
		configMap.put("key2", "value2");
		
		List<User> usersList = new ArrayList<>();
		usersList.add(getUser());
		
		CustomMessage message = new CustomMessage();
		message.setConfigMap(configMap);
		message.setUsersList(usersList);
		message.setMessageType("ComplexMessage");
		
		return message;
	}
	
	private User getUser() {
		User user = new User();
		user.setName("Sandeep");
		user.setEmail("abc@def.com");
		
		return user;
	}
	
	

}
