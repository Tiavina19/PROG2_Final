package com.example.gestionsalledecinema.service;

import com.example.gestionsalledecinema.model.Salles;
import com.example.gestionsalledecinema.model.Seances;
import com.example.gestionsalledecinema.repository.Salles_DAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class SallesService {
    private Salles_DAO repository;

    public SallesService(Salles_DAO repository){
        this.repository = repository;
    }

    public void insertData(Salles salles) throws SQLException{
        repository.insert(salles);
    }

    public List<Salles> findAllSalles() throws SQLException {
        return repository.findAll();
    }

    public List<Salles> findAllSallesById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert ( Salles salles) throws SQLException{
        repository.insert(salles);
    }

    public void deleteSallesById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid (int id, Salles salles) throws SQLException{
        repository.update(id,salles);
    }
}
