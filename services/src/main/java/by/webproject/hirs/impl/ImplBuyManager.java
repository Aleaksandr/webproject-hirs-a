package by.webproject.hirs.impl;

import by.webproject.hirs.BuyManager;
import by.webproject.hirs.dao.IBuyDao;
import by.webproject.hirs.entityes.Buy;
import by.webproject.hirs.exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hirs akeaksandr on 25.04.15.
 * Implements class of Executor
 */

@Service("buyManager")
@Transactional(propagation = Propagation.REQUIRED)
public class ImplBuyManager implements BuyManager {

	protected static Logger logger = Logger.getLogger(ImplBuyManager.class);

	@Autowired
	IBuyDao buyDao;

//	@Override
//	public Buy getExecutorByName(String name) throws PersistException {
//		Buy e = null;
//		e = buyDao.getExecutorByName(name);
//		return e;
//	}
//
//	@Override
//	public List<Executor> getExecutorsByPeriod(int first, int second) throws PersistException {
//		List<Executor> eList = null;
//		eList = executorDao.getExecutorsByPeriod(first, second);
//		return eList;
//	}
//
//	@Override
//	public List<Executor> getActiveExecutors() throws PersistException {
//		List<Executor> eList = null;
//		eList = executorDao.getActiveExecutors();
//		return eList;
//	}

	@Override
	public List<Buy> getAll() throws PersistException {
		List<Buy> nList = null;
		nList = buyDao.getAll();
		return nList;
	}

	@Override
	public int getCountBuys() throws PersistException {
		Integer count = 0;
		count = buyDao.getCountBuys();
		return count;
	}

	@Override
	public String[] getBuysListNameArray() throws PersistException {
		return buyDao.getBuysListNameArray();
	}

	@Override
	public Buy add(Buy buy) throws PersistException {
		return buyDao.save(buy);
	}

	@Override
	public void update(Buy buy) throws PersistException {
		buyDao.update(buy);
	}

	@Override
	public Buy get(Serializable id) throws PersistException {
		return buyDao.get(id);
	}

	@Override
	public void delete(Buy buy) throws PersistException {
		buyDao.remove(buy);
	}

	@Override
	public void delete(Serializable id) throws PersistException {
		buyDao.remove(buyDao.get(id));
	}

	@Override
	public void refresh(Buy buy) throws PersistException {
		buyDao.refresh(buy);
	}

	@Override
	public List<Buy> loadAll() throws PersistException {
		return buyDao.loadAll();
	}
}
