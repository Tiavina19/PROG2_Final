package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Seances;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SeancesLiaison implements Seances_DAO {
    private Connection connection;
    public SeancesLiaison(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Seances seances) {
        String sql = "INSERT INTO Seances (id_seance, date_heure,prix_billet) VALUES (?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, seances.getId_seance());
            statement.setDate(2, Date.valueOf(seances.getDate_heure()));
            statement.setFloat(3, seances.getPrix_billet());

            statement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException("Erreur d'insert");
        }
    }

    @Override
    public List<Seances> findAll() throws SQLException {
        List<Seances> allSeances = new ArrayList<>();
        String sql = "SELECT * FROM Seances";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                allSeances.add(new Seances(
                        resultSet.getInt("id_sseance"),
                        resultSet.getDate("date_heure").toLocalDate(),
                        resultSet.getFloat("prix_billet")

                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de recherche");
        }

        return allSeances;
    }

    @Override
    public List<Seances> findById(int id) throws SQLException {
        List<Seances> seances = new ArrayList<>();
        String sql = "SELECT * FROM Seances WHERE id_seance = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                seances.add(new Seances(
                        resultSet.getInt("id_seance"),
                        resultSet.getDate("date_heure").toLocalDate(),
                        resultSet.getFloat("prix_billet")
                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de selection");
        }

        return seances;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM Seances WHERE id_seance= ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Seances seances) throws SQLException {
        String sql = "UPDATE Seances SET date_heure = ?, prix_billets = ?, WHERE id_seance = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setDate(1, Date.valueOf(seances.getDate_heure()));
            statement.setFloat(2, seances.getPrix_billet());
            statement.setInt(3, seances.getId_seance());
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
