package com.thinking.machines.factoryMethod.creator;

import com.thinking.machines.factoryMethod.entity.Message;

public abstract class MessageCreator {
	
	public Message getMessage() {
		Message message = createMessage();
		
		message.addDefaultHeaders();
		message.encrypt();
		
		return message;
	}
	
	// factory method
	protected abstract Message createMessage();
}
