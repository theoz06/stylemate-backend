package com.stylemate.app.Service;

public interface GenericService<T, ID>{
    String create (T entity);
    String update (ID id, T entity);
    void delete (ID id);
}