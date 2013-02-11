package com.infokadr;

import com.infokadr.dao.Dao;
import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 29.01.13
 * Time: 22:43
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/dao-test.xml"})
public class DaoTest extends Assert {

    @Resource
    private Dao<Film, Long> filmDao;

    @Resource
    private Dao<Trailer, Long> trailerDao;

    @Test
    public void test() {
        assertNotNull(filmDao);
        assertNotNull(trailerDao);
    }

    @Test
    public void create() {
        Film film = new Film();
        film.setRusName("sdlfs");
        film.setEngName("ads");
        Long id = filmDao.create(film);
        assertNotNull(id);
        Film readFilm = filmDao.read(id);
        assertEquals(film, readFilm);
        filmDao.delete(readFilm);
    }

    @Test
    public void test_create_delete() {
        Film film = new Film();
        film.setRusName("sdlfs");
        film.setEngName("ads");
        Long id = filmDao.create(film);
        assertNotNull(id);
        Film readFilm = filmDao.read(id);
        assertNotNull(readFilm);
        filmDao.delete(readFilm);
        Film deletedFilm = filmDao.read(id);
        assertNull(deletedFilm);
    }

    @Test
    public void test_create_update() {
        Film film = new Film();
        film.setRusName("sdlfs");
        film.setEngName("ads");
        Long id = filmDao.create(film);
        assertNotNull(id);
        Film readFilm = filmDao.read(id);
        assertNotNull(readFilm);
        readFilm.setRusName("миша");
        filmDao.update(readFilm);
        Film updatedFilm = filmDao.read(id);
        assertEquals(readFilm, updatedFilm);
        assertEquals("миша", updatedFilm.getRusName());
        filmDao.delete(updatedFilm);
    }

    @Test
    public void test_create_get_all() {
        Film film1 = new Film();
        film1.setRusName("sdlfs");
        film1.setEngName("ads");
        Film film2 = new Film();
        film2.setRusName("sdlfs");
        film2.setEngName("ads");
        filmDao.create(film1);
        filmDao.create(film2);
        List<Film> list = filmDao.readAll();
        assertNotNull(list);
        assertEquals(2, list.size());
        filmDao.delete(film1);
        filmDao.delete(film2);
    }

    @Test
    public void create_trailer() {
        Trailer trailer = new Trailer();
        Long id = trailerDao.create(trailer);
        assertNotNull(id);
        Trailer readTrailer = trailerDao.read(id);
        assertEquals(trailer, readTrailer);
        trailerDao.delete(readTrailer);
    }

    @Test
    public void test_trailer_create_delete() {
        Trailer trailer = new Trailer();
        Long id = trailerDao.create(trailer);
        assertNotNull(id);
        Trailer readTrailer = trailerDao.read(id);
        assertNotNull(readTrailer);
        trailerDao.delete(readTrailer);
        Trailer deletedTrailer = trailerDao.read(id);
        assertNull(deletedTrailer);
    }

    @Test
    public void test_trailer_create_update() {
        Trailer trailer = new Trailer();
        Long id = trailerDao.create(trailer);
        assertNotNull(id);
        Trailer readTrailer = trailerDao.read(id);
        assertNotNull(readTrailer);
        readTrailer.setName("имя трейлера");
        trailerDao.update(readTrailer);
        Trailer updatedTrailer = trailerDao.read(id);
        assertEquals(readTrailer, updatedTrailer);
        assertEquals("имя трейлера", updatedTrailer.getName());
        trailerDao.delete(updatedTrailer);
    }

    @Test
    public void test_trailer_create_get_all() {
        Trailer trailer1 = new Trailer();
        Trailer trailer2 = new Trailer();
        trailerDao.create(trailer1);
        trailerDao.create(trailer2);
        List<Trailer> list = trailerDao.readAll();
        assertNotNull(list);
        assertEquals(2, list.size());
        trailerDao.delete(trailer1);
        trailerDao.delete(trailer2);
    }

    @Test
    public void test_film_trailer_cascade_create_get() {
        Film film = new Film();
        film.setRusName("sdlfs");
        film.setEngName("ads");
        Trailer trailer1 = new Trailer();
        Trailer trailer2 = new Trailer();
        Long id = filmDao.create(film);
        trailer1.setFilm(film);
        trailer2.setFilm(film);
        trailerDao.create(trailer1);
        trailerDao.create(trailer2);
        Film readFilm = filmDao.read(id);
        assertNotNull(readFilm);
        assertEquals(2, readFilm.getTrailers().size());
        trailerDao.delete(trailer1);
        trailerDao.delete(trailer2);
        filmDao.delete(film);
    }

    @Test
    public void test_film_trailer_cascade_delete() {
        Film film = new Film();
        film.setRusName("sdlfs");
        film.setEngName("ads");
        Trailer trailer1 = new Trailer();
        Trailer trailer2 = new Trailer();
        Long id = filmDao.create(film);
        trailer1.setFilm(film);
        trailer2.setFilm(film);
        trailerDao.create(trailer1);
        trailerDao.create(trailer2);
        Film readFilm = filmDao.read(id);
        assertNotNull(readFilm);
        assertEquals(2, readFilm.getTrailers().size());
        filmDao.delete(readFilm);
        List<Trailer> list = trailerDao.readAll();
        assertNotNull(list);
        assertEquals(0, list.size());
    }

    @Test
    public void test_query() {
        Film film1 = new Film();
        film1.setRusName("sdlfs");

        film1.setEngName("First");
        Film film2 = new Film();
        film2.setEngName("Second");
        film2.setRusName("sdlfs");
        Film film3 = new Film();
        film3.setEngName("Third");
        film3.setRusName("sdlfs");

        Long id1 = filmDao.create(film1);
        Long id2 = filmDao.create(film2);
        Long id3 = filmDao.create(film3);

        String query = "from Film where EngName='Second' order by ID";
        List<Film> list = filmDao.readQuery(query);
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals(film2, list.get(0));

        filmDao.delete(film1);
        filmDao.delete(film2);
        filmDao.delete(film3);
    }


    @Test
    public void test_last() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        calendar.set(Calendar.YEAR, 2013);
        calendar.set(Calendar.HOUR, 2);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 30);

        Film film1 = new Film();
        film1.setEngName("asd");
        film1.setRusName("dlds");
        film1.setTimestamp(calendar.getTime());
        Film film2 = new Film();
        film2.setEngName("asd");
        film2.setRusName("dlds");
        calendar.set(Calendar.MINUTE, 17);
        film2.setTimestamp(calendar.getTime());
        Film film3 = new Film();
        film3.setEngName("asd");
        film3.setRusName("dlds");
        calendar.set(Calendar.MINUTE, 16);
        film3.setTimestamp(calendar.getTime());

        Long id1 = filmDao.create(film1);
        Long id2 = filmDao.create(film2);
        Long id3 = filmDao.create(film3);

        Film entity = filmDao.readLast();

        assertNotNull(entity);
        assertEquals(film2, entity);

        filmDao.delete(film1);
        filmDao.delete(film2);
        filmDao.delete(film3);

    }

}
