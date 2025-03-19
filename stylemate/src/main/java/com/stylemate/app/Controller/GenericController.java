package com.stylemate.app.Controller;

import org.springframework.http.ResponseEntity;

public interface GenericController<T, ID> {
    ResponseEntity<String> create(T entity);
    ResponseEntity<T> update(ID id, T entity);
    ResponseEntity<Void> delete(ID id);
}
