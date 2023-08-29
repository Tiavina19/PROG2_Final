package com.example.gestionsalledecinema.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Salles {
    private Integer id_salle;
    private String nom;
    private int capacite;
    private String type_projection;
}
