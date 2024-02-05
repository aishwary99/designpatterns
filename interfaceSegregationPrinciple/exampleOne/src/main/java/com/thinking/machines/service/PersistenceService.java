package com.thinking.machines.service;

import com.thinking.machines.entity.Entity;

public interface PersistenceService<T extends Entity> {
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
}
