/**
 * 
 */
package com.citizens.payment.process.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Sathish_G01
 *
 */
@Service
public class PaymentProcessProducer {

	private static final Logger logger = LoggerFactory.getLogger(PaymentProcessProducer.class);
	private static final String topic = "payment-process";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message)
	{
		logger.info(String.format("$$ -> Publishing Message to payment-process kafka topic -->  %s", message));
		this.kafkaTemplate.send(topic,message);
	}
	
}
