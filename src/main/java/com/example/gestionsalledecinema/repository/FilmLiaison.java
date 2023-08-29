package com.example.gestionsalledecinema.repository;

import com.example.gestionsalledecinema.model.Film;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class FilmLiaison implements Film_DAO{

    private Connection connection;
    public FilmLiaison(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(Film film) {
        String sql = "INSERT INTO Film (id_film, titre, realisateur, duree, genre) VALUES (?,?,?,?,?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, film.getId_film());
            statement.setString(2,film.getTitre());
            statement.setString(3, film.getRealisateur ());
            statement.setInt(4, film.getDuree());
            statement.setString(5, film.getGenre());
            statement.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException("Erreur d'insert");
        }
    }

    @Override
    public List<Film> findAll() throws SQLException {
        List<Film> allFilm = new ArrayList<>();
        String sql = "SELECT * FROM Film";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                allFilm.add(new Film(
                        resultSet.getInt("id_film"),
                        resultSet.getString("titre"),
                        resultSet.getString("realisateur"),
                        resultSet.getInt("duree"),
                        resultSet.getString("genre")
                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de recherche");
        }

        return allFilm;
    }

    @Override
    public List<Film> findById(int id) throws SQLException {
        List<Film> film = new ArrayList<>();
        String sql = "SELECT * FROM Film WHERE id_film = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                film.add(new Film(
                        resultSet.getInt("id_film"),
                        resultSet.getString("titre"),
                        resultSet.getString("realisateur"),
                        resultSet.getInt("duree"),
                        resultSet.getString("genre")
                ));
            }

        }catch (SQLException ex){
            throw new RuntimeException("Erreur de selection");
        }

        return film;
    }

    @Override
    public void deleteId(int id) throws SQLException {
        String sql = "DELETE FROM Film WHERE id_film = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(int id, Film film) throws SQLException {
        String sql = "UPDATE Film SET titre = ?, realisateur = ?, duree = ?, genre = ?, WHERE id_film = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,film.getTitre());
            statement.setString(2, film.getRealisateur ());
            statement.setInt(3, film.getDuree());
            statement.setString(4, film.getGenre());
            statement.setInt(5, film.getId_film());
            statement.executeUpdate();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
