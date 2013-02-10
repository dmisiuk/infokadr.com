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

    /**
     * **************************************
     * <p/>
     * Film's CRUD
     * <p/>
     * ***************************************
     */

    Film createFilm(Film film);

    List<Film> getAllFilms();

    Film getFilm(Long id);

    void updateFilm(Film film);

    void deleteFilm(Long id);

    void deleteFilm(Film film);

    /**
     * **************************************
     * <p/>
     * Trailer's CRUD
     * <p/>
     * ***************************************
     */

    Trailer createTrailer(Trailer trailer, Long filmID);

    Trailer createTrailer(Trailer trailer, Film film);

    List<Trailer> getTrailer();

    Trailer getTrailer(Long id);

    Trailer getTrailer(Long filmId, Long trailerId);

    Trailer getLastTrailer();

    void updateTrailer(Trailer trailer);

    void deleteTrailer(Long id);

    void deleteTrailer(Trailer trailer);

    /**
     * **************************************
     * <p/>
     * Service operations
     * <p/>
     * ***************************************
     */



}
