package org.example;

import java.util.List;
import java.util.SortedSet;

public class Contributor<T extends Comparable<T>> extends Staff implements RequestsManager {
    public Contributor(String username, Information information, AccountType accountType, int experience, List<String> notifications, SortedSet<String> favorites, List<Request> assignedRequests, SortedSet<T> addedItems){
        super(username,information,AccountType.CONTRIBUTOR,experience,notifications,favorites,assignedRequests,addedItems);
    }


    @Override
    public void createRequest(Request r) {

    }


    @Override
    public void removeRequest(Request r) {

    }

    @Override
    public void addProductionSystem(Production p) {

    }

    @Override
    public void addActorSystem(Actor a) {

    }

    @Override
    public void removeProductionSystem(Production p) {

    }

    @Override
    public void removeActorSystem(String name) {

    }

    @Override
    public void updateProduction(Production p) {

    }

    @Override
    public void updateActor(Actor a) {

    }
}
