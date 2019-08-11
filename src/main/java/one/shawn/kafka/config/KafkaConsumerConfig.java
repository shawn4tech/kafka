package one.shawn.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import one.shawn.kafka.model.KafkaMessage;
import one.shawn.kafka.props.KafkaProperties;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	@Autowired
	private KafkaProperties props;
	
	@Bean
	public ConsumerFactory<String, KafkaMessage> kafkaMessageConsumerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, props.getBootstrapAddress());
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, props.getGroupId());
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configProps,
				new StringDeserializer(),
				new JsonDeserializer<>(KafkaMessage.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> messageKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, KafkaMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(kafkaMessageConsumerFactory());
		return factory;
	}
}
