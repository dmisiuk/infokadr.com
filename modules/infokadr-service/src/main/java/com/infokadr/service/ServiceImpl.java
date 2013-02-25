package com.infokadr.service;

import com.infokadr.dao.Dao;
import com.infokadr.domain.Film;
import com.infokadr.domain.Trailer;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * User: Dzmitry Khralovich
 * Date: 07.02.13
 * Time: 16:22
 */
public class ServiceImpl implements IService {


    private static Logger log = Logger.getLogger(ServiceImpl.class);

    private Dao<Film, Long> filmDao;
    private Dao<Trailer, Long> trailerDao;

    public ServiceImpl() {
    }

    public void setFilmDao(Dao<Film, Long> filmDao) {
        this.filmDao = filmDao;
    }

    public void setTrailerDao(Dao<Trailer, Long> trailerDao) {
        this.trailerDao = trailerDao;
    }

    /**
     * **************************************
     * <p/>
     * Film's CRUD
     * <p/>
     * ***************************************
     */

    @Override
    public Film createFilm(Film film) {
        try {
            filmDao.create(film);
        } catch (HibernateException he) {
            log.error(String.format("Failed to create product: %s.", film));
            log.error(String.format(he.getMessage()));
        }
        return film;
    }

    @Override
    public List<Film> getAllFilms() {
        List<Film> entities = null;
        try {
            entities = filmDao.readAll();
        } catch (HibernateException he) {
            log.error("Failed to get list of films.");
            log.error(String.format(he.getMessage()));
        }
        return entities;
    }

    @Override
    public Film getFilm(Long id) {
        Film entity = null;
        try {
            entity = filmDao.read(id);
        } catch (HibernateException he) {
            log.error(String.format("Failed to get film by id=%d.", id));
            log.error(String.format(he.getMessage()));
        }
        return entity;
    }

    @Override
    public void updateFilm(Film film) {
        try {
            filmDao.update(film);
        } catch (HibernateException he) {
            log.error(String.format("Failed to update film: %s.", film));
            log.error(String.format(he.getMessage()));
        }
    }

    @Override
    public void deleteFilm(Long id) {
        try {
            Film entity = filmDao.read(id);
            filmDao.delete(entity);
        } catch (HibernateException he) {
            log.error(String.format("Failed to delete film by id=%d.", id));
            log.error(String.format(he.getMessage()));
        }
    }

    @Override
    public void deleteFilm(Film film) {
        try {
            filmDao.delete(film);
        } catch (HibernateException he) {
            log.error(String.format("Failed to delete film: %s.", film));
            log.error(String.format(he.getMessage()));
        }
    }

    /**
     * **************************************
     * <p/>
     * Trailer's CRUD
     * <p/>
     * ***************************************
     */

    @Override
    public Trailer createTrailer(Trailer trailer, Long filmID) {
        try {
            Film entity = filmDao.read(filmID);
            //entity.getTrailers().add(trailer);
            trailer.setFilm(entity);
            trailerDao.create(trailer);
        } catch (HibernateException he) {
            log.error(String.format("Failed to add trailer to film: trailer=%s, filmID=%s.", trailer, filmID));
            log.error(String.format(he.getMessage()));
        }
        return trailer;
    }

    @Override
    public Trailer createTrailer(Trailer trailer, Film film) {
        try {
            //film.getTrailers().add(trailer);
            trailer.setFilm(film);
            trailerDao.create(trailer);
        } catch (HibernateException he) {
            log.error(String.format("Failed to add trailer to film: trailer=%s, film=%s.", trailer, film));
            log.error(String.format(he.getMessage()));
        }
        return trailer;
    }

    @Override
    public List<Trailer> getTrailer() {
        List<Trailer> entities = null;
        try {
            entities = trailerDao.readAll();
        } catch (HibernateException he) {
            log.error("Failed to get list of trailer.");
            log.error(String.format(he.getMessage()));
        }
        return entities;
    }

    @Override
    public Trailer getTrailer(Long id) {
        Trailer entity = null;
        try {
            entity = trailerDao.read(id);
        } catch (HibernateException he) {
            log.error(String.format("Failed to get trailer by id=%d.", id));
            log.error(String.format(he.getMessage()));
        }
        return entity;
    }

    @Override
    public Trailer getLastTrailer() {
        Trailer entity = null;
        try {
            entity = trailerDao.readLast();
        } catch (HibernateException he) {
            log.error(String.format("Failed to get last trailer"));
            log.error(String.format(he.getMessage()));
        }
        return entity;
    }

    @Override
    public Trailer getTrailer(Long filmId, Long trailerId) {
        Trailer entity = null;
        try {
            if (filmDao.read(filmId) != null) {
                entity = trailerDao.read(trailerId);
            }
        } catch (HibernateException he) {
            log.error(String.format("Failed to get film or trailer"));
            log.error(String.format(he.getMessage()));
        }
        return entity;
    }

    @Override
    public void updateTrailer(Trailer trailer) {
        try {
            trailerDao.update(trailer);
        } catch (HibernateException he) {
            log.error(String.format("Failed to update trailer: %s.", trailer));
            log.error(String.format(he.getMessage()));
        }
    }

    @Override
    public void deleteTrailer(Long id) {
        try {
            Trailer entity = trailerDao.read(id);
            trailerDao.delete(entity);
        } catch (HibernateException he) {
            log.error(String.format("Failed to delete trailer by id=%d.", id));
            log.error(String.format(he.getMessage()));
        }
    }

    @Override
    public void deleteTrailer(Trailer trailer) {
        try {
            trailerDao.delete(trailer);
        } catch (HibernateException he) {
            log.error(String.format("Failed to delete trailer: %s.", trailer));
            log.error(String.format(he.getMessage()));
        }
    }

    /**
     * **************************************
     * <p/>
     * Service operations
     * <p/>
     * ***************************************
     */

    @Override
    public List<Trailer> getAfter(Long id, Long amount) {
        List<Trailer> entities = null;
        String query="";
        try {
            query = "where id>" + id +" order by id ASC";
            entities = trailerDao.readQuery(query, amount);
        } catch (HibernateException he) {
            log.error("Failed to get list of trailer.");
            log.error(String.format(he.getMessage()));
        }
        return entities;
    }

    @Override
    public List<Trailer> getBefore(Long id, Long amount) {
        List<Trailer> entities = null;
        String query="";
        try {
            query = "where id<" + id +" order by id DESC";
            entities = trailerDao.readQuery(query, amount);
        } catch (HibernateException he) {
            log.error("Failed to get list of trailer.");
            log.error(String.format(he.getMessage()));
        }
        return entities;
    }

    @Override
    public List<Film> findFilmsByName(String text) {
        return null;
    }

}
