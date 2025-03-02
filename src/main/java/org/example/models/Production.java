package org.example;

import java.util.List;

public abstract class Production implements Comparable<Production>{
    private String title;
    private List<String> directors;
    private List<String> actors;
    private List<Genre> genres;
    private List<Rating> ratings;
    private String description;

    private double averageRating;

    public Production(String title, List<String> directors, List<String> actors, List<Genre> genres, List<Rating> ratings, String description){
        this.title = title;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
        this.ratings = ratings;
        this.description = description;
        this.averageRating = getAverageRating();
    }

    public String getTitle(){
        return title;
    }

    public List<String> getDirectors(){
        return directors;
    }

    public List<String> getActors(){
        return actors;
    }

    public List<Genre> getGenres(){
        return genres;
    }

    public List<Rating> getRatings(){
        return ratings;
    }

    public String getDescription(){
        return description;
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getScore();
        }
        return sum / ratings.size();
    }
    
    @Override
    public int compareTo(Production other){
        return title.compareTo(other.getTitle());
    }

    public abstract void displayInfo();

    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = getAverageRating();
    }

    public void setTitle(String optionEditTitle) {
        this.title = optionEditTitle;
    }

    public void setDirectors(List<String> optionEditDirectors) {
        this.directors = optionEditDirectors;
    }

    public void setActors(List<String> optionEditActors) {
        this.actors = optionEditActors;
    }

    public void setGenres(List<Genre> optionEditGenres) {
        this.genres = optionEditGenres;
    }

    public void setDescription(String optionEditDescription) {
        this.description = optionEditDescription;
    }

}