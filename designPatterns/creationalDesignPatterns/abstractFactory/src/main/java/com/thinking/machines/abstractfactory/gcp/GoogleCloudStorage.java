package com.thinking.machines.abstractfactory.gcp;

import com.thinking.machines.abstractfactory.storage.Storage;

public class GoogleCloudStorage implements Storage {
	
	public GoogleCloudStorage(int storageInMB) {
		System.out.println("Allocated : " + this.getId() + " storage : " + storageInMB);
	}

	@Override
	public String getId() {
		return "gcp-cs-1";
	}

}
