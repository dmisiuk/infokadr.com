package com.infokadr.dao;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * User: Dzmitry
 * Date: 29.01.13
 * Time: 21:04
 */
public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {

    private SessionFactory sessionFactory;

    private static Logger log = Logger.getLogger(DaoImpl.class);
    private Class<T> type;
    private String typeName;


    public DaoImpl(Class<T> type) {
        this.type = type;
        typeName = type.getSimpleName();
        log.debug(String.format("Created Dao for %s.", typeName));
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public PK create(T t) {
        log.debug(String.format("Create %s: %s.", typeName, t));
        PK pk = (PK) getSession().save(t);
        log.debug(String.format("Created Dao for %s.", typeName));
        return pk;
    }

    @Override
    public T read(PK id) {
        log.debug(String.format("Get %s with id=%s.", typeName, id));
        T t = (T) getSession().get(type, id);
        log.debug(String.format("Got %s: %s.", typeName, t));
        return t;
    }

    @Override
    public List<T> readAll() {
        log.debug(String.format("Get all <%s>.", typeName));
        List<T> list = getSession().createCriteria(type).list();
        log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
        return list;
    }

    @Override
    public Criteria getCriteria() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> find(Criteria c) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T update(T t) {
        log.debug(String.format("Update %s: %s.", typeName, t));
        getSession().update(t);
        log.debug(String.format("Updated %s: %s.", typeName, t));
        return t;
    }

    @Override
    public void delete(T t) {
        log.debug(String.format("Delete %s: %s.", typeName, t));
        if (t != null) {
            getSession().delete(t);
            log.debug(String.format("Deleted %s: %s.", typeName, t));
        }
    }

    public Session getSession(){
        Session session = sessionFactory.getCurrentSession();
        log.debug(String.format("Got current session for %s: %s.", typeName, session));
        return session;
    }
}
