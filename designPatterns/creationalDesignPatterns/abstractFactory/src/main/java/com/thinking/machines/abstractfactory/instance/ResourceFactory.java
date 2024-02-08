package com.thinking.machines.abstractfactory.instance;

import com.thinking.machines.abstractfactory.storage.Storage;

public interface ResourceFactory {
	
	public Instance createInstance(Instance.Capacity capacity);
	
	public Storage createStorage(int capacityInMB);
}
