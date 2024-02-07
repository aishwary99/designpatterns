package com.thinking.machines.factoryMethod.entity;

public abstract class Message {
	public abstract String getContent();
	
	public void addDefaultHeaders() {
		// logic to add default headers
	}
	
	public void encrypt() {
		// logic to encrypt the message
	}
}
