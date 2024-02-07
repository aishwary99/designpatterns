package com.thinking.machines.factoryMethod.creator;

import com.thinking.machines.factoryMethod.entity.JSONMessage;
import com.thinking.machines.factoryMethod.entity.Message;

public class JSONMessageCreator extends MessageCreator {

	@Override
	protected Message createMessage() {
		return new JSONMessage();
	}

}
