package com.infokadr.controller;

import com.infokadr.domain.Trailer;
import com.infokadr.service.IService;
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
        model.put("trailer", service.getLastTrailer());
        model.put("title", "Инфокадр: трейлеры фильмов 2012-2013 и кадросюжеты | новые трейлеры онлайн | кадры из фильмов");
        return "video";
    }

    @RequestMapping(value = "/video/{trailerId}")
    public String getVideo(@PathVariable Long trailerId, ModelMap model) {
        Trailer trailer = service.getTrailer(trailerId);
        model.put("trailer", trailer);
        model.put("title", trailer.getName());
        return "video";
    }
}
