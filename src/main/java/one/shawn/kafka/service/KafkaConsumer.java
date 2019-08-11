package one.shawn.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import one.shawn.kafka.model.KafkaMessage;

@Service
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	
	@KafkaListener(topics = "messages", groupId = "consumers", containerFactory = "messageKafkaListenerContainerFactory")
	public void kafkaMessageConsumer(KafkaMessage message) {
		logger.info("Received message -> {}", message);
	}

}
