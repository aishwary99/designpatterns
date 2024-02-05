package com.thinking.machines;

public class TextFormatter implements Formatter{

	public String format(Message message){
		return message.getTimestamp()+":"+message.getMsg();
	}
}
