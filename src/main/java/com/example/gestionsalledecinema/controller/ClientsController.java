package com.example.gestionsalledecinema.controller;


import com.example.gestionsalledecinema.model.Clients;
import com.example.gestionsalledecinema.service.ClientsService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ClientsController {
    private ClientsService service;

    public ClientsController (ClientsService service){
        this.service = service ;
    }



    @GetMapping("/clients")
    public List<Clients> getClients() throws SQLException{
        return service.findAllClients();
    }
    @GetMapping("/clients/{id}")
    public List<Clients> getClientsById(@PathVariable int id) throws SQLException{
        return service.findAllClientsById(id);
    }

    @PostMapping("/clients")
    public void insertClients (@RequestBody Clients clients) throws SQLException{
        service.insert(clients);
    }
    @DeleteMapping("/clients/{id_clients}")
    public void deleteClientsById(@PathVariable("id_clients") int id_clients) throws SQLException{
        service.deleteClientsById(id_clients);
    }

    @PutMapping("/clients/{id_clients}")
    public void updateClients(@PathVariable("id_clients") int id_clients, @RequestBody Clients clients) throws SQLException{
        service.updateByid(id_clients, clients);
    }



}
