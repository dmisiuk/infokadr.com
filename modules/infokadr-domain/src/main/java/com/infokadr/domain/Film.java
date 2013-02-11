package com.infokadr.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 1/28/13
 * Time: 12:10 AM
 */
@Entity
public class Film implements Serializable {

    private static final long serialVersionUID = -4702281079235073943L;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank
    @Size(min = 1)
    private String rusName;

    @Column
    @NotBlank
    @Size(min = 1)
    private String engName;

    @Column
    private Date timestamp;

    @Column
    private Long year;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "film", cascade = CascadeType.ALL)
    private List<Trailer> trailers = new ArrayList<Trailer>();

    public Film() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (engName != null ? !engName.equals(film.engName) : film.engName != null) return false;
        if (id != null ? !id.equals(film.id) : film.id != null) return false;
        if (rusName != null ? !rusName.equals(film.rusName) : film.rusName != null) return false;
        if (timestamp != null ? !timestamp.equals(film.timestamp) : film.timestamp != null) return false;
        if (year != null ? !year.equals(film.year) : film.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rusName != null ? rusName.hashCode() : 0);
        result = 31 * result + (engName != null ? engName.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", rusName='" + rusName + '\'' +
                ", engName='" + engName + '\'' +
                ", timestamp=" + timestamp +
                ", year=" + year +
                '}';
    }
}

