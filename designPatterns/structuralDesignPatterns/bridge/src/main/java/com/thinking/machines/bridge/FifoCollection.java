package com.thinking.machines.bridge;

public interface FifoCollection<T> {

	public void offer(T element);

	public T poll();
}
