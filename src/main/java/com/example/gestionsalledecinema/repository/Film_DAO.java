package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Film;

import java.sql.SQLException;
import java.util.List;

public interface Film_DAO {
    void insert (Film film);
    List<Film> findAll() throws SQLException;
    List<Film> findById(int id) throws SQLException;
    void deleteId(int id) throws  SQLException;
    void update(int id, Film film) throws SQLException;
}
