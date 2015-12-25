
package by.webproject.hirs;

import by.webproject.hirs.dao.Dao;
import by.webproject.hirs.exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseService<T> implements IService<T> {

    private static Logger logger = Logger.getLogger(BaseService.class);

    private Dao<T> baseDao;

    public BaseService() {
    }

    @Autowired
    public BaseService(Dao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T add(T t) throws PersistException {
        T it = baseDao.save(t);
        return it;
    }

    @Override
    public void update(T t) throws PersistException {
        baseDao.update(t);
    }

    @Override
    public T get(Serializable id) throws PersistException {
        return baseDao.get(id);
    }

    @Override
    public void delete(T t) throws PersistException {
        baseDao.remove(t);
    }

    @Override
    public void refresh(T t) throws PersistException {
        baseDao.refresh(t);
    }

    @Override
    public List<T> loadAll() throws PersistException {
        return baseDao.loadAll();
    }
}
