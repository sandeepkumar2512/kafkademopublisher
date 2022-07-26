package com.example.kafka.kafkademopublisher.configuration;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.kafka.kafkademopublisher.constants.Constants;

@Configuration
public class KafkaConfiguration {
//	@Value("${server.port}")
//	private int serverPort;
//	@Value("${server.address:localhost}")
//	private String hostName;

	@Bean
	public NewTopic stringMessageTopic() {
		return TopicBuilder.name(Constants.STRING_MESSAGE_KAFKA_TOPIC).partitions(6).replicas(1).build();
	}
	

	/**
	 * below configurations are required for publishing raw objects (other than
	 * String)
	 */

	@Bean
	public NewTopic objectMessageTopic() {
		return TopicBuilder.name(Constants.OBJECT_MESSAGE_KAFKA_TOPIC).partitions(6).replicas(1).build();
	}

	@Bean
	public ProducerFactory<String, Object> producerFactory() {
		Map<String, Object> producerConfig = Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092",
													ProducerConfig.RETRIES_CONFIG, 0, 
													ProducerConfig.BUFFER_MEMORY_CONFIG,33554432, 
													ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class, 
													ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(producerConfig);
	}

	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

//	private String getKafkaHost() {
//		return hostName + ":" + serverPort;
//	}
}
