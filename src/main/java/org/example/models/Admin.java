package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Admin<T extends  Comparable<T>> extends Staff<T> {

    private static List<Production> adminProductionSystem = new ArrayList<>();

    private static List<Actor> adminActorSystem = new ArrayList<>();
    public Admin(String username, Information information, AccountType accountType, int experience, List<String> notifications, SortedSet<String> favorites, List<Request> assignedRequests, SortedSet<T> addedItems){
        super(username, information,AccountType.ADMIN,experience,notifications,favorites,assignedRequests,addedItems);
    }

    public static void addAdminProductionSystem(Production p){
        adminProductionSystem.add(p);
    }

    public static void addAdminActorSystem(Actor a){
        adminActorSystem.add(a);
    }

    public static void removeAdminActorSystem(Actor a){
        adminActorSystem.remove(a);
    }

    public static void removeAdminProductionSystem(Production p){
        adminProductionSystem.remove(p);
    }

    public static void updateAdminProductionSystem(Production p){
        adminProductionSystem.set(adminProductionSystem.indexOf(p),p);
    }

    public static List<Production> getAdminProductionSystem(){
        return adminProductionSystem;
    }

    public static boolean containsAdminProductionSystem(String p){
        return adminProductionSystem.contains(p);
    }

    public static List<Actor> getAdminActorSystem(){
        return adminActorSystem;
    }

    public static boolean containsAdminActorSystem(Actor a){
        return adminActorSystem.contains(a);
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
