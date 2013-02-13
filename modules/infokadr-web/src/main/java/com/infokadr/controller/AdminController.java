package com.infokadr.controller;

import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import com.infokadr.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String getAllFilms(ModelMap model) {
        model.put("films", service.getAllFilms());
        model.put("title", "Все фильмы");
        return "admin";
    }


    @RequestMapping(value = "/admin/film/new", method = RequestMethod.GET)
    public String showAddFilm(ModelMap model) {
        model.put("title", "Добавить новый фильм");
        model.put("film", new Film());
        return "newFilm";
    }

    @RequestMapping(value = "/admin/film/new", method = RequestMethod.POST)
    public String createFilm(@Valid Film film, BindingResult result, Model model, RedirectAttributes ra) {
        if (result.hasErrors()) {
            model.addAttribute("flashError", "Error create");
            return "newFilm";
        }
        service.createFilm(film);
        Long filmId = film.getId();
        model.asMap().clear();
        ra.addFlashAttribute("flashSuccess", "Success create film");
        return String.format("redirect:/admin/film/%s", filmId);
    }


    @RequestMapping(value = "/admin/film/{filmId}", method = RequestMethod.GET)
    public String getFilm(@PathVariable Long filmId, ModelMap model) {
        Film film = service.getFilm(filmId);
        model.put("film", film);
        model.put("title", film.getRusName());
        return "film";
    }

    @RequestMapping(value = "/admin/film/{filmId}", method = RequestMethod.POST)
    public String updateFilm(@PathVariable Long filmId, @Valid Film film, BindingResult result, Model model, RedirectAttributes ra) {
        model.addAttribute("title", film.getRusName());
        if (result.hasErrors()) {
            model.addAttribute("flashError", "Error update");
            return "film";
        }
        Film f = service.getFilm(filmId);
        f.setEngName(film.getEngName());
        f.setRusName(film.getRusName());
        service.updateFilm(f);
        model.asMap().clear();
        ra.addFlashAttribute("flashSuccess", "Success update film");
        return "redirect:/admin/film/{filmId}";
    }

    @RequestMapping(value = "/admin/film/{filmId}/video/new", method = RequestMethod.GET)
    public String getTrailer(@PathVariable Long filmId, ModelMap model) {
        Film film = service.getFilm(filmId);
        model.put("film", film);
        model.put("trailer", new Trailer());
        model.put("title", "Добавить новый трейлер к фильму " + film.getRusName());
        return "newTrailer";
    }

    @RequestMapping(value = "/admin/film/{filmId}/video/new", method = RequestMethod.POST)
    public String createTrailer(@Valid Trailer trailer, @PathVariable Long filmId, ModelMap model, RedirectAttributes ra, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("flashError", "Error create trailer");
            return "newTrailer";
        }
        service.createTrailer(trailer, filmId);
        ra.addFlashAttribute("flashSuccess", "Success create trailer");
        return String.format("redirect:/admin/film/{filmId}/video/%s", trailer.getId());
    }


    @RequestMapping(value = "/admin/film/{filmId}/video/{trailerId}", method = RequestMethod.GET)
    public String getTrailer(@PathVariable Long filmId, @PathVariable Long trailerId, ModelMap model) {
        Trailer trailer = service.getTrailer(filmId, trailerId);
        model.put("trailer", trailer);
        model.put("title", trailer.getName());
        return "trailer";
    }

    @RequestMapping(value = "/admin/film/{filmId}/video/{trailerId}", method = RequestMethod.POST)
    public String updateTrailer(@PathVariable Long trailerId, @Valid Trailer trailer,
                                @PathVariable Long filmId, ModelMap model, RedirectAttributes ra, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("flashError", "Error update trailer");
            return "trailer";
        }
        Trailer t = service.getTrailer(trailerId);
        t.setUrl(trailer.getUrl());
        t.setDescription(trailer.getDescription());
        t.setName(trailer.getName());
        t.setShortName(trailer.getShortName());
        service.updateTrailer(t);
        ra.addFlashAttribute("flashSuccess", "Success update trailer");
        return "redirect:/admin/film/{filmId}/video/{trailerId}";
    }


}
