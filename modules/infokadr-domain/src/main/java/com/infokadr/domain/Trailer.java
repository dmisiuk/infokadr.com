package com.infokadr.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * User: dzmitry.misiuk
 * Date: 1/28/13
 * Time: 12:13 AM
 */
@Entity
@Table(name = "T_TRAILER")
public class Trailer implements Serializable {

    private static final long serialVersionUID = 7411815236928129709L;

    @Id
    @GeneratedValue
    @Column(name = "F_ID", nullable = false)
    private Long id;

    @Column(name = "F_NAME", nullable = false)
    @NotBlank
    @Size(min = 1)
    private String name;

    @Column(name = "F_SHORT_NAME")
    @NotBlank
    @Size(min = 1)
    private String shortName;

    @Column(name = "F_DESCRIPTION")
    private String description;

    @Column(name = "F_URL")
    private String url;

    @Column(name = "F_ADDED_DATE")
    private Date addedDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FILM_ID")
    private Film film;

    public Trailer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trailer trailer = (Trailer) o;

        if (addedDate != null ? !addedDate.equals(trailer.addedDate) : trailer.addedDate != null) return false;
        if (description != null ? !description.equals(trailer.description) : trailer.description != null) return false;
        if (film != null ? !film.equals(trailer.film) : trailer.film != null) return false;
        if (id != null ? !id.equals(trailer.id) : trailer.id != null) return false;
        if (name != null ? !name.equals(trailer.name) : trailer.name != null) return false;
        if (shortName != null ? !shortName.equals(trailer.shortName) : trailer.shortName != null) return false;
        if (url != null ? !url.equals(trailer.url) : trailer.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (film != null ? film.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", addedDate=" + addedDate +
                ", film=" + film +
                '}';
    }
}

