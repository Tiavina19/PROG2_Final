package com.example.gestionsalledecinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Clients {
    private Integer id_clients;
    private String nom;
    private String prenom;
    private String email;
    private Integer numero_telephone;
}
