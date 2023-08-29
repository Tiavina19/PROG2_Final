package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Seances;

import java.sql.SQLException;
import java.util.List;

public interface Seances_DAO {
    void insert (Seances seances);
    List<Seances> findAll() throws SQLException;
    List<Seances> findById(int id) throws SQLException;
    void deleteId(int id) throws  SQLException;
    void update(int id, Seances seances) throws SQLException;
}
