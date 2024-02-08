package com.thinking.machines.abstractfactory;

import com.thinking.machines.abstractfactory.aws.AWSResourceFactory;
import com.thinking.machines.abstractfactory.instance.Instance;
import com.thinking.machines.abstractfactory.instance.Instance.Capacity;
import com.thinking.machines.abstractfactory.instance.ResourceFactory;
import com.thinking.machines.abstractfactory.storage.Storage;

public class Driver {
	
	private ResourceFactory resourceFactory;
	
	public Driver(ResourceFactory resourceFactory) {
		this.resourceFactory = resourceFactory;
	}
	
	public Instance createServer(Instance.Capacity capacity, int storageInMB) {
		Instance instance = resourceFactory.createInstance(capacity);
		Storage storage = resourceFactory.createStorage(storageInMB);
		
		instance.attachStorage(storage);
		
		return instance;
	}
	
	public static void main(String args[]) {
		Driver awsResourceFactory = new Driver(new AWSResourceFactory());
		
		Instance instance = awsResourceFactory.createServer(Capacity.LARGE, 20480);
		
		instance.start();
		instance.stop();
	}
}
