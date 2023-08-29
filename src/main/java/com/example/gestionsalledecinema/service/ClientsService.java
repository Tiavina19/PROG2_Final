package com.example.gestionsalledecinema.service;

import com.example.gestionsalledecinema.model.Clients;
import com.example.gestionsalledecinema.repository.Client_DAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ClientsService {
    private Client_DAO repository;

    public ClientsService(Client_DAO repository){
        this.repository = repository;
    }

    public List<Clients> findAllClients() throws SQLException{
        return repository.findAll();
    }

    public List<Clients> findAllClientsById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert ( Clients clients) throws SQLException{
        repository.insert(clients);
    }

    public void deleteClientsById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid (int id, Clients clients) throws SQLException{
        repository.update(id,clients);
    }
}
