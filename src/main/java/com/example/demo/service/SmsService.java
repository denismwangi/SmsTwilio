package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
	
	
	private final TwilioSmsSender twilioSmsSender;
	
	@Autowired
	public SmsService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
		this.twilioSmsSender = twilioSmsSender;
	}
	
	public void sendSms(SmsRequest smsRequest) {
		twilioSmsSender.SendSms(smsRequest);
	}
	

}
