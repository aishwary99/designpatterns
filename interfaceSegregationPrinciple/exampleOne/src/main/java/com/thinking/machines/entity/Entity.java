package com.thinking.machines.entity;

public abstract class Entity {
	
	private Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
}
