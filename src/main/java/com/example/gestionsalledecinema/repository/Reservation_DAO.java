package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface Reservation_DAO {
    void insert (Reservation reservation);
    List<Reservation> findAll() throws SQLException;
    List<Reservation> findById(int id) throws SQLException;
    void deleteId(int id) throws  SQLException;
    void update(int id, Reservation reservation) throws SQLException;
}
