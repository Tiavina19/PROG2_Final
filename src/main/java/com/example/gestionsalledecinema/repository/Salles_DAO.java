package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Salles;

import java.sql.SQLException;
import java.util.List;

public interface Salles_DAO {
    void insert (Salles salles);
    List<Salles> findAll() throws SQLException;
    List<Salles> findById(int id) throws SQLException;
    void deleteId(int id) throws  SQLException;
    void update(int id, Salles salles) throws SQLException;
}
