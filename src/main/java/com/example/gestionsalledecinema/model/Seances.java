package com.example.gestionsalledecinema.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Seances {
    private int  id_seance;
    private int id_film;
    private int id_salle;
    private LocalDateTime date_heure;
    private float prix_billet;




}
