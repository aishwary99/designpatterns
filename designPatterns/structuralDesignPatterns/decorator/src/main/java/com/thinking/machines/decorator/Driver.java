package com.thinking.machines.decorator;

public class Driver {
	public static void main(String[] args) {
		Message m = new TextMessage();
		System.out.println(m.getContent());

		Message decorator = new HTMLEncodedMessage(m);
		System.out.println(decorator.getContent());
		
		decorator = new Base64EncodedMessage(decorator);
		System.out.println(decorator.getContent());
	}
}
