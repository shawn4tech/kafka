package one.shawn.kafka.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


// If we don't use @Configuration, we have to register it with @EnableConfigurationProperties(KafkaProperties.class)
// Or no bean will be found
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {
	private String bootstrapAddress;
	private String topicName;
	private String groupId;
	
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getBootstrapAddress() {
		return bootstrapAddress;
	}
	
	public void setBootstrapAddress(String bootstrapAddress) {
		this.bootstrapAddress = bootstrapAddress;
	}
	
	public String getTopicName() {
		return topicName;
	}
	
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
}
