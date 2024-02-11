package com.thinking.machines.decorator;

import java.util.Base64;

public class Base64EncodedMessage implements Message {

	private Message message;

	public Base64EncodedMessage(Message message) {
		this.message = message;
	}

	@Override
	public String getContent() {
		// Be wary of charset!! This is platform dependent..
		return Base64.getEncoder().encodeToString(this.message.getContent().getBytes());
	}

}
