package org.example;

public class Rating {
    private String username;
    private double score;
    private String comments;

    public Rating(String username, double score, String comments) {
        this.username = username;
        this.score = Math.max(1, Math.min(10, score));
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public double getScore() {
        return score;
    }

    public String getComments() {
        return comments;
    }

    public void setScore(int optionRate1) {
        this.score = optionRate1;
    }

    public void setComments(String optionComment1) {
        this.comments = optionComment1;
    }
}
