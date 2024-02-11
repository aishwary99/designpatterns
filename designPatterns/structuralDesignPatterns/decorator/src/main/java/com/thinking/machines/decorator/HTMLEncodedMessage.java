package com.thinking.machines.decorator;

import org.apache.commons.lang3.StringEscapeUtils;

public class HTMLEncodedMessage implements Message {

	private Message message;

	public HTMLEncodedMessage(Message message) {
		this.message = message;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getContent() {
		return StringEscapeUtils.escapeHtml4(this.message.getContent());
	}

}
