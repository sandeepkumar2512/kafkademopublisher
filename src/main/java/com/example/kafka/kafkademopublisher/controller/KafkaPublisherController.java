package com.example.kafka.kafkademopublisher.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.kafkademopublisher.service.KafkaPublisherService;

@RestController
public class KafkaPublisherController {
	
	@Autowired
	private KafkaPublisherService kafkaPublisherService;
	
	@PostMapping("/publish-string-message")
	public void publishStringMessage(@RequestBody String message) {
		System.out.println("######## Publishing message to kafka topic ##########");
		kafkaPublisherService.publishStringMessage(message);
	}
	
	@PostMapping("/publish-json-message")
	public void publishJsonMessage() {
		System.out.println("######## Publishing message to kafka topic ##########");
		kafkaPublisherService.publishObjectMessage();
	}

}
