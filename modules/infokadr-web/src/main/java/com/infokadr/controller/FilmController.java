package com.infokadr.controller;

import com.infokadr.domain.Film;
import com.infokadr.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 12:29 AM
 */
@Controller
@RequestMapping(value = "/film")
public class FilmController {

    @Autowired
    private IService service;

    @RequestMapping(value = "search")
    public
    @ResponseBody
    List<String> getAllFilms(@RequestParam(value = "text") String text) {
        List<String> names = new ArrayList<String>(10);
        for (Film f : service.findFilmsByName(text)) {
            if (text.matches("^[\\w]+$")) {
                names.add(f.getEngName());
            } else {
                names.add(f.getRusName());
            }
        }
        return names;
    }
}
