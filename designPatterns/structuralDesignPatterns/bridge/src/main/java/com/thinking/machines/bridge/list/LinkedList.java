package com.thinking.machines.bridge.list;

public interface LinkedList<T> {

	public void addFirst(T element);

	public void addLast(T element);

	public T removeFirst();

	public T removeLast();

	public int getSize();
}
