/**
 * 
 */
package com.citizens.payment.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citizens.payment.process.producer.PaymentProcessProducer;



/**
 * @author Sathish_G01
 *
 */
@RestController
@RequestMapping(value = "/produce")
public class PaymentProcessingController {
	
	private final PaymentProcessProducer producer;
	
	@Autowired
	public PaymentProcessingController (PaymentProcessProducer producer)
	{
		this.producer = producer;
	}
	
	@PostMapping(value = "/publish")
	public void sendMessagetoTopic(@RequestBody final String paymentProcessReq)
	{
		producer.sendMessage(paymentProcessReq);
	}
	
}
