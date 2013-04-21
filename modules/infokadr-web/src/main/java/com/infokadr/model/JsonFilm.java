package com.infokadr.model;

import java.io.Serializable;

/**
 * User: dzmitry.misiuk
 * Date: 4/21/13
 * Time: 11:51 PM
 */
public class JsonFilm implements Serializable {

    private String value;
    private Long id;

    public JsonFilm() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JsonFilm jsonFilm = (JsonFilm) o;

        if (id != null ? !id.equals(jsonFilm.id) : jsonFilm.id != null) return false;
        if (value != null ? !value.equals(jsonFilm.value) : jsonFilm.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
