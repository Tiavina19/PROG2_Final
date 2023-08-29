package com.example.gestionsalledecinema.service;
import com.example.gestionsalledecinema.model.Reservation;
import com.example.gestionsalledecinema.repository.Reservation_DAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class ReservationService {
    private Reservation_DAO repository;

    public ReservationService(Reservation_DAO repository){
        this.repository = repository;
    }

    public List<Reservation> findAllReservation() throws SQLException{
        return repository.findAll();
    }

    public List<Reservation> findAllReservationById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert ( Reservation reservation) throws SQLException{
        repository.insert(reservation);
    }

    public void deleteReservationById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid (int id, Reservation reservation) throws SQLException{
        repository.update(id,reservation);
    }
}
