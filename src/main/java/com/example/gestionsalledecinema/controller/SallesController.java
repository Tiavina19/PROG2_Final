package com.example.gestionsalledecinema.controller;

import com.example.gestionsalledecinema.model.Salles;
import com.example.gestionsalledecinema.service.SallesService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SallesController {
    private SallesService service;

    public SallesController (SallesService service){
        this.service = service ;
    }


    @GetMapping("/salles")
    public List<Salles> getSalles() throws SQLException {
        return service.findAllSalles();
    }
    @GetMapping("/salles/{id}")
    public List<Salles> getSallesById(@PathVariable int id) throws SQLException{
        return service.findAllSallesById(id);
    }

    @PostMapping("/salles")
    public void insertSalles (@RequestBody Salles salles) throws SQLException{
        service.insert(salles);
    }
    @DeleteMapping("/salles/{id_salles}")
    public void deleteSallesById(@PathVariable("id_salles") int id_salles) throws SQLException{
        service.deleteSallesById(id_salles);
    }

    @PutMapping("/salles/{id_salles}")
    public void updateSalles(@PathVariable("id_salles") int id_salles, @RequestBody Salles salles) throws SQLException{
        service.updateByid(id_salles, salles);
    }

}

