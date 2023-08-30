package com.example.gestionsalledecinema.repository;
import com.example.gestionsalledecinema.model.Salles;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SallesLiaison implements Salles_DAO {
    private Connection connection;
    public SallesLiaison(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Salles salles) {
        String sql = "INSERT INTO Salles (id_salle, nom, capacite, type_projection) VALUES (?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, salles.getId_salle());
            statement.setString(2, salles.getNom());
            statement.setInt(3, salles.getCapacite());
            statement.setString(4, salles.getType_projection());

            statement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException("Erreur d'insert");
        }
    }

    @Override
    public List<Salles> findAll() throws SQLException {
        List<Salles> allSalles = new ArrayList<>();
        String sql = "SELECT * FROM Salles";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                allSalles.add(new Salles(
                        resultSet.getInt("id_salle"),
                        resultSet.getString("nom"),
                        resultSet.getInt("capacite"),
                        resultSet.getString("type_projection")

                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de recherche");
        }

        return allSalles;
    }

    @Override
    public List<Salles> findById(int id) throws SQLException {
        List<Salles> salles = new ArrayList<>();
        String sql = "SELECT * FROM Salles WHERE id_salle = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                salles.add(new Salles(
                        resultSet.getInt("id_salle"),
                        resultSet.getString("nom"),
                        resultSet.getInt("capacite"),
                        resultSet.getString("type_projection")
                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de selection");
        }

        return salles;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM Salles WHERE id_salle = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Salles salles) throws SQLException {
        String sql = "UPDATE Salles SET nom = ?, capacite = ?, type_projection = ? WHERE id_salle = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, salles.getNom());
            statement.setInt(2, salles.getCapacite());
            statement.setString(3, salles.getType_projection());
            statement.setInt(4, salles.getId_salle());
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
