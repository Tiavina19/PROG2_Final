package com.example.gestionsalledecinema.controller;

import com.example.gestionsalledecinema.model.Reservation;
import com.example.gestionsalledecinema.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class ReservationController {
    private ReservationService service;

    public ReservationController (ReservationService service){
        this.service = service ;
    }



    @GetMapping("/reservation")
    public List<Reservation> getReservation() throws SQLException {
        return service.findAllReservation();
    }
    @GetMapping("/reservation/{id}")
    public List<Reservation> getReservationById(@PathVariable int id) throws SQLException{
        return service.findAllReservationById(id);
    }

    @PostMapping("/reservation")
    public void insertReservation (@RequestBody Reservation reservation) throws SQLException{
        service.insert(reservation);
    }
    @DeleteMapping("/reservation/{id_reservation}")
    public void deleteReservationById(@PathVariable("id_reservation") int id_reservation) throws SQLException{
        service.deleteReservationById(id_reservation);
    }

    @PutMapping("/reservation/{id_reservation}")
    public void updateReservation(@PathVariable("id_reservation") int id_reservation, @RequestBody Reservation reservation) throws SQLException{
        service.updateByid(id_reservation, reservation);
    }
}
