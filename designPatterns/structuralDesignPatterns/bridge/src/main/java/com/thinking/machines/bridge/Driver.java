package com.thinking.machines.bridge;

import com.thinking.machines.bridge.list.SinglyLinkedList;

public class Driver {
	
	public static void main(String args[]) {
		FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
		collection.offer(10);
		collection.offer(40);
		collection.offer(99);
		
		System.out.println(collection.poll());
		System.out.println(collection.poll());
		System.out.println(collection.poll());
	}
}
