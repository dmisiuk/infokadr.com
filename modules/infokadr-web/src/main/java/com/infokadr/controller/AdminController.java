package com.infokadr.controller;

import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import com.infokadr.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 12:29 AM
 */
@Controller
public class AdminController {

    @Autowired
    private IService service;

    @RequestMapping(value = "/admin")
    public String getLastVideo(ModelMap model) {
        model.put("films", service.getAllFilms());
        model.put("title", "Все фильмы");
        return "admin";
    }

    @RequestMapping(value = "/admin/film/{filmId}", method = RequestMethod.GET)
    public String getFilm(@PathVariable Long filmId, ModelMap model) {
        Film film =  service.getFilm(filmId);
        model.put("film", film);
        model.put("title", film.getRusName());
        return "film";
    }


    @RequestMapping(value = "/admin/film/new", method = RequestMethod.GET)
    public String showAddFilm(ModelMap model) {
        model.put("title", "Добавить новый фильм");
        return "newFilm";
    }

    @RequestMapping(value = "/admin/film/{filmId}/video/{trailerId}", method = RequestMethod.GET)
    public String getTrailer(@PathVariable Long filmId, @PathVariable Long trailerId, ModelMap model) {
        Trailer trailer = service.getTrailer(filmId, trailerId);
        model.put("trailer", trailer);
        model.put("title", trailer.getName());
        return "trailer";
    }


    @RequestMapping(value = "/admin/film/{filmId}/video/new", method = RequestMethod.GET)
    public String getTrailer(@PathVariable Long filmId, ModelMap model) {
        Film film =  service.getFilm(filmId);
        model.put("film", film);
        model.put("title", "Добавить новый трейлер к фильму " + film.getRusName());
        return "newTrailer";
    }

}
