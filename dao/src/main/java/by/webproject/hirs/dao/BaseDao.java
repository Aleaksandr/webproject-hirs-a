package by.webproject.hirs.dao;


import by.webproject.hirs.exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T save(T t) throws PersistException {
        try{
            getSession().save(t);
            log.info("Save:" + t);
        } catch (HibernateException e) {
            log.error("Error Save object: " + e);
            throw new PersistException(e);
        }
        return (T) t;
    }

    @Override
    public void update(T t) throws PersistException {
        try{
            getSession().update(t);
            log.info("Update:" + t);
        } catch (HibernateException e) {
            log.error("Error Update object: " + e);
            throw new PersistException(e);
        }
    }

    @Override
    public T get(Serializable id) throws PersistException {
        T entity = null;
        try {
            entity = (T) getSession().get(getPersistentClass(), id);
        } catch (HibernateException e) {
            log.error("Error get object by id from Database: " + e);
            throw new PersistException(e);
        }
        return entity;
    }

    @Override
    public void remove(T t) throws PersistException {
        try {
            getSession().delete(t);
            log.info("Delete: " + t);
        } catch (HibernateException e) {
            log.error("Error delete object from Database: " + e);
            throw new PersistException(e);
        }
    }

    @Override
    public void refresh(T t) throws PersistException {
        try {
            log.info("Refresh:" + t);
            getSession().refresh(t);
        } catch (HibernateException e) {
            log.error("Error refresh object from Database: " + e);
            throw new PersistException(e);
        }
    }

    public List<T> loadAll() throws PersistException {
        List<T> tAll;
        try{
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.setCacheable(true);
            tAll = criteria.list();
        }catch (HibernateException e) {
            log.error("Error loadAll objects from Database: " + e);
            throw new PersistException(e);
        }
        return tAll;
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
