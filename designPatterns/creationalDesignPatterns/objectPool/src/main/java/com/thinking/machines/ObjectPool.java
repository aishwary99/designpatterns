package com.thinking.machines;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class ObjectPool<T extends Poolable> {
	
	private BlockingQueue<T> pool;
	
	public ObjectPool(Supplier<T> creator, int count) {
		this.pool = new LinkedBlockingQueue();
		
		for (int index = 0; index < count; index++) {
			this.pool.add(creator.get());
		}
	}
	
	public T get() {
		try {
			return this.pool.take();
		} catch (Exception exception) {
			System.out.println("get() : " + exception);
		}
		
		return null;
	}
	
	public void release(T object) {
		object.reset();
		
		try {
			this.pool.put(object);
		} catch (Exception exception) {
			System.out.println("release() : " + exception);
		}
	}
}
