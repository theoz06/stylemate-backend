package com.stylemate.app.Controller;

import org.springframework.http.ResponseEntity;

public interface GenericController<T, ID> {
    ResponseEntity<String> create(T entity);
    ResponseEntity<String> update(ID id, T entity);
    ResponseEntity<String> delete(ID id);
}
