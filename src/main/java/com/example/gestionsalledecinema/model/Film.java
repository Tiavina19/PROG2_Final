package com.example.gestionsalledecinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Film {
    private  Integer id_film;
    private String titre;
    private String realisateur;
    private int duree;
    private String genre;
}
