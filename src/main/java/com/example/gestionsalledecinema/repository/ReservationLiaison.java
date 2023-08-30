package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ReservationLiaison implements Reservation_DAO{
    private Connection connection;
    public ReservationLiaison(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Reservation reservation) {
        String sql = "INSERT INTO Reservation (id_reservation, nombre_place) VALUES (?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, reservation.getId_reservation());
            statement.setInt(2, reservation.getNombre_places());
            statement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException("Erreur d'insert");
        }
    }

    @Override
    public List<Reservation> findAll() throws SQLException {
        List<Reservation> allReservation = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                allReservation.add(new Reservation(
                        resultSet.getInt("id_reservation"),
                        resultSet.getInt("nombre_places")

                ));
            }

        }

        return allReservation;
    }

    @Override
    public List<Reservation> findById(int id) throws SQLException {
        List<Reservation> reservation = new ArrayList<>();
        String sql = "SELECT * FROM Reservation WHERE id_reservation = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                reservation.add(new Reservation(
                        resultSet.getInt("id_reservation"),
                        resultSet.getInt("nombre_place")

                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de selection");
        }

        return reservation;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM Reservation WHERE id_reservation = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Reservation reservation) throws SQLException {
        String sql = "UPDATE Reservation  SET nombre_place = ?, WHERE id_reservation = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,reservation.getNombre_places());
            statement.setInt(2,reservation.getId_reservation ());
            statement.executeUpdate();

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
