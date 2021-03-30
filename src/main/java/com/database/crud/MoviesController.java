package com.database.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MoviesController {
    @Autowired
    MoviesRepository moviesRepository;

    @GetMapping("/showMovies")
    public List<Movie> showMovieList() {
        return moviesRepository.findAll();
    }

    @GetMapping("/showMovieById/{id}")
    public Optional<Movie> showMovieById(@PathVariable(value = "id") int id) {
           return moviesRepository.findById(id);
    }

    @PostMapping("/updateMovie/{id}")
    public Movie updateMovie(@PathVariable(value = "id") int id, @RequestBody Movie MovieDetalis) {
        Optional<Movie> movie = moviesRepository.findById(id);
        Movie newMovie = movie.get();
        newMovie.setName(MovieDetalis.getName());
        newMovie.setActor(MovieDetalis.getActor());
        newMovie.setActress(MovieDetalis.getActress());
        return moviesRepository.save(newMovie);
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie MovieDetalis) {
        Movie newMovie = new Movie(MovieDetalis.getId(), MovieDetalis.getName(), MovieDetalis.getActor(), MovieDetalis.getActress());
        newMovie.setName(MovieDetalis.getName());
        newMovie.setActor(MovieDetalis.getActor());
        newMovie.setActress(MovieDetalis.getActress());
        return moviesRepository.save(newMovie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable(value = "id") int id) {
        Optional<Movie> movie = moviesRepository.findById(id);
        Movie new_movie = movie.get();
        moviesRepository.delete(new_movie);
    }
}
