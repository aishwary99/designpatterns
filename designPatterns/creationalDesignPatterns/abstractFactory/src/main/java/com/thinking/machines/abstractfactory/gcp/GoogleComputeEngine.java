package com.thinking.machines.abstractfactory.gcp;

import com.thinking.machines.abstractfactory.instance.Instance;
import com.thinking.machines.abstractfactory.storage.Storage;

public class GoogleComputeEngine implements Instance {
	
	public GoogleComputeEngine(Capacity capacity) {
		System.out.println("Google Compute Engine created : " + capacity);
	}

	@Override
	public void start() {
		System.out.println("Google Compute Engine started");
	}

	@Override
	public void stop() {
		System.out.println("Google Compute Engine stopped");
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("GCE storage attached : " + storage.getId());
	}

}
