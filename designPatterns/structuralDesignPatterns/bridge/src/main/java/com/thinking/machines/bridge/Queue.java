package com.thinking.machines.bridge;

import com.thinking.machines.bridge.list.LinkedList;

public class Queue<T> implements FifoCollection<T> {
	
	// this is bridge design pattern
	private LinkedList<T> list;

	public Queue(LinkedList<T> list) {
		this.list = list;
	}

	@Override
	public void offer(T element) {
		this.list.addLast(element);
	}

	@Override
	public T poll() {
		return this.list.removeFirst();
	}

}
