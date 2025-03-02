package org.example;

import java.time.Year;
import java.util.List;

public class Movie extends Production {
    private String duration;
    private int releaseYear;

    public Movie(String title, List<String> directors, List<String> actors, List<Genre> genres, List<Rating> ratings, String description, String duration, int releaseYear) {
        super(title, directors, actors, genres, ratings, description);
        this.duration = duration;
        this.releaseYear = releaseYear;

    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    
    

    @Override
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Type: Movie");
        System.out.println("Directors: " + getDirectors());
        System.out.println("Actors: " + getActors());
        System.out.println("Genres: " + getGenres());
        System.out.println("Ratings: ");
        for (Rating rating : getRatings()) {
            System.out.println("\tSource: " + rating.getUsername());
            System.out.println("\tScore: " + rating.getScore());
            System.out.println("\tComment: " + rating.getComments());
            System.out.println("\n");
        }
        System.out.println("Plot: " + getDescription());
        System.out.println("Average Rating: " + getAverageRating());
        System.out.println("Duration: " + duration);
        System.out.println("Release Year: " + releaseYear);
    }
}
