package com.thinking.machines.factoryMethod;

import com.thinking.machines.factoryMethod.creator.JSONMessageCreator;
import com.thinking.machines.factoryMethod.creator.MessageCreator;
import com.thinking.machines.factoryMethod.creator.TextMessageCreator;
import com.thinking.machines.factoryMethod.entity.Message;

public class Driver {
	public static void main(String args[]) {
		printMessage(new JSONMessageCreator());
		
		printMessage(new TextMessageCreator());
	}
	
	public static void printMessage(MessageCreator messageCreator) {
		Message message = messageCreator.getMessage();
		System.out.println(message.getContent());
	}
}
