package com.infokadr.controller;

import com.google.common.collect.Lists;
import com.infokadr.domain.Trailer;
import com.infokadr.service.IService;
import com.infokadr.util.InjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 12:29 AM
 */
@Controller
public class VideoController {

    @Autowired
    private IService service;

    @RequestMapping(value = "/")
    public String getLastVideo(ModelMap model) {
        Trailer trailer = service.getLastTrailer();
        if (trailer == null){
            return "redirect:/admin";
        }
        String newTrailerName = InjectUtil.injectFilmName(trailer.getName(), trailer.getFilm());
        trailer.setName(newTrailerName);
        model.put("title", "Инфокадр: трейлеры фильмов 2012-2013 и кадросюжеты | новые трейлеры онлайн | кадры из фильмов");
        return fillModel(model, trailer);
    }

    @RequestMapping(value = "/video/{trailerId}")
    public String getVideo(@PathVariable Long trailerId, ModelMap model) {
        Trailer trailer = service.getTrailer(trailerId);
        String newTrailerName = InjectUtil.injectFilmName(trailer.getName(), trailer.getFilm());
        trailer.setName(newTrailerName);
        model.put("title", trailer.getName());
        return fillModel(model, trailer);
    }

    private String fillModel(ModelMap model, Trailer trailer) {
        model.put("trailer", trailer);
        model.put("trailers", Lists.reverse(trailer.getFilm().getTrailers()));
        model.put("trailersAfter", service.getAfter(trailer.getId(), 5L));
        model.put("trailersBefore", service.getBefore(trailer.getId(), 5L));
        return "video";
    }
}
