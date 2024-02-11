package com.thinking.machines.bridge.list;

public class ArrayLinkedList implements LinkedList {

	private static final int DEFAULT_SIZE = 2;

	private Object[] bag;

	private int size;

	public ArrayLinkedList() {
		this.bag = new Object[DEFAULT_SIZE];
	}

	@Override
	public void addFirst(Object element) {
		ensureCapacity(++size);
		shiftOneRight();

		this.bag[0] = element;
	}

	private void shiftOneRight() {
		System.arraycopy(this.bag, 0, this.bag, 1, size);
	}

	private void ensureCapacity(int newSize) {
		if (this.bag.length > newSize) {
			return;
		}

		Object[] temp = new Object[this.bag.length + DEFAULT_SIZE];
		System.arraycopy(this.bag, 0, temp, 0, this.bag.length);

		this.bag = temp;
	}

	@Override
	public void addLast(Object element) {
		ensureCapacity(++size);
		shiftOneLeft();

		this.bag[size - 1] = element;
	}

	private void shiftOneLeft() {
		System.arraycopy(this.bag, 0, this.bag, 1, size - 1);
	}

	@Override
	public Object removeFirst() {
		if (size == 0) {
			return null;
		}

		Object first = this.bag[0];
		size--;
		shiftOneLeft();
		return first;
	}

	@Override
	public Object removeLast() {
		if (this.size == 0) {
			return null;
		}

		Object last = this.bag[--size];
		return last;
	}

	@Override
	public int getSize() {
		return this.size;
	}

}
