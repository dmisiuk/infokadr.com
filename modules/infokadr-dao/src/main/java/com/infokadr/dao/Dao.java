package com.infokadr.dao;

import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

/**
 * User: Dzmitry
 * Date: 29.01.13
 * Time: 20:43
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