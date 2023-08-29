package com.example.gestionsalledecinema.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Reservation {
    private int id_reservation;
    private int nombre_place;

}
