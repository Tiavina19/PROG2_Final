package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Film;
import com.example.gestionsalledecinema.model.Salles;
import com.example.gestionsalledecinema.model.Seances;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeancesLiaison implements Seances_DAO {
    private Connection connection;

    public SeancesLiaison(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void insert(Seances seances) throws SQLException {
        String sql = "INSERT INTO Seance (id_seance, id_film,id_salle,date_heure,prix_billet) VALUES (?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, seances.getId_seance());
        preparedStatement.setInt(2,seances.getId_film());
        preparedStatement.setInt(3,seances.getId_salle());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(seances.getDate_heure()));
        preparedStatement.setFloat(5,seances.getPrix_billet());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<Seances> findAll() throws SQLException {
        List<Seances> allSeances = new ArrayList<>();
        String sql = "SELECT * FROM Seances";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                allSeances.add(new Seances(
                        resultSet.getInt("id_seance"),
                        resultSet.getInt("id_film"),
                        resultSet.getInt("id_salle"),
                        resultSet.getTimestamp("date_heure").toLocalDateTime(),
                        resultSet.getFloat("prix_billet")
                ));
            }
        }
        return allSeances;
    }

    @Override
    public List<Seances> findById(int id) throws SQLException {
        List<Seances> seancesList = new ArrayList<>();
        String query = "SELECT * FROM Seances WHERE id_seance = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                seancesList.add(new Seances(
                        resultSet.getInt("id_seance"),
                        resultSet.getInt("id_film"),
                        resultSet.getInt("id_salle"),
                        resultSet.getTimestamp("date_heure").toLocalDateTime(),
                        resultSet.getFloat("prix_billet")
                ));
            }
        }
        return seancesList;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM Seances WHERE id_seance = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate()
            ;
        }

    }

    @Override
    public void update(int id, Seances seances) throws SQLException {
     String sql = "UPDATE Seances SET id_seance = ?, id_film = ? id_salle = ?, date_heure = ?, prix_billet = ? WHERE id_seance = ?";
     try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
         preparedStatement.setInt(1,seances.getId_seance());
         preparedStatement.setInt(2,seances.getId_film());
         preparedStatement.setInt(3,seances.getId_salle());
         preparedStatement.setTimestamp(4, Timestamp.valueOf(seances.getDate_heure()));
         preparedStatement.setFloat(5,seances.getPrix_billet());
     }
    }
}
