package com.infokadr.controller;

import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import com.infokadr.model.JsonFilm;
import com.infokadr.service.IService;
import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(FilmController.class);

    @Autowired
    private IService service;

    @RequestMapping(value = "search")

    @ResponseBody
    public List<String> getAllFilms(@RequestParam(value = "text") String text) {
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

    @RequestMapping(value = "searh-jquery-ui")
    @ResponseBody
    public List<JsonFilm> getJsonFilmsByName(@RequestParam(value = "term") String term) {
        log.info("Search all films for term: " + term);
        List<JsonFilm> films = new ArrayList<JsonFilm>(10);
        for (Film f : service.findFilmsByName(term)) {
            if (f.getTrailers().isEmpty()) {
                break;
            }

            String value;
            if (term.matches("^[\\w]+$")) {
                value = f.getEngName();
            } else {
                value = f.getRusName();
            }
            JsonFilm jsonFilm = new JsonFilm();
            jsonFilm.setValue(value);
            Trailer lastTrailer = f.getTrailers().get(f.getTrailers().size() - 1);
            jsonFilm.setId(lastTrailer.getId());
            films.add(jsonFilm);
        }
        return films;
    }
}
