package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    MovieService movieservice ;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieservice.addMovie(movie);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED) ;
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieservice.addDirector(director);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED) ;
    }

    @PutMapping ("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie, @RequestParam String director)
    {
        movieservice.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("SUCCESS",HttpStatus.CREATED) ;
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        return new ResponseEntity<>(movieservice.getMovieByName(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        return new ResponseEntity<>(movieservice.getDirectorByName(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
    {
        return new ResponseEntity<>(movieservice.getMovieByDirectorName(director), HttpStatus.ACCEPTED);
    }
 
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        return new ResponseEntity<>(movieservice.findAllMovies(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
    {
        movieservice.deleteDirectorByName(director) ;
        return new ResponseEntity<>("Director record deleted successfully", HttpStatus.ACCEPTED) ;
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieservice.deleteAllDirectors();
        return new ResponseEntity<>("Director record deleted successfully", HttpStatus.ACCEPTED) ;
    }


    
}
