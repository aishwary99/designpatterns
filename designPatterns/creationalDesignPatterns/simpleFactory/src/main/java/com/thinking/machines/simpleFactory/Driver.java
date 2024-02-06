package com.thinking.machines.simpleFactory;

public class Driver {
	public static void main(String args[]) {
		Post post = PostFactory.createPost("news");
		System.out.println(post);
	}
}
