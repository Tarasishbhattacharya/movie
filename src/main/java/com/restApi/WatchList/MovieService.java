package com.restApi.WatchList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {
    @Autowired
    MovieRepository movieRepo;
    public String Movieadd(Movie movie){
        movieRepo.addMovie(movie);
        return "New Movie added";
    }
    public String Directoradd(Director director){
        movieRepo.addDirector(director);
        return "New Director added";
    }

    public String addDirectorMovie(String movie,String director){
        movieRepo.addDirectorMoviePair(movie,director);
        return "New Director added";
    }
    public Movie getByName(String name){
         Movie movie=movieRepo.getName(name);
         return movie;
    }
    public Director findDirector(String name){
        Director director=movieRepo.finddirector(name);
        return director;
    }
    public List<String> findByDirector(String director){
        List<String> movieList=movieRepo.findMovie(director);
        return movieList;
    }

    public List<String> findAllMovie(){
        List<String> movieLists=movieRepo.findMovies();
        return movieLists;
    }
    public void deleteMovie(String name){
        movieRepo.deleteDirector(name);
    }
    public void deleteAllDirectors(){
        movieRepo.deleteDirectors();
    }

}
