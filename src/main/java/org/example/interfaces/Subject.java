package org.example;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String notification);
}
