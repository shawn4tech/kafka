package one.shawn.kafka.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.shawn.kafka.model.KafkaMessage;
import one.shawn.kafka.service.KafkaProducer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	@Autowired
	private KafkaProducer producer;
	
	@PostMapping("/message")
	public String postMessage(@Valid @RequestBody KafkaMessage message) {
		producer.sendMessage(message);
		return "Success";
	}
}
