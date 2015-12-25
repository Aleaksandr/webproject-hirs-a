package by.webproject.hirs.impl;

import by.webproject.hirs.dao.BaseDao;
import by.webproject.hirs.dao.IBuyDao;
import by.webproject.hirs.entityes.Buy;
import by.webproject.hirs.exception.PersistException;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hirs akeaksandr on 28.10.15.
 * Extended class to work with Executor bean and mysql database
 */

@Repository("buyDao")
public class BuyDaoImpl extends BaseDao<Buy> implements IBuyDao {

    private static Logger logger = Logger.getLogger(BuyDaoImpl.class);

    @Autowired
    public BuyDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public List<Buy> getAll() throws PersistException {
        List<Buy> newses;
        try {
            String hql = "FROM Buy";
            Query query = getSession().createQuery(hql);
            newses = query.list();
        } catch (HibernateException e) {
            throw new PersistException(e);
        }
        return newses;
    }

    @Override
    public int getCountBuys() throws PersistException {
        long count = 0;
        try {
            String hql = "SELECT COUNT(*) FROM Buy";
            Query query = getSession().createQuery(hql);
            count = (Long) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error("Error getCountBuys method ", e);
            throw new PersistException(e);
        }
        return safeLongToInt(count);
    }

    public static int safeLongToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }


//    /** Gets Executors with status Active*/
//    public List<Buy> getActiveExecutors() throws PersistException {
//        List<Buy> tasks;
//        String statusActive = ExecutorStatusEnum.ACTIVE.toString();
//        try {
//            String hql = "FROM Executor e WHERE e.status="+"'"+statusActive+"'";
//            Query query = getSession().createQuery(hql);
//            tasks = query.list();
//        } catch (HibernateException e) {
//            throw new PersistException(e);
//        }
//        return tasks;
//    }
//
//    /** Gets the the appropriate Executor by name value parameter */
//    @Override
//    public Executor getExecutorByName(String name) {
//        Executor e = null;
//            Session session = getSession();
//            Criteria criteria = session.createCriteria(Executor.class);
//            criteria.setCacheable(true);
//            List<Executor> execList = (List<Executor>) criteria.add(Restrictions.eq("name", name)).list();
//            if (execList != null && !execList.isEmpty()) {
//                e = execList.get(0);
//            }
//        return e;
//    }
//
//    /** Gets the the appropriate List<Executor> by period */
//    @Override
//    public List<Executor> getExecutorsByPeriod(int first, int second) throws PersistException {
//        List<Executor> executors;
//        try {
//            String hql = "FROM Executor";
//            Integer pageSize = second - first;
//            Query query = getSession().createQuery(hql)
//                    .setFirstResult(first)
//                    .setMaxResults(pageSize);
//            executors = query.list();
//        } catch (HibernateException e) {
//            throw new PersistException(e);
//        }
//        return executors;
//    }
}
