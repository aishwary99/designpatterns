package com.thinking.machines.abstractfactory.aws;

import com.thinking.machines.abstractfactory.instance.Instance;
import com.thinking.machines.abstractfactory.instance.Instance.Capacity;
import com.thinking.machines.abstractfactory.instance.ResourceFactory;
import com.thinking.machines.abstractfactory.storage.Storage;

public class AWSResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new EC2Instance(capacity);
	}

	@Override
	public Storage createStorage(int capacityInMB) {
		return new S3Storage(capacityInMB);
	}
	
}
