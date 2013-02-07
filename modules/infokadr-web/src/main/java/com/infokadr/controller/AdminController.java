package com.infokadr.controller;

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
        return "admin";
    }

    @RequestMapping(value = "/admin/film/{filmId}", method = RequestMethod.GET)
    public String getFilm(@PathVariable Long filmId, ModelMap model) {
        model.put("film", service.getFilm(filmId));
        return "film";
    }
}
