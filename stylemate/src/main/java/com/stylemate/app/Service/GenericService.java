package com.stylemate.app.Service;

public interface GenericService<T, ID>{
    T create (T entity);
    T update (ID id, T entity);
    void delete (ID id);
}