package com.thinking.machines.abstractfactory.gcp;

import com.thinking.machines.abstractfactory.instance.Instance;
import com.thinking.machines.abstractfactory.instance.Instance.Capacity;
import com.thinking.machines.abstractfactory.instance.ResourceFactory;
import com.thinking.machines.abstractfactory.storage.Storage;

public class GCPResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngine(capacity);
	}

	@Override
	public Storage createStorage(int capacityInMB) {
		return new GoogleCloudStorage(capacityInMB);
	}

}
