package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Request {
    private RequestTypes requestType;
    private LocalDateTime creationDate;
    private String description;
    private String createdByUsername;
    private String to;
    private String actorName;
    private String movieTitle;

    public Request(RequestTypes requestType, LocalDateTime creationDate, String description, String createdByUsername) {
        this.requestType = requestType;
        this.creationDate = creationDate;
        this.description = description;
        this.createdByUsername = createdByUsername;
    }

    public Request() {

    }

    public RequestTypes getRequestType() {
        return requestType;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public String getDescription() {
        return description;
    }
    public String getCreatedByUsername() {
        return createdByUsername;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    public void setRequestType(RequestTypes requestType) {
        this.requestType = requestType;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreatedByUsername(String createdByUsername) {
        this.createdByUsername = createdByUsername;
    }
    public String getActorName() {
        return actorName;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCreationDateFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return creationDate.format(formatter);
    }

    public String toString() {
        return "Request{" +
                "requestType=" + requestType +
                ", creationDate=" + creationDate +
                ", description='" + description + '\'' +
                ", createdByUsername='" + createdByUsername + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}
