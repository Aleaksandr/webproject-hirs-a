package by.webproject.hirs.impl;

import by.webproject.hirs.BuyManager;
import by.webproject.hirs.dao.IBuyDao;
import by.webproject.hirs.entityes.Buy;
import by.webproject.hirs.exception.PersistException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hirs akeaksandr on 25.04.15.
 * Implements class of Executor
 */

@Service("buyManager")
@Transactional(propagation = Propagation.REQUIRED,
				isolation = Isolation.READ_COMMITTED,
				readOnly = false)
public class ImplBuyManager implements BuyManager {

	protected static Logger logger = Logger.getLogger(ImplBuyManager.class);

	@Autowired
	IBuyDao buyDao;


	@Override
	@Transactional(readOnly = true)
	public List<Buy> getAll() throws PersistException {
		List<Buy> allList = buyDao.getAll();
		if (allList == null) {
			allList = new ArrayList<>();
		}
		return allList;
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountBuys() throws PersistException {
		Integer count = 0;
		count = buyDao.getCountBuys();
		return count;
	}

	@Override
	@Transactional(readOnly = true)
	public String[] getBuysListNameArray() throws PersistException {
		return buyDao.getBuysListNameArray();
	}

	@Override
	@Transactional
	public Buy add(Buy buy) throws PersistException {
		return buyDao.save(buy);
	}

	@Override
	@Transactional
	public void update(Buy buy) throws PersistException {
		buyDao.update(buy);
	}

	@Override
	@Transactional(readOnly = true)
	public Buy get(Serializable id) throws PersistException {
		return buyDao.get(id);
	}

	@Override
	@Transactional (rollbackFor = Exception.class)
	public void delete(Buy buy) throws PersistException {
		buyDao.remove(buy);
	}

	@Override
	@Transactional (rollbackFor = Exception.class)
	public void delete(Serializable id) throws PersistException {
		buyDao.remove(buyDao.get(id));
	}

	@Override
	@Transactional
	public void refresh(Buy buy) throws PersistException {
		buyDao.refresh(buy);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Buy> loadAll() throws PersistException {
		return buyDao.loadAll();
	}
}
