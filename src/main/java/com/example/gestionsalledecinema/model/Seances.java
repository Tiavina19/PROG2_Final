package com.example.gestionsalledecinema.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Seances {
    private Integer id_seance;
    private LocalDate date_heure;
    private float prix_billet;
}
