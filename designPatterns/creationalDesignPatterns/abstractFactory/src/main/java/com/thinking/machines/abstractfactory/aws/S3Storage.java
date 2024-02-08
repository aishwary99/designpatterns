package com.thinking.machines.abstractfactory.aws;

import com.thinking.machines.abstractfactory.storage.Storage;

public class S3Storage implements Storage {
	
	public S3Storage(int capacityInMB) {
		System.out.println("S3 storage created : " + capacityInMB);
	}

	@Override
	public String getId() {
		return "aws-s3-1";
	}

}
