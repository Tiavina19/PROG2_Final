package com.example.gestionsalledecinema.controller;


import com.example.gestionsalledecinema.model.Film;
import com.example.gestionsalledecinema.service.FilmService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class FilmController {
    private FilmService service;

    public FilmController (FilmService service){
        this.service = service ;
    }



    @GetMapping("/film")
    public List<Film> getFilm() throws SQLException{
        return service.findAllFilm();
    }
    @GetMapping("/film/{id}")
    public List<Film> getFilmById(@PathVariable int id) throws SQLException{
        return service.findAllFilmById(id);
    }

    @PostMapping("/film")
    public void insertFilm (@RequestBody Film film) throws SQLException{
        service.insert(film);
    }
    @DeleteMapping("/film/{id_film}")
    public void deleteFilmById(@PathVariable("id_film") int id_film) throws SQLException{
        service.deleteFilmById(id_film);
    }

    @PutMapping("/film/{id_film}")
    public void updateFilm(@PathVariable("id_film") int id_film, @RequestBody Film film) throws SQLException{
        service.updateByid(id_film, film);
    }
}
