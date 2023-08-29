package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Clients;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientLiaison implements Client_DAO {

    private Connection connection;

    public ClientLiaison(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Clients clients) {
        String sql = "INSERT INTO Clients (id_clients, nom, prenom, email, numero_telephone) VALUES (?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, clients.getId_clients());
            statement.setString(2, clients.getNom());
            statement.setString(3, clients.getPrenom());
            statement.setString(4, clients.getEmail());
            statement.setInt(5, clients.getNumero_telephone());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erreur d'insert");
        }

    }

    @Override
    public List<Clients> findAll() throws SQLException {
        List<Clients> allClients = new ArrayList<>();
        String sql = "SELECT * FROM Clients";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                allClients.add(new Clients(
                        resultSet.getInt("id_clients"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getInt("numero_telephone")
                ));
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erreur de recherche");
        }

        return allClients;
    }

    @Override
    public List<Clients> findById(int id) throws SQLException {
        List<Clients> clients = new ArrayList<>();
        String sql = "SELECT * FROM Clients WHERE id_clients = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                clients.add(new Clients(
                        resultSet.getInt("id_clients"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getInt("numero_telephone")

                ));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Oh");
        }

        return clients;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM Clients WHERE id_clients = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Clients clients) throws SQLException {
        String sql = "UPDATE Clients SET nom = ?, prenom = ?, email = ?, numero_telephone = ? WHERE id_clients = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clients.getNom());
            statement.setString(2, clients.getPrenom());
            statement.setString(3, clients.getEmail());
            statement.setInt(4, clients.getNumero_telephone());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }




}
