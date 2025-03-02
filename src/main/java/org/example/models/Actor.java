package org.example;

import java.util.ArrayList;
import java.util.List;

public class Actor{
    private String name;
    private List<NameTypePair> productions;
    private String biography;

    public Actor(String name, String biography){
        this.name = name;
        this.biography = biography;
        this.productions = new ArrayList<>();
    }

    public void addProduction(String name, String type){
        NameTypePair pair = new NameTypePair(name, type);
        productions.add(pair);
    }

    public String getName(){
        return name;
    }

    public String getBiography(){
        return biography;
    }

    public void showProductions(){
        for (NameTypePair pair : productions){
            System.out.println(" " + pair.getName() + " (" + pair.getType() + ")");
        }
    }

    public void setBiography(String optionEditBiography) {
        this.biography = optionEditBiography;
    }

    public void setName(String optionEditName) {
        this.name = optionEditName;
    }

    private class NameTypePair{
        private String name;
        private String type;

        public NameTypePair(String name, String type){
            this.name = name;
            this.type = type;
        }

        public String getName(){
            return name;
        }

        public String getType(){
            return type;
        }
    }
}