package org.example;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class User<T extends Comparable<T>>  {

    public static class Information {

        private final Credentials credentials;
        private final String name;
        private final String country;
        private final int age;
        private final char gender;
        private final LocalDate dateOfBirth;

        private Information(Builder builder) {
            this.credentials = new Credentials(builder.credentials.getEmail(), builder.credentials.getPassword());
            this.name = builder.name;
            this.country = builder.country;
            this.age = builder.age;
            this.gender = builder.gender;
            this.dateOfBirth = builder.dateOfBirth;
        }

        public Credentials getCredentials() {
            return credentials;
        }

        public static class Builder {
            private Credentials credentials;
            private String name;
            private String country;
            private int age;
            private char gender;
            private LocalDate dateOfBirth;

            public Builder(Credentials credentials) {
                this.credentials = credentials;
            }

            public Builder withName(String name) {
                this.name = name;
                return this;
            }

            public Builder withCountry(String country) {
                this.country = country;
                return this;
            }

            public Builder withAge(int age) {
                this.age = age;
                return this;
            }

            public Builder withGender(char gender) {
                this.gender = gender;
                return this;
            }

            public Builder withDateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
                return this;
            }

            public Information build() {
                return new Information(this);
            }
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        public int getAge() {
            return age;
        }

        public char getGender() {
            return gender;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public String getDateOfBirthFormatted() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return dateOfBirth.format(formatter);
        }

        @Override
        public String toString() {
            return "Name: " + name + "\nCountry: " + country + "\nAge: " + age + "\nGender: " + gender + "\nDate of Birth: " + getDateOfBirthFormatted();
        }
    }

    private Information information;
    private AccountType accountType;
    private String username;
    private int experience;
    private ExperienceStrategy experienceStrategy;
    private List<String> notifications;
    private SortedSet<String> favorites;

    public User(String username, Information information, AccountType accountType, int experience, List<String> notifications, SortedSet<String> favorites) {
        this.information = information;
        this.accountType = accountType;
        this.experience = experience;
        this.notifications = notifications;
        this.favorites = favorites;
        this.username = username;
    }

    public static String generateUsername(String name) {
        return name.toLowerCase().replace(" ", "_") + "_" + (int) (Math.random() * 1000);
    }

    public static String generatePassword() {
        return UUID.randomUUID().toString();
    }


    public void performExperienceStrategy(String action){
        switch (action) {
            case "ADD_REVIEW":
                experienceStrategy = new ReviewExperienceStrategy();
                break;
            case "RESOLVE_REQUEST":
                experienceStrategy = new RequestsExperienceStrategy();
                break;
        }
        experience += experienceStrategy.calculateExperience();
    }
    public String getUsername() {
        return username;
    }
    public void addToFavorites(String item) {
        favorites.add(item);
    }

    public void removeFromFavorites(String item) {
        favorites.remove(item);
    }

    public void updateExperience(int points) {
        if (accountType != AccountType.ADMIN) {
            experience += points;
        }
    }
    public AccountType getAccountType() {
        return accountType;
    }

    public int getExperience() {
        return experience;
    }

    public void addNotification(String notification) {
        notifications.add(notification);
    }

    public String getNotifications() {
        StringBuilder sb = new StringBuilder();
        for (String notification : notifications) {
            sb.append(notification).append("\n");
        }
        return sb.toString();
    }


    public String getFavorites() {
        StringBuilder sb = new StringBuilder();
        for (String favorite : favorites) {
            sb.append(favorite).append("\n");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Username: " + username + "\nAccount Type: " + accountType + "\nExperience: " + experience
                + "\nNotifications: " + notifications + "\nFavorites: " + favorites + "\n" + information ;
    }

    public Information getInformation() {
        return information;
    }
}