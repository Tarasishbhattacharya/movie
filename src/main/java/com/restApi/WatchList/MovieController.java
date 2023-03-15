package com.restApi.WatchList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService  movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody()Movie movie){
        String ans=movieService.Movieadd(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody()Director director){
        String ans=movieService.Directoradd(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirector(@RequestParam("movie") String movieName,@RequestParam("director") String directorName){
        String ans=movieService.addDirectorMovie(movieName,directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/add_movie_by_name/{name}")
    public ResponseEntity<Movie> GetMovieByName(@PathVariable String name){
        Movie movie=movieService.getByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/add_director_by_name/{name}")
    public ResponseEntity<Director> GetDirectorByName(@PathVariable String name){
        Director director=movieService.findDirector(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/get_movielist_by_director/{director}")
    public ResponseEntity<List<String>> findMovieByDirector(@PathVariable String director){
        List<String> movie=movieService.findByDirector(director);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    @GetMapping("/find_all_movies")
    public ResponseEntity<List<String>> allMovie(){
        List<String>allMovielist=movieService.findAllMovie();
        return new ResponseEntity<>(allMovielist, HttpStatus.OK);
    }
    @DeleteMapping("/delete_movie_director")
    public ResponseEntity<String> deleteDirectorMovie(@RequestParam("name") String name){
        movieService.deleteMovie(name);
        return new ResponseEntity<>("director and movie deleted", HttpStatus.OK);
    }
    @DeleteMapping("/delete_all_director")
    public ResponseEntity<String> deleteDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("director and movie deleted", HttpStatus.OK);
    }



}
