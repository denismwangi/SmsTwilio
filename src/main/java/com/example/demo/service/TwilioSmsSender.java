package com.example.demo.service;

import com.example.demo.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements SmsSender {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SmsSender.class);
	
	 private final TwilioConfiguration twilioConfiguration;
	 
	 @Autowired
	 public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
		 this.twilioConfiguration = twilioConfiguration;
	 }
	

	@Override
	public void SendSms(SmsRequest smsRequest) {
		// TODO Auto-generated method stub
		if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", smsRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + smsRequest.getPhoneNumber() + "] is not a valid number"
            );
        }
		
	}
	
	/**
	 * check various phone number formats
	 * @param phoneNumber
	 * @return
	 */
	private boolean isPhoneNumberValid(String phoneNumber) {
		// TODO Auto-generated method stub
		return true;
	}


}
