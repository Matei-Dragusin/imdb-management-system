package org.example;

import java.time.Year;
import java.util.List;
import java.util.Map;

public class Series extends Production{
    private int releaseYear;
    private int numberOfSeasons;
    private Map<String,List<Episode>> seasons;

    public Series(String title, List<String> directors, List<String> actors, List<Genre> genres, List<Rating> ratings, String description, int releaseYear, int numberOfSeasons, Map<String,List<Episode>> seasons){
        super(title, directors, actors, genres, ratings, description);
        this.releaseYear = releaseYear;
        this.numberOfSeasons = numberOfSeasons;
        this.seasons = seasons;
    }
    public int getReleaseYear(){
        return releaseYear;
    }
    public int getNumberOfSeasons(){
        return numberOfSeasons;
    }
    public Map<String,List<Episode>> getSeasons(){
        return seasons;
    }

    @Override
    public void displayInfo(){
        System.out.println("Series Title: " + getTitle());
        if (releaseYear != 0) {
            System.out.println("Release Year: " + releaseYear);
        }
        if (numberOfSeasons != 0) {
            System.out.println("Number of Seasons: " + numberOfSeasons);
        }

        for (Map.Entry<String, List<Episode>> seasonEntry : seasons.entrySet()) {
            String seasonName = seasonEntry.getKey();
            List<Episode> episodes = seasonEntry.getValue();

            System.out.println(seasonName);

            for (Episode episode : episodes) {
                System.out.println("  " + episode.getEpisodeName());
            }
        }
    }

    public void setNumberOfSeasons(int optionEditNumberOfSeasons) {
        this.numberOfSeasons = optionEditNumberOfSeasons;
    }

    public void setReleaseYear(int optionEditReleaseYear) {
        this.releaseYear = optionEditReleaseYear;
    }
}