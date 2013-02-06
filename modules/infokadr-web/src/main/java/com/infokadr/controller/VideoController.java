package com.infokadr.controller;

import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: dzmitry.misiuk
 * Date: 2/7/13
 * Time: 12:29 AM
 */
@Controller
public class VideoController {

    // todo implement service.getLastVideo
    @RequestMapping(value = "/")
    public ModelAndView getLastVideo() {
        ModelAndView mv = new ModelAndView("video");
        Film film = new Film();
        film.setRusName("Шерлок Холмс: Игра теней");
        film.setEngName("Sherlock Holmes: A Game of Shadows");
        film.setTimestamp(new Date());

        Trailer trailer1 = new Trailer();
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

        Trailer trailer2 = new Trailer();
        trailer2.setName("Обзор фильма - Шерлок Холмс: Игра теней");
        trailer2.setShortName("Обзор фильма");
        trailer2.setTimestamp(new Date());
        trailer2.setDescription("«Шерлок Холмс: Игра теней» («Sherlock Holmes: A Game of Shadows») " +
                "оправдает все ожидания! Подробности - в нашем обзоре.");
        trailer2.setUrl("http://www.youtube.com/embed/-O-_R5Y2DZA");

        trailer1.setFilm(film);
        trailer2.setFilm(film);

        List<Trailer> trailerList = new ArrayList<Trailer>();
        trailerList.add(trailer1);
        trailerList.add(trailer2);
        film.setTrailers(trailerList);
        mv.addObject("trailer", trailer1);

        return mv;
    }
}
