package com.thinking.machines.abstractfactory.instance;

import com.thinking.machines.abstractfactory.storage.Storage;

public interface Instance {
	
	enum Capacity {
		MICRO,
		SMALL,
		LARGE
	}
	
	public void start();
	public void stop();
	public void attachStorage(Storage storage);
}
