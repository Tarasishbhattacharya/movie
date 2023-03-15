package com.restApi.WatchList;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> moviemap;
    HashMap<String,Director> directormap;
    HashMap<String, List<String>>DirectorMoviePair;

    public MovieRepository() {
        this.moviemap = new HashMap<>();
        this.directormap = new HashMap<>();
        this.DirectorMoviePair = new HashMap<>();
    }

    public void addMovie(Movie movie){
        moviemap.put(movie.getName(),movie);
    }

    public void addDirector(Director director){
        directormap.put(director.getName(),director);
    }
    public void addDirectorMoviePair(String movie,String director){
           if(moviemap.containsKey(movie) && directormap.containsKey(director)){
               if(DirectorMoviePair.containsKey(director)){
                   DirectorMoviePair.get(director).add(movie);
               }else{
                   List<String>movieList=new ArrayList<>();
                   movieList.add(movie);
                   DirectorMoviePair.put(director,movieList);
               }
           }
    }

    public Movie getName(String name){
        return moviemap.get(name);
    }
    public Director finddirector(String name){
        return directormap.get(name);
    }
    public List<String> findMovie(String director){
        List<String> movieList=new ArrayList<>();
        if(DirectorMoviePair.containsKey(director)){
            movieList=DirectorMoviePair.get(director);
        }
        return movieList;
    }
    public List<String> findMovies(){
        List<String> movielist=new ArrayList<>();
        for(String movie:moviemap.keySet()){
            movielist.add(movie);
        }
        return movielist;
    }
    public void deleteDirector(String name){
        List<String>movies=new ArrayList<String>();
        if(DirectorMoviePair.containsKey(name)){
            movies=DirectorMoviePair.get(name);
        }
        for(String movie:movies){
            moviemap.remove(movie);
        }
        DirectorMoviePair.remove(name);
        directormap.remove(name);
    }
    public void deleteDirectors(){
        for(String director:DirectorMoviePair.keySet()){
            List<String>movies=DirectorMoviePair.get(director);
            for(String movie:movies){
                moviemap.remove(movie);
            }
            DirectorMoviePair.remove(director);
            directormap.remove(director);
        }
    }

}
