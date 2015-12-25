package by.webproject.hirs;


import by.webproject.hirs.exception.PersistException;

import java.io.Serializable;
import java.util.List;

public interface IService<T> {
    T add(T t) throws PersistException;

    void update(T t) throws PersistException;

    T get(Serializable id) throws PersistException;

    void delete(T t) throws PersistException;

    void refresh(T t) throws PersistException;

    public List<T> loadAll() throws PersistException;
}
