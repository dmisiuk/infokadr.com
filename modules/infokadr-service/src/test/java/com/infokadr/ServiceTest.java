package com.infokadr;

import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import com.infokadr.service.IService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 10.02.13
 * Time: 18:10
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/service-test.xml"})
public class ServiceTest extends Assert {

    @Resource
    private IService service;

    @Test
    public void test_service() {
        assertNotNull(service);
    }

    @Test
    public void test_create_get_Film() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation") ;
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        assertEquals(film, readFilm);
        service.deleteFilm(readFilm);
    }

    @Test
    public void test_create_get_all_Films() {
        Film film1 = new Film();
        film1.setRusName("G.I. Joe: Бросок кобры 2");
        film1.setEngName("G.I. Joe: Retaliation");
        Film film2 = new Film();
        film2.setRusName("Железный человек 3");
        film2.setEngName("Iron Man 3");
        Film filmCreate1 = service.createFilm(film1);
        Film filmCreate2 = service.createFilm(film2);
        List<Film> list = service.getAllFilms();
        assertNotNull(list);
        assertEquals(2, list.size());
        for (Film film : list) {
            service.deleteFilm(film);
        }
    }

    @Test
    public void test_create_update_Film() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        assertNotNull(readFilm);
        readFilm.setEngName("First film");
        service.updateFilm(readFilm);
        Film updateFilm = service.getFilm(filmCreate.getId());
        assertEquals(readFilm, updateFilm);
        assertEquals("First film", updateFilm.getEngName());
        service.deleteFilm(updateFilm);
    }

    @Test
    public void test_create_delete_Film() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        service.deleteFilm(readFilm);
        Film deletedFilm = service.getFilm(filmCreate.getId());
        assertNull(deletedFilm);
    }

    @Test
    public void test_create_delete_byID_Film() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        service.deleteFilm(readFilm.getId());
        Film deletedFilm = service.getFilm(filmCreate.getId());
        assertNull(deletedFilm);
    }

    @Test
    public void test_create_byFilm_get_Trailer() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Trailer trailer = new Trailer();
        trailer.setName("Международный трейлер №2 (дублированный)");
        trailer.setShortName("Трейлер №2");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate = service.createTrailer(trailer, filmCreate);
        assertNotNull(trailerCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        Trailer readTrailer = service.getTrailer(trailerCreate.getId());
        assertEquals(filmCreate, readFilm);
        assertEquals(readFilm.getTrailers().get(0), readTrailer);
        assertEquals(readFilm, readTrailer.getFilm());
        service.deleteTrailer(readTrailer);
        Film readFilmAfter = service.getFilm(readFilm.getId());
        assertNotNull(readFilmAfter);
        service.deleteFilm(readFilmAfter);
    }

    @Test
    public void test_create_byID_get_Trailer() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Trailer trailer = new Trailer();
        trailer.setName("Международный трейлер №2 (дублированный)");
        trailer.setShortName("Трейлер №2");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);

        Trailer trailerCreate = service.createTrailer(trailer, filmCreate.getId());
        assertNotNull(trailerCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        Trailer readTrailer = service.getTrailer(trailerCreate.getId());
        assertEquals(filmCreate, readFilm);
        assertEquals(readFilm.getTrailers().get(0), readTrailer);
        assertEquals(readFilm, readTrailer.getFilm());
        service.deleteTrailer(readTrailer);
        Film readFilmAfter = service.getFilm(readFilm.getId());
        assertNotNull(readFilmAfter);
        service.deleteFilm(readFilmAfter);
    }

    @Test
    public void test_getLast_Trailer() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.HOUR, 2);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 30);

        Trailer trailer1 = new Trailer();
        trailer1.setName("Международный трейлер №2 (дублированный)");
        trailer1.setShortName("Трейлер №2");
        trailer1.setAddedDate(calendar.getTime());
        calendar.set(Calendar.SECOND, 35);
        Trailer trailer2 = new Trailer();
        trailer2.setName("Международный трейлер №3 (дублированный)");
        trailer2.setShortName("Трейлер №3");
        trailer2.setAddedDate(calendar.getTime());

        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate1 = service.createTrailer(trailer1, filmCreate);
        assertNotNull(trailerCreate1);
        Trailer trailerCreate2 = service.createTrailer(trailer2, filmCreate);
        assertNotNull(trailerCreate2);

        Trailer readLastTrailer = service.getLastTrailer();
        assertEquals(readLastTrailer.getId(), trailerCreate2.getId());

        Film readFilmAfter = service.getFilm(filmCreate.getId());
        assertNotNull(readFilmAfter);
        service.deleteFilm(readFilmAfter);
    }

    @Test
    public void test_get_FilmId_TrailerID_Trailer() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Trailer trailer = new Trailer();
        trailer.setName("Международный трейлер №2 (дублированный)");
        trailer.setShortName("Трейлер №2");

        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate = service.createTrailer(trailer, filmCreate);
        assertNotNull(trailerCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        Trailer readTrailer = service.getTrailer(readFilm.getId(),trailerCreate.getId());
        assertNotNull(readTrailer);
        assertEquals(trailerCreate, readTrailer);
        service.deleteTrailer(readTrailer);
        Film readFilmAfter = service.getFilm(readFilm.getId());
        assertNotNull(readFilmAfter);
        service.deleteFilm(readFilmAfter);

        Trailer trailer1 = new Trailer();
        trailer1.setName("Международный трейлер №3 (дублированный)");
        trailer1.setShortName("Трейлер №3");
        Trailer trailerCreate1 = service.createTrailer(trailer1, (Film) null);
        assertNotNull(trailerCreate1);
        Trailer readTrailer1 = service.getTrailer(1001l,trailerCreate1.getId());
        assertNull(readTrailer1);
        service.deleteTrailer(trailerCreate1);
    }

    @Test
    public void test_create_update_Trailer() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Trailer trailer = new Trailer();
        trailer.setName("Международный трейлер №2 (дублированный)");
        trailer.setShortName("Трейлер №2");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate = service.createTrailer(trailer, filmCreate.getId());
        assertNotNull(trailerCreate);
        Trailer readTrailer = service.getTrailer(trailerCreate.getId());
        readTrailer.setName("Trailer Test");
        service.updateTrailer(readTrailer);
        Trailer updateTrailer = service.getTrailer(trailerCreate.getId());
        assertEquals("Trailer Test", updateTrailer.getName());
        service.deleteTrailer(readTrailer);
        Film readFilmAfter = service.getFilm(filmCreate.getId());
        assertNotNull(readFilmAfter);
        service.deleteFilm(readFilmAfter);
    }

    @Test
    public void test_create_delete_Trailer() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Trailer trailer = new Trailer();
        trailer.setName("Международный трейлер №2 (дублированный)");
        trailer.setShortName("Трейлер №2");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate = service.createTrailer(trailer, filmCreate);
        assertNotNull(trailerCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        Trailer readTrailer = service.getTrailer(trailerCreate.getId());
        service.deleteTrailer(readTrailer);
        Film readFilmAfter = service.getFilm(readFilm.getId());
        assertNotNull(readFilmAfter);
        assertEquals(0, readFilmAfter.getTrailers().size());
        service.deleteFilm(readFilmAfter);
    }

    @Test
    public void testCreateDeleteTrailerById() {
        Film film = new Film();
        film.setRusName("G.I. Joe: Бросок кобры 2");
        film.setEngName("G.I. Joe: Retaliation");
        Trailer trailer = new Trailer();
        trailer.setName("Международный трейлер №2 (дублированный)");
        trailer.setShortName("Трейлер №2");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate = service.createTrailer(trailer, filmCreate);
        assertNotNull(trailerCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        Trailer readTrailer = service.getTrailer(trailerCreate.getId());
        service.deleteTrailer(readTrailer.getId());
        assertNull(service.getTrailer(readTrailer.getId()));
        Film readFilmAfter = service.getFilm(readFilm.getId());
        assertNotNull(readFilmAfter);
        assertEquals(0, readFilmAfter.getTrailers().size());
        service.deleteFilm(readFilmAfter);
    }

    @Test
    public void test_find_Film() {
        Film film = new Film();
        film.setRusName("Паркер");
        film.setEngName("Parker");
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        List<Film> list = service.findFilmsByName("Par");
        assertEquals(1, list.size());
        Film readFilm = service.getFilm(filmCreate.getId());
        service.deleteFilm(readFilm);
        Film deletedFilm = service.getFilm(filmCreate.getId());
        assertNull(deletedFilm);
    }

    /*
    @Test
    public void test_create_delete_byID_Trailer() {
        Film film = new Film();
        Trailer trailer = new Trailer();
        Film filmCreate = service.createFilm(film);
        assertNotNull(filmCreate);
        Trailer trailerCreate = service.createTrailer(trailer, filmCreate);
        assertNotNull(trailerCreate);
        Film readFilm = service.getFilm(filmCreate.getId());
        Trailer readTrailer = service.getTrailer(trailerCreate.getId());
        service.deleteTrailer(readTrailer.getId());
        Film readFilmAfter = service.getFilm(readFilm.getId());
        assertNotNull(readFilmAfter);
        assertEquals(0, readFilmAfter.getTrailers().size());
        service.deleteFilm(readFilmAfter);
    }
    */
}
