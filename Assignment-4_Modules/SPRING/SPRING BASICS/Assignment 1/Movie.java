package com.example.model;

public class Movie {
    private String movieId;
    private String movieName;
    private String movieActor;

    // Getters and Setters
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMovieActor() {
        return movieActor;
    }
    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    // Display details
    public void displayMovieDetails() {
        System.out.println("Movie ID   : " + movieId);
        System.out.println("Movie Name : " + movieName);
        System.out.println("Movie Actor: " + movieActor);
    }
}
