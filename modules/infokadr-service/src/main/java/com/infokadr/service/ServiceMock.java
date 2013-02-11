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
    private Film film1, film2;
    private Trailer trailer1;
    private Trailer trailer2;

    private static int counter;


    public ServiceMock() {
        counter = 1;

        film1 = new Film();
        film1.setId(new Long(next()));
        film1.setRusName("Шерлок Холмс: Игра теней");
        film1.setEngName("Sherlock Holmes: A Game of Shadows");
        film1.setTimestamp(new Date());

        film2 = new Film();
        film2.setId(next());
        film2.setRusName("Батман");
        film2.setEngName("Batman");
        film2.setTimestamp(new Date());


        trailer1 = new Trailer();
        trailer1.setId(next());
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
        trailer2.setId(next());
        trailer2.setName("Обзор фильма - Шерлок Холмс: Игра теней");
        trailer2.setShortName("Обзор фильма");
        trailer2.setTimestamp(new Date());
        trailer2.setDescription("«Шерлок Холмс: Игра теней» («Sherlock Holmes: A Game of Shadows») " +
                "оправдает все ожидания! Подробности - в нашем обзоре.");
        trailer2.setUrl("http://www.youtube.com/embed/-O-_R5Y2DZA");

        trailer1.setFilm(film1);
        trailer2.setFilm(film1);

        List<Trailer> trailerList = new ArrayList<Trailer>();
        trailerList.add(trailer1);
        trailerList.add(trailer2);
        film1.setTrailers(trailerList);

        filmList = new ArrayList<Film>();
        filmList.add(film1);
        filmList.add(film2);
    }

    @Override
    public Film createFilm(Film film) {
        film.setId(next());
        film.setTimestamp(new Date());
        filmList.add(film);
        return film;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmList;
    }

    @Override
    public Film getFilm(Long id) {
        for(Film film: filmList){
            if (film.getId().equals(id)) return film;
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


    private Long next() {
        return new Long(counter++);
    }
}
