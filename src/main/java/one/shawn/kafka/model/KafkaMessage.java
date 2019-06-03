package one.shawn.kafka.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class KafkaMessage {
	@NotBlank
	private String messageId;
	@NotBlank
	private String message;
	@Valid
	private DateTime timestamp;
}
