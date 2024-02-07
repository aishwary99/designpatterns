package com.thinking.machines.factoryMethod.creator;

import com.thinking.machines.factoryMethod.entity.Message;
import com.thinking.machines.factoryMethod.entity.TextMessage;

public class TextMessageCreator extends MessageCreator {

	@Override
	protected Message createMessage() {
		return new TextMessage();
	}
	
}
