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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dzmitry
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
        Long id = filmDao.create(film);
        assertNotNull(id);
        Film readFilm = filmDao.read(id);
        assertEquals(film, readFilm);
        filmDao.delete(readFilm);
    }

    @Test
    public void test_create_delete() {
        Film film = new Film();
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
        Film film2 = new Film();
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

}
