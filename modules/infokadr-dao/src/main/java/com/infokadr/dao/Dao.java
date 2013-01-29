package com.infokadr.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
 * Date: 29.01.13
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */
public interface Dao<T, PK extends Serializable> {

    PK create(T t);

    T read(PK id);

    List<T> readAll();

    Criteria getCriteria();
    List<T> find(Criteria c);

    T update(T t);

    void delete(T t);

}
