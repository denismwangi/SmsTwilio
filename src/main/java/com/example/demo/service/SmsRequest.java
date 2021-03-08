package com.example.demo.service;



import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {
	@NotNull
	private final String phoneNumber;
	@NotNull
	private final String Message;

	
	//public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, 
	//		          @JsonProperty("message") String message) {
	
	public SmsRequest(String phoneNumber, String message) {	
		this.phoneNumber = phoneNumber;
		Message = message;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getMessage() {
		return Message;
	}
	
	@Override
	public String toString() {
		return "SmsRequest "
				+ "[phoneNumber=" + phoneNumber + ","
						+ " Message=" + Message + "]";
	}


	
	
}
