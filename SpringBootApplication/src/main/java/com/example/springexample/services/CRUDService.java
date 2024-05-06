package com.example.springexample.services;

import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface CRUDService<T> {
    ResponseEntity getById(Integer id);
    Collection<T> getAll();
    ResponseEntity create(T item);
    ResponseEntity update(Integer id, T item);
    ResponseEntity delete(Integer id);
}
