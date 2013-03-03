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

    List<T> readQuery(String query);

    List<T> readQuery(String query, Long amount);

    T readLast();

    T update(T t);

    void delete(T t);

    Criteria getCriteria();

    T find(Criteria c);

    List<T> findAll(Criteria c);

    List<T> findByName(String name, String value);

}
