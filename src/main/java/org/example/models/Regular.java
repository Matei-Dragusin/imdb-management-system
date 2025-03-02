package org.example;


import java.util.List;
import java.util.SortedSet;

public class Regular<T extends Comparable<T>> extends User implements RequestsManager{
    public Regular(String username, Information information, AccountType accountType, int experience, List<String> notifications, SortedSet<String> favorites){
        super(username, information,AccountType.REGULAR,experience,notifications,favorites);
    }
    @Override
    public void createRequest(Request request){

    }
    @Override
    public void removeRequest(Request request){

    }
}
