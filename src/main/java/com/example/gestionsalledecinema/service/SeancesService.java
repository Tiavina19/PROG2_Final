package com.example.gestionsalledecinema.service;
import com.example.gestionsalledecinema.model.Seances;
import com.example.gestionsalledecinema.repository.Seances_DAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class SeancesService {
    private Seances_DAO repository;

    public SeancesService(Seances_DAO repository){
        this.repository = repository;
    }

    public List<Seances> findAllSeances() throws SQLException{
        return repository.findAll();
    }

    public List<Seances> findAllSeancesById(int id) throws SQLException{
        return repository.findById(id);
    }

    public void insert ( Seances seances) throws SQLException{
        repository.insert(seances);
    }

    public void deleteSeancesById(int id) throws SQLException{
        repository.deleteId(id);
    }

    public void updateByid (int id, Seances seances) throws SQLException{
        repository.update(id,seances);
    }
}
