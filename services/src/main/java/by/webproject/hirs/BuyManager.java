package by.webproject.hirs;


import by.webproject.hirs.entityes.Buy;
import by.webproject.hirs.exception.PersistException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hirs akeaksandr on 28.10.15.
 * Interface of BuyManager
 */

public interface BuyManager extends IService<Buy> {

//	/** Gets the the appropriate List<Executor> by period */
//	public List<Buy> getExecutorsByPeriod(int first, int second) throws PersistException;

	/** Gets all Executors*/
	public List<Buy> getAll() throws PersistException;

//	/** Gets Executors with status Active*/
//	public List<Buy> getActiveExecutors() throws PersistException;

	/** Gets count Buys*/
	public int getCountBuys() throws PersistException;

//	/** Gets Executor by name*/
//	public Buy getExecutorByName(String name) throws PersistException;

	/** Delete by id*/
	public void delete(Serializable id) throws PersistException;
}
