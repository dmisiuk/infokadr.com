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


    private List<Film> filmList = new ArrayList<Film>(10);
    private List<Trailer> trailerList = new ArrayList<Trailer>(10);
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
        film1.setDateadd(new Date());

        film2 = new Film();
        film2.setId(next());
        film2.setRusName("Батман");
        film2.setEngName("Batman");
        film2.setDateadd(new Date());


        trailer1 = new Trailer();
        trailer1.setId(next());
        trailer1.setName("Шерлок Холмс 2: Игра теней. Русский трейлер FTR '2011'. HD");
        trailer1.setShortName("FTR 2011");
        trailer1.setDateadd(new Date());
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
        trailer2.setDateadd(new Date());
        trailer2.setDescription("«Шерлок Холмс: Игра теней» («Sherlock Holmes: A Game of Shadows») " +
                "оправдает все ожидания! Подробности - в нашем обзоре.");
        trailer2.setUrl("http://www.youtube.com/embed/-O-_R5Y2DZA");

        trailer1.setFilm(film1);
        trailer2.setFilm(film1);

        film1.getTrailers().add(trailer1);
        film1.getTrailers().add(trailer2);

        filmList.add(film1);
        filmList.add(film2);

        trailerList.add(trailer1);
        trailerList.add(trailer2);
    }

    @Override
    public Film createFilm(Film film) {
        film.setId(next());
        film.setDateadd(new Date());
        filmList.add(film);
        return film;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmList;
    }

    @Override
    public Film getFilm(Long id) {
        for (Film film : filmList) {
            if (film.getId().equals(id)) return film;
        }
        return null;
    }

    @Override
    public void updateFilm(Film film) {
        return;
    }

    @Override
    public void deleteFilm(Long id) {

    }

    @Override
    public void deleteFilm(Film film) {

    }

    @Override
    public Trailer createTrailer(Trailer trailer, Long filmId) {
        Film film = getFilm(filmId);
        trailer.setFilm(film);
        film.getTrailers().add(trailer);
        trailer.setId(next());
        trailer.setDateadd(new Date());
        trailerList.add(trailer);
        return trailer;
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
        for (Trailer trailer : trailerList) {
            if (trailer.getId().equals(id)) return trailer;
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
    public List<Trailer> getAfter(Long id, Long amount) {
        List<Trailer> afterList = new ArrayList<Trailer>();
        boolean b = false;
        int size = 0;
        for (Trailer tr : trailerList) {
            if (afterList.size() == amount) break;
            if (b && afterList.size() < amount) afterList.add(tr);
            if (tr.getId().equals(id)) b = true;
        }
        return afterList;
    }

    @Override
    public List<Trailer> getBefore(Long id, Long amount) {
        List<Trailer> beforeList = new ArrayList<Trailer>();
        int size = trailerList.size();
        boolean b = false;
        for (int i = size - 1; i >= 0; i--) {
            Trailer tr = trailerList.get(i);
            if (beforeList.size() == amount) break;
            if (b && beforeList.size() < amount) beforeList.add(tr);
            if (tr.getId().equals(id)) b = true;
        }
        return beforeList;
    }

    @Override
    public List<Film> findFilmsByName(String text) {
        List<Film> films = new ArrayList<Film>(10);
        for (Film f : filmList) {
            if (f.getRusName().toLowerCase().contains(text.toLowerCase())) films.add(f);
        }
        return films;
    }

    @Override
    public Trailer getLastTrailer() {
        return trailerList.get(trailerList.size() - 1);
    }

    @Override
    public Trailer getTrailer(Long filmId, Long trailerId) {
        Trailer trailer = this.getTrailer(trailerId);
        if (trailer != null && trailer.getFilm().getId().equals(filmId)) {
            return trailer;
        }
        return null;
    }

    private Long next() {
        return new Long(counter++);
    }
}
