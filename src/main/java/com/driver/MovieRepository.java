package com.driver;

import java.util.* ;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class MovieRepository {

    private HashMap<String, Movie> movieMap = new HashMap<>() ;
    private HashMap<String, Director> directorMap = new HashMap<>() ;
    private HashMap<String, List<String>> directormovieMap = new HashMap<>() ;
    
    public void addMovie(Movie movie)
    {
        movieMap.put(movie.getName(), movie) ;
    }

    public void addDirector(Director director)
    {
        directorMap.put(director.getName(), director) ;
    }

    public void addMovieDirectorPair(String movie, String director)
    {
        List<String> pairlist = new ArrayList<>();

        if(directormovieMap.containsKey(director))
        pairlist = directormovieMap.get(director) ;

        if(!pairlist.contains(movie))
        pairlist.add(movie);

        directormovieMap.put(director, pairlist) ;
    }

    public Movie getMovieByName(String name)
    {
       return movieMap.get(name) ;
    }

    public Director getDirectorByName(String name)
    {
       return directorMap.get(name) ;
    }

    public List<String> getMovieByDirectorName(String director)
    {
        List<String> moviesList = new ArrayList<String>();

        if(directormovieMap.containsKey(director)) 
        moviesList = directormovieMap.get(director);

        return moviesList;
    }
 
    public List<String> findAllMovies()
    {
        List<String> movielist = new ArrayList<>();
        for(String m:movieMap.keySet())
        movielist.add(m) ;

        return movielist ;
    }

    public void deleteDirectorByName(String director)
    {
        List<String> movies = new ArrayList<>() ;
        if(directormovieMap.containsKey(director))
        {
            movies = directormovieMap.get(director) ;
            for(String m : movies)
            {
                if(movieMap.containsKey(m))
                movieMap.remove(m) ;
            }
            directorMap.remove(director) ;
        }
        if(directormovieMap.containsKey(director))
        directormovieMap.remove(director) ;
    }

    public void deleteAllDirectors()
    {
        for(String director: directormovieMap.keySet())
        {
            List<String> movielist = directormovieMap.get(director) ;
            for(String movie : movielist)
            {
                if(movieMap.containsKey(movie))
                movieMap.remove(movie) ;
            }
        }
        directorMap.clear() ;
        directormovieMap.clear();
    }

    
}
