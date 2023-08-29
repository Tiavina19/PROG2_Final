package com.example.gestionsalledecinema.controller;

import com.example.gestionsalledecinema.model.Seances;
import com.example.gestionsalledecinema.service.SeancesService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SeancesController {
    private SeancesService service;

    public SeancesController (SeancesService service){
        this.service = service ;
    }



    @GetMapping("/seances")
    public List<Seances> getSeances() throws SQLException {
        return service.findAllSeances();
    }
    @GetMapping("/seances/{id}")
    public List<Seances> getSeancesById(@PathVariable int id) throws SQLException{
        return service.findAllSeancesById(id);
    }

    @PostMapping("/seances")
    public void insertSeances (@RequestBody Seances seances) throws SQLException{
        service.insert(seances);
    }
    @DeleteMapping("/seances/{id_seance}")
    public void deleteSeancesById(@PathVariable("id_seance") int id_seance) throws SQLException{
        service.deleteSeancesById(id_seance);
    }

    @PutMapping("/seances/{id_seance}")
    public void updateSeances(@PathVariable("id_seance") int id_seance, @RequestBody Seances seances) throws SQLException{
        service.updateByid(id_seance, seances);
    }

}
