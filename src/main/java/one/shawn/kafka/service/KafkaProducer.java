package one.shawn.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import one.shawn.kafka.model.KafkaMessage;
import one.shawn.kafka.props.KafkaProperties;

@Service
public class KafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaProperties props;
	
	@Autowired
	private KafkaTemplate<String, KafkaMessage> kafkaTemplate;
	
	public void sendMessage(KafkaMessage message) {
		logger.info("Sending message -> {}", message);
		kafkaTemplate.send(props.getTopicName(), message);
	}
}
