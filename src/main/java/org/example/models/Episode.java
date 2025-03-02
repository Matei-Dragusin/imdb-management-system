package org.example;

public class Episode {
    private String episodeName;
    private String duration;

    public Episode(String episodeName, String duration) {
        this.episodeName = episodeName;
        this.duration = duration;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public String getDuration() {
        return duration;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void displayInfo() {
        String display = super.toString() + "\n" + "Episode Name: " + episodeName + "\n" + "Duration: " + duration + "\n";
        System.out.println(display);
    }

    public void setName(String optionEditEpisodeName) {
        this.episodeName = optionEditEpisodeName;
    }
}
