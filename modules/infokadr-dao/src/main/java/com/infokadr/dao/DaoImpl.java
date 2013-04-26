package com.infokadr.dao;

import org.apache.log4j.Logger;
import org.hibernate.*;

import java.io.Serializable;
import java.util.List;

/**
 * User: Dzmitry Khralovich
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

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
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
        //List<T> list = getSession().createCriteria(type).list();
        List<T> list = getSession().createQuery("from " + typeName).list();
        log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
        return list;
    }

    @Override
    public List<T> readQuery(String query) {
        log.debug(String.format("Get list by query %s.", query));
        List<T> list = getSession().createQuery(query).list();
        log.debug(String.format("Got %d entities", list == null ? 0 : list.size()));
        return list;
    }

    @Override
    public List<T> readQuery(String query, Long amount) {
        log.debug(String.format("Get list by query %s amount.", query));
        List<T> list;
        Query queryHQL = getSession().createQuery("from " + typeName + " " + query);
        queryHQL.setMaxResults((int) (long) amount);
        list = (List<T>) queryHQL.list();
        log.debug(String.format("Got %d entities", list == null ? 0 : list.size()));
        return list;
    }

    @Override
    public T readLast() {
        String sort = "addedDate";       //Rigid logic, remember the name of a date variable
        log.debug(String.format("Get last %s sort by %s. ", typeName, sort));
        Query query = getSession().createQuery("from " + typeName + " order by " + sort + " DESC");
        query.setMaxResults(1);
        T t = (T) query.uniqueResult();
        log.debug(String.format("Got %s: %s.", typeName, t));
        return t;
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

    public Session getSession() {
        Session session = sessionFactory.getCurrentSession();
        log.debug(String.format("Got current session for %s: %s.", typeName, session));
        return session;
    }

    @Override
    public Criteria getCriteria() {
        return getSession().createCriteria(type);
    }

    @Override
    public T find(Criteria c) {
        log.debug(String.format("Find <%s> by criteria %s.", typeName, c));
        T t = (T) c.list().get(0);
        log.debug(String.format("Found entity: %s", t));
        return null;
    }

    @Override
    public List<T> findAll(Criteria c) {
        log.debug(String.format("Find <%s> by criteria %s.", typeName, c));
        List<T> list = c.list();
        log.debug(String.format("Found %d entities", list == null ? 0 : list.size()));
        return list;
    }

    @Override
    public List<T> findByName(String name, String value) {
        log.debug(String.format("Get list by name %s.", name));
        List<T> list;
        Query queryHQL = getSession().createQuery("from " + typeName +" where "+ name +" like :value");
        list = queryHQL.setParameter("value", "%" + value + "%").list();
        log.debug(String.format("Got %d entities", list == null ? 0 : list.size()));
        return list;
    }

}
