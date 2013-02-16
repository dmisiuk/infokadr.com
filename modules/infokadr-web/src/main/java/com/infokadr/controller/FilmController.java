package com.infokadr.controller;

import com.infokadr.domain.Film;
import com.infokadr.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 12:29 AM
 */
@Controller
public class FilmController {

    @Autowired
    private IService service;

    @RequestMapping(value = "/films")
    public
    @ResponseBody
    List<Film> getAllFilms() {
        return service.getAllFilms();
    }

}
