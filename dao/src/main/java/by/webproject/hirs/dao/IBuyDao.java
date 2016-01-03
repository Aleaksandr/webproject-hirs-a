package by.webproject.hirs.dao;

import by.webproject.hirs.entityes.Buy;
import by.webproject.hirs.exception.PersistException;


import java.util.List;

/**
 * Created by hirs akeaksandr on 28.10.15.
 * Executor interface class
 */

public interface IBuyDao extends Dao<Buy> {


//    /** Gets the appropriate List<Executor> by period */
//    public List<Buy> getExecutorsByPeriod(int first, int second) throws PersistException;
//
    /** Gets all Executors*/
    public List<Buy> getAll() throws PersistException;

    public String[] getBuysListNameArray() throws PersistException;

    /** Gets count Buys*/
    public int getCountBuys() throws PersistException;

//    /** Gets Executor by name*/
//    public Buy getExecutorByName(String name) throws PersistException;
//
//    /** Gets Executors with status Active*/
//    public List<Buy> getActiveExecutors() throws PersistException;
}