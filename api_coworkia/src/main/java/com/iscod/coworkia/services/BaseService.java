package com.iscod.coworkia.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iscod.coworkia.exceptions.EntityDontExistException;

public abstract class BaseService<T, ID> {
	protected final JpaRepository<T, ID> repository;
	
	protected BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
	
	public List<T> getList() {
        return repository.findAll();
    }

    public T getById(ID id) {
        return repository.findById(id).orElseThrow(()-> new EntityDontExistException(id));
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}
