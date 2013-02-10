package com.infokadr.service;

import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 10:11 PM
 */
public class ServiceMock implements IService {


    private ArrayList<Film> filmList;
    private Film film, film2;
    private Trailer trailer1;
    private Trailer trailer2;


    public ServiceMock() {
        film = new Film();
        film.setId(new Long(1));
        film.setRusName("Шерлок Холмс: Игра теней");
        film.setEngName("Sherlock Holmes: A Game of Shadows");
        film.setTimestamp(new Date());

        film2 = new Film();
        film2.setId(new Long(2));
        film2.setRusName("Батман");
        film2.setEngName("Batman");
        film2.setTimestamp(new Date());


        trailer1 = new Trailer();
        trailer1.setId(new Long(3));
        trailer1.setName("Шерлок Холмс 2: Игра теней. Русский трейлер FTR '2011'. HD");
        trailer1.setShortName("FTR 2011");
        trailer1.setTimestamp(new Date());
        trailer1.setDescription("год \n" +
                "2011\n" +
                "страна \n" +
                "США\n" +
                "слоган -\n" +
                "режиссер Гай Ричи");
        trailer1.setUrl("http://www.youtube.com/embed/AwV9L9M4n3I");

        trailer2 = new Trailer();
        trailer2.setId(new Long(4));
        trailer2.setName("Обзор фильма - Шерлок Холмс: Игра теней");
        trailer2.setShortName("Обзор фильма");
        trailer2.setTimestamp(new Date());
        trailer2.setDescription("«Шерлок Холмс: Игра теней» («Sherlock Holmes: A Game of Shadows») " +
                "оправдает все ожидания! Подробности - в нашем обзоре.");
        trailer2.setUrl("http://www.youtube.com/embed/-O-_R5Y2DZA");

        trailer1.setFilm(film);
        trailer2.setFilm(film);

        List<Trailer> trailerList = new ArrayList<Trailer>();
        trailerList.add(trailer1);
        trailerList.add(trailer2);
        film.setTrailers(trailerList);

        filmList = new ArrayList<Film>();
        filmList.add(film);
        filmList.add(film2);
    }

    @Override
    public Film createFilm(Film film) {
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmList;
    }

    @Override
    public Film getFilm(Long id) {
        if (id == 1) {
            return film;
        }
        if (id == 2) {
            return film2;
        }
        return null;
    }

    @Override
    public void updateFilm(Film film) {

    }

    @Override
    public void deleteFilm(Long id) {

    }

    @Override
    public void deleteFilm(Film film) {

    }

    @Override
    public Trailer createTrailer(Trailer trailer, Long filmID) {
        return null;
    }

    @Override
    public Trailer createTrailer(Trailer trailer, Film film) {
        return null;
    }

    @Override
    public List<Trailer> getTrailer() {
        return null;
    }

    @Override
    public Trailer getTrailer(Long id) {
        if (id == 3) {
            return trailer1;
        }
        if (id == 4) {
            return trailer2;
        }

        return null;
    }

    @Override
    public void updateTrailer(Trailer trailer) {

    }

    @Override
    public void deleteTrailer(Long id) {

    }

    @Override
    public void deleteTrailer(Trailer trailer) {

    }

    @Override
    public Trailer getLastTrailer() {
        return trailer1;
    }

    @Override
    public Trailer getTrailer(Long filmId, Long trailerId) {
        if (filmId == 1 && trailerId == 3) {
            return trailer1;
        }
        if (filmId == 1 && trailerId == 4) {
            return trailer2;
        }

        return null;
    }
}