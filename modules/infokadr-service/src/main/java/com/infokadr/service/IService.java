package com.infokadr.service;



import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;

import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 03.02.13
 * Time: 23:15
 */
public interface IService {

    /*****************************************
     *
     * Film's CRUD
     *
     *****************************************/

    Film createFilm(Film film);

    List<Film> getFilm();

    Film getFilm(Long id);

    void updateFilm(Film film);

    void deleteFilm(Long id);

    void deleteFilm(Film film);

    /*****************************************
     *
     * Trailer's CRUD
     *
     *****************************************/

    Trailer createTrailer(Trailer trailer, Long filmID);

    Trailer createTrailer(Trailer trailer, Film film);

    List<Trailer> getTrailer();

    Trailer getTrailer(Long id);

    void updateTrailer(Trailer trailer);

    void deleteTrailer(Long id);

    void deleteTrailer(Trailer trailer);
}
