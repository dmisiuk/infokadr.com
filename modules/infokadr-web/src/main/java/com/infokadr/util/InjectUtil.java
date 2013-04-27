package com.infokadr.util;

import com.infokadr.domain.Film;

/**
 * User: dzmitry.misiuk
 * Date: 4/27/13
 * Time: 8:52 PM
 */
public class InjectUtil {

    public static final String RUS_NAME = "#rus_name";
    public static final String ENG_NAME = "#eng_name";

    public static String injectFilmName(String trailerName, Film film) {
        String rusName = film.getRusName();
        String engName = film.getEngName();

        String newTrailerName = trailerName
                .replaceAll(RUS_NAME, rusName)
                .replaceAll(ENG_NAME, engName);
        return newTrailerName;
    }
}
