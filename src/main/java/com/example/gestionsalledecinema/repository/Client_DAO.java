package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Clients;

import java.sql.SQLException;
import java.util.List;

public interface Client_DAO {
    void insert (Clients clients) throws SQLException;
    List<Clients> findAll() throws SQLException;
    List<Clients> findById(int id) throws SQLException;
    void deleteId(int id) throws  SQLException;
    void update(int id, Clients clients) throws SQLException;
}
