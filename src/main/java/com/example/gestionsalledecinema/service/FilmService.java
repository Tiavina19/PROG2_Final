package com.example.gestionsalledecinema.service;

import com.example.gestionsalledecinema.model.Film;
import com.example.gestionsalledecinema.repository.Film_DAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class FilmService {
    private Film_DAO repository;

    public FilmService(Film_DAO repository){
        this.repository = repository;
    }

    public List<Film> findAllFilm() throws SQLException{
        return repository.findAll();
    }

    public List<Film> findAllFilmById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert ( Film film) throws SQLException{
        repository.insert(film);
    }

    public void deleteFilmById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid (int id, Film film) throws SQLException{
        repository.update(id, film);
    }
}
