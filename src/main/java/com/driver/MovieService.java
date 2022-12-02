package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MovieService {

    @Autowired
    MovieRepository movierepository ;

    public void addMovie(Movie movie)
    {
        movierepository.addMovie(movie);
    }

    public void addDirector(Director director)
    {
        movierepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movie, String director)
    {
        movierepository.addMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String name)
    {
        return movierepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name)
    {
        return movierepository.getDirectorByName(name);
    }

    public List<String> getMovieByDirectorName(String director)
    {
        return movierepository.getMovieByDirectorName(director);
    }
 
    public List<String> findAllMovies()
    {
        return movierepository.findAllMovies();
    }

    public void deleteDirectorByName(String director)
    {
        movierepository.deleteDirectorByName(director) ;
    }

    public void deleteAllDirectors()
    {
        movierepository.deleteAllDirectors();
    }
    
}
