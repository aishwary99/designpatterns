package com.thinking.machines.abstractfactory.aws;

import com.thinking.machines.abstractfactory.instance.Instance;
import com.thinking.machines.abstractfactory.storage.Storage;

public class EC2Instance implements Instance {
	
	public EC2Instance(Capacity capacity) {
		System.out.println("EC2 instance created : " + capacity);
	}

	@Override
	public void start() {
		System.out.println("EC2 instance started");
	}

	@Override
	public void stop() {
		System.out.println("EC2 instance stopped");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("EC2 instance storage attached : " + storage.getId());
	}

}
