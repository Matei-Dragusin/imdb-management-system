package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.*;


public class IMDB {
    private static IMDB instance = null;
    private List<User> users;
    private List<Actor> actors;
    private List<Request> requests;
    private List<Production> productions;

    public IMDB() {
    }

    private static IMDB getInstance() {
        if (instance == null) {
            instance = new IMDB();
        }
        return instance;
    }

    public void run() {
        String actorsPath = "/home/matei/Desktop/bazadatepoo/POO-TEMA-2023-CHECKER/src/main/resources/input/actors.json";
        String usersPath = "/home/matei/Desktop/bazadatepoo/POO-TEMA-2023-CHECKER/src/main/resources/input/accounts.json";
        String productionsPath = "/home/matei/Desktop/bazadatepoo/POO-TEMA-2023-CHECKER/src/main/resources/input/production.json";
        String requestsPath = "/home/matei/Desktop/bazadatepoo/POO-TEMA-2023-CHECKER/src/main/resources/input/requests.json";

        actors = readActorsData(actorsPath);
        productions = readProductionsData(productionsPath);
        users = readUserData(usersPath);
        requests = readRequestData(requestsPath);
        processActorsAndProductions();

        boolean authenticated;
        do {

            User user = authenticateUser();
            System.out.println("Welcome, " + user.getUsername());
            authenticated = true;
            switch (user.getAccountType()) {
                case REGULAR:
                    boolean exit;
                    do {
                        exit = false;
                        System.out.println("Username: " + user.getUsername());
                        System.out.println("User experience: " + user.getExperience());
                        System.out.println("Choose an option: ");
                        System.out.println("1) View productions details");
                        System.out.println("2) View actor details");
                        System.out.println("3) View notifications");
                        System.out.println("4) Search actor/movie/series");
                        System.out.println("5) Add actor/movie/series to favorites");
                        System.out.println("6) Remove actor/movie/series from favorites");
                        System.out.println("7) View favorites");
                        System.out.println("8) Create request");
                        System.out.println("9) Remove request");
                        System.out.println("10) Rate production");
                        System.out.println("11) Log out");
                        Scanner scanner = new Scanner(System.in);
                        int option = scanner.nextInt();
                        switch (option) {
                            case 1: {
                                System.out.println("Filter by: ");
                                System.out.println("1) Genre");
                                System.out.println("2) Rating");
                                Scanner scanner1 = new Scanner(System.in);
                                int option1 = scanner1.nextInt();
                                switch (option1) {
                                    case 1: {
                                        System.out.println("Choose genre: ");
                                        System.out.println("1) Action");
                                        System.out.println("2) Adventure");
                                        System.out.println("3) Comedy");
                                        System.out.println("4) Drama");
                                        System.out.println("5) Horror");
                                        System.out.println("6) SF");
                                        System.out.println("7) Fantasy");
                                        System.out.println("8) Romance");
                                        System.out.println("9) Mystery");
                                        System.out.println("10) Thriller");
                                        System.out.println("11) Crime");
                                        System.out.println("12) Biography");
                                        System.out.println("13) War");
                                        System.out.println("14) Cooking");
                                        Scanner genre = new Scanner(System.in);
                                        int option2 = genre.nextInt();
                                        switch (option2) {
                                            case 1:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Action)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 2:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Adventure)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 3:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Comedy)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 4:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Drama)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 5:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Horror)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 6:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.SF)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 7:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Fantasy)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 8:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Romance)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 9:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Mystery)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 10:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Thriller)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 11:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Crime)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 12:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Biography)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 13:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.War)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 14: {
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Cooking)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        Scanner scanner2 = new Scanner(System.in);
                                        System.out.println("Choose rating: ");
                                        int option2 = scanner2.nextInt();
                                        for (Production production : productions) {
                                            if (production.getAverageRating() >= option2) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2:
                            {
                                System.out.println("Choose actor: ");
                                for (Actor actor : actors) {
                                    System.out.println(actor.getName());
                                }
                                System.out.println("Type actor name: ");
                                Scanner scannerActors = new Scanner(System.in);
                                String optionActors = scannerActors.nextLine();
                                for (Actor actor : actors) {
                                    if (actor.getName().equals(optionActors)) {
                                        System.out.println("Name: " + actor.getName());
                                        System.out.println("Biography: " + actor.getBiography());
                                        System.out.println("Productions: ");
                                        actor.showProductions();
                                    }
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Notifications: ");
                                if (user.getNotifications().isEmpty()) {
                                    System.out.println("No notifications");
                                } else {
                                    System.out.println(user.getNotifications());
                                }
                                break;
                            }
                            case 4: {
                                System.out.println("Search by: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerSearch = new Scanner(System.in);
                                int optionSearch = scannerSearch.nextInt();
                                switch (optionSearch) {
                                    case 1:
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                System.out.println("Name: " + actor.getName());
                                                System.out.println("Biography: " + actor.getBiography());
                                                System.out.println("Productions: ");
                                                actor.showProductions();
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("Add to favorites: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerAddToFavorites = new Scanner(System.in);
                                int optionAddToFavorites = scannerAddToFavorites.nextInt();
                                switch (optionAddToFavorites) {
                                    case 1:
                                        for (Actor actor : actors) {
                                            System.out.println(actor.getName());
                                        }
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                if (user.getFavorites().contains(actor.getName())) {
                                                    System.out.println("Actor already in favorites");
                                                } else {
                                                    user.addToFavorites(actor.getName());
                                                    System.out.println("Actor added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    System.out.println("Movie already in favorites");
                                                } else {
                                                    user.addToFavorites(production.getTitle());
                                                    System.out.println("Movie added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    System.out.println("Series already in favorites");
                                                } else {
                                                    user.addToFavorites(production.getTitle());
                                                    System.out.println("Series added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 6: {
                                System.out.println("Remove from favorites: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerRemoveFromFavorites = new Scanner(System.in);
                                int optionRemoveFromFavorites = scannerRemoveFromFavorites.nextInt();
                                switch (optionRemoveFromFavorites) {
                                    case 1:
                                        for (Actor actor : actors) {
                                            System.out.println(actor.getName());
                                        }
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                if (user.getFavorites().contains(actor.getName())) {
                                                    user.removeFromFavorites(actor.getName());
                                                    System.out.println("Actor removed from favorites");
                                                } else {
                                                    System.out.println("Actor not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    user.removeFromFavorites(production.getTitle());
                                                    System.out.println("Movie removed from favorites");
                                                } else {
                                                    System.out.println("Movie not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    user.removeFromFavorites(production.getTitle());
                                                    System.out.println("Series removed from favorites");
                                                } else {
                                                    System.out.println("Series not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 7: {
                                System.out.println("Favorites: ");
                                if (user.getFavorites().isEmpty()) {
                                    System.out.println("No favorites");
                                } else {
                                    System.out.println(user.getFavorites());
                                }
                                break;
                            }
                            case 8: {
                                System.out.println("Create request: ");
                                System.out.println("1) Actor issue");
                                System.out.println("2) Movie issue");
                                System.out.println("3) Others");
                                System.out.println("4) Delete account");
                                Scanner scannerRequest = new Scanner(System.in);
                                int optionRequest = scannerRequest.nextInt();
                                switch (optionRequest) {
                                    case 1:
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                System.out.println("Type description: ");
                                                Scanner scannerDescription = new Scanner(System.in);
                                                String optionDescription = scannerDescription.nextLine();
                                                Request request = new Request();
                                                request.setRequestType(RequestTypes.ACTOR_ISSUE);
                                                request.setCreationDate(LocalDateTime.now());
                                                request.setCreatedByUsername(user.getUsername());
                                                request.setDescription(optionDescription);
                                                request.setActorName(actor.getName());
                                                for (User user1 : users) {
                                                    if (user1 instanceof Staff<?> staffMember) {
                                                        if (staffMember.containsContribution(actor.getName())) {
                                                            request.setTo(user1.getUsername());
                                                            staffMember.addNotification("New request for " + actor.getName());
                                                        }
                                                    }
                                                }
                                                requests.add(request);
                                                System.out.println("Request created");
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                System.out.println("Type description: ");
                                                Scanner scannerDescription = new Scanner(System.in);
                                                String optionDescription = scannerDescription.nextLine();
                                                Request request = new Request();
                                                request.setRequestType(RequestTypes.MOVIE_ISSUE);
                                                request.setCreationDate(LocalDateTime.now());
                                                request.setCreatedByUsername(user.getUsername());
                                                request.setDescription(optionDescription);
                                                request.setMovieTitle(production.getTitle());
                                                for (User user1 : users) {
                                                    if (user1 instanceof Staff<?> staffMember) {
                                                        if (staffMember.containsContribution(production.getTitle())) {
                                                            request.setTo(user1.getUsername());
                                                            staffMember.addNotification("New request for " + production.getTitle());
                                                        }
                                                    }
                                                }
                                                requests.add(request);
                                                System.out.println("Request created");
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type description: ");
                                        Scanner scannerDescription = new Scanner(System.in);
                                        String optionDescription = scannerDescription.nextLine();
                                        Request request = new Request();
                                        request.setRequestType(RequestTypes.OTHERS);
                                        request.setCreationDate(LocalDateTime.now());
                                        request.setCreatedByUsername(user.getUsername());
                                        request.setDescription(optionDescription);
                                        RequestsHolder.addRequest(request);
                                        requests.add(request);
                                        System.out.println("Request created");
                                        break;
                                    case 4:
                                        System.out.println("Type description: ");
                                        Scanner scannerDescription1 = new Scanner(System.in);
                                        String optionDescription1 = scannerDescription1.nextLine();
                                        Request request1 = new Request();
                                        request1.setRequestType(RequestTypes.DELETE_ACCOUNT);
                                        request1.setCreationDate(LocalDateTime.now());
                                        request1.setCreatedByUsername(user.getUsername());
                                        request1.setDescription(optionDescription1);
                                        request1.setTo("ADMIN");
                                        RequestsHolder.addRequest(request1);
                                        requests.add(request1);
                                        System.out.println("Request created");
                                        break;
                                }
                                break;
                            }
                            case 9: {
                                System.out.println("Remove request: ");
                                System.out.println("Select request: ");
                                for (Request request : requests) {
                                    if (request.getCreatedByUsername().equals(user.getUsername())) {
                                        System.out.println(request.getRequestType() + " " + request.getCreationDate() + " " + request.getDescription() + " " + request.getCreatedByUsername() + " " + request.getTo());
                                    }
                                }
                                Scanner scannerRemoveRequest = new Scanner(System.in);
                                int optionRemoveRequest = scannerRemoveRequest.nextInt();
                                int i = 0;
                                for (Request request : requests) {
                                    if (request.getCreatedByUsername().equals(user.getUsername())) {
                                        i++;
                                        if (i == optionRemoveRequest) {
                                            if (request.getTo().equals("ADMIN")){
                                                RequestsHolder.removeRequest(request);
                                            }else {
                                                String getTo = request.getTo();
                                                for (User user1 : users) {
                                                    if (user1.getUsername().equals(getTo)) {
                                                        user1.addNotification("Request removed");
                                                    }
                                                }
                                            }
                                            requests.remove(request);
                                            System.out.println("Request removed");
                                            break;
                                        }
                                    }
                                }
                                break;
                            }
                            case 10: {
                                System.out.println("Rate: ");
                                int index = 0;
                                for (Production production : productions) {
                                    System.out.println(index++ + ") " + production.getTitle());
                                }
                                Scanner scannerRate = new Scanner(System.in);
                                String optionRate = scannerRate.nextLine();
                                int index1 = 0;
                                for (Production production : productions) {
                                    if (production.getTitle().equals(optionRate)) {
                                        System.out.println("Rate (1-10): ");
                                        Scanner scannerRate1 = new Scanner(System.in);
                                        int optionRate1 = scannerRate1.nextInt();
                                        System.out.println("Comment: ");
                                        Scanner scannerComment = new Scanner(System.in);
                                        String optionComment = scannerComment.nextLine();

                                        boolean ratingExists = false;
                                        for (Rating r : production.getRatings()) {
                                            if (r.getUsername().equals(user.getUsername())) {
                                                r.setScore(optionRate1);
                                                r.setComments(optionComment);
                                                ratingExists = true;
                                                break;
                                            }
                                        }

                                        if (!ratingExists) {
                                            Rating rating = new Rating(user.getUsername(), optionRate1, optionComment);
                                            production.addRating(rating);
                                            production.setAverageRating(production.getAverageRating());
                                            ExperienceStrategy experienceStrategy = new ReviewExperienceStrategy();
                                            user.updateExperience(experienceStrategy.calculateExperience());
                                            for (Rating r : production.getRatings()) {
                                                for (User user2 : users){
                                                    if (user2.getUsername().equals(r.getUsername()) || user2.getFavorites().contains(production.getTitle())){
                                                        user2.addNotification("New rating for " + production.getTitle());
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println("Rating updated.");
                                        break;
                                    }
                                }
                                break;
                        }
                            case 11: {
                                System.out.println("Close the app or log out?");
                                System.out.println("1) Close");
                                System.out.println("2) Log out");
                                Scanner scannerExit = new Scanner(System.in);
                                int optionExit = scannerExit.nextInt();
                                switch (optionExit) {
                                    case 1:
                                        exit = true;
                                        authenticated = false;
                                        break;
                                    case 2:
                                        exit = true;
                                        break;
                                }
                            }
                        }
                    } while (!exit);


                    break;
                case CONTRIBUTOR:
                    boolean exit1;
                    do {
                        exit1 = false;
                        System.out.println("Username: " + user.getUsername());
                        System.out.println("User experience: " + user.getExperience());
                        System.out.println("Choose an option: ");
                        System.out.println("1) View productions details");
                        System.out.println("2) View actor details");
                        System.out.println("3) View notifications");
                        System.out.println("4) Search actor/movie/series");
                        System.out.println("5) Add actor/movie/series to favorites");
                        System.out.println("6) Remove actor/movie/series from favorites");
                        System.out.println("7) View favorites");
                        System.out.println("8) Create request");
                        System.out.println("9) Remove request");
                        System.out.println("10) Add/Delete actor/movie/series from IMDB");
                        System.out.println("11) Solve request");
                        System.out.println("12) Update movie details");
                        System.out.println("13) Update series details");
                        System.out.println("14) Update actor details");
                        System.out.println("15) Log out");
                        Scanner scanner = new Scanner(System.in);
                        int option = scanner.nextInt();
                        switch (option) {

                            case 1: {
                                System.out.println("Filter by: ");
                                System.out.println("1) Genre");
                                System.out.println("2) Rating");
                                Scanner scanner1 = new Scanner(System.in);
                                int option1 = scanner1.nextInt();
                                switch (option1) {
                                    case 1: {
                                        System.out.println("Choose genre: ");
                                        System.out.println("1) Action");
                                        System.out.println("2) Adventure");
                                        System.out.println("3) Comedy");
                                        System.out.println("4) Drama");
                                        System.out.println("5) Horror");
                                        System.out.println("6) SF");
                                        System.out.println("7) Fantasy");
                                        System.out.println("8) Romance");
                                        System.out.println("9) Mystery");
                                        System.out.println("10) Thriller");
                                        System.out.println("11) Crime");
                                        System.out.println("12) Biography");
                                        System.out.println("13) War");
                                        System.out.println("14) Cooking");
                                        Scanner genre = new Scanner(System.in);
                                        int option2 = genre.nextInt();
                                        switch (option2) {
                                            case 1:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Action)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 2:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Adventure)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 3:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Comedy)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 4:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Drama)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 5:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Horror)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 6:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.SF)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 7:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Fantasy)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 8:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Romance)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 9:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Mystery)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 10:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Thriller)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 11:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Crime)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 12:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Biography)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 13:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.War)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 14: {
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Cooking)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        Scanner scanner2 = new Scanner(System.in);
                                        System.out.println("Choose rating: ");
                                        int option2 = scanner2.nextInt();
                                        for (Production production : productions) {
                                            if (production.getAverageRating() >= option2) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Choose actor: ");
                                for (Actor actor : actors) {
                                    System.out.println(actor.getName());
                                }
                                System.out.println("Type actor name: ");
                                Scanner scannerActors = new Scanner(System.in);
                                String optionActors = scannerActors.nextLine();
                                for (Actor actor : actors) {
                                    if (actor.getName().equals(optionActors)) {
                                        System.out.println("Name: " + actor.getName());
                                        System.out.println("Biography: " + actor.getBiography());
                                        System.out.println("Productions: ");
                                        actor.showProductions();
                                    }
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Notifications: ");
                                if (user.getNotifications().isEmpty()) {
                                    System.out.println("No notifications");
                                } else {
                                    System.out.println(user.getNotifications());
                                }
                                break;
                            }
                            case 4: {
                                System.out.println("Search by: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerSearch = new Scanner(System.in);
                                int optionSearch = scannerSearch.nextInt();
                                switch (optionSearch) {
                                    case 1:
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                System.out.println("Name: " + actor.getName());
                                                System.out.println("Biography: " + actor.getBiography());
                                                System.out.println("Productions: ");
                                                actor.showProductions();
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("Add to favorites: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerAddToFavorites = new Scanner(System.in);
                                int optionAddToFavorites = scannerAddToFavorites.nextInt();
                                switch (optionAddToFavorites) {
                                    case 1:
                                        for (Actor actor : actors) {
                                            System.out.println(actor.getName());
                                        }
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                if (user.getFavorites().contains(actor.getName())) {
                                                    System.out.println("Actor already in favorites");
                                                } else {
                                                    user.addToFavorites(actor.getName());
                                                    System.out.println("Actor added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    System.out.println("Movie already in favorites");
                                                } else {
                                                    user.addToFavorites(production.getTitle());
                                                    System.out.println("Movie added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    System.out.println("Series already in favorites");
                                                } else {
                                                    user.addToFavorites(production.getTitle());
                                                    System.out.println("Series added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 6: {
                                System.out.println("Remove from favorites: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerRemoveFromFavorites = new Scanner(System.in);
                                int optionRemoveFromFavorites = scannerRemoveFromFavorites.nextInt();
                                switch (optionRemoveFromFavorites) {
                                    case 1:
                                        for (Actor actor : actors) {
                                            System.out.println(actor.getName());
                                        }
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                if (user.getFavorites().contains(actor.getName())) {
                                                    user.removeFromFavorites(actor.getName());
                                                    System.out.println("Actor removed from favorites");
                                                } else {
                                                    System.out.println("Actor not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    user.removeFromFavorites(production.getTitle());
                                                    System.out.println("Movie removed from favorites");
                                                } else {
                                                    System.out.println("Movie not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    user.removeFromFavorites(production.getTitle());
                                                    System.out.println("Series removed from favorites");
                                                } else {
                                                    System.out.println("Series not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 7: {
                                System.out.println("Favorites: ");
                                if (user.getFavorites().isEmpty()) {
                                    System.out.println("No favorites");
                                } else {
                                    System.out.println(user.getFavorites());
                                }
                                break;
                            }
                            case 8: {
                                System.out.println("Create request: ");
                                System.out.println("1) Actor issue");
                                System.out.println("2) Movie issue");
                                System.out.println("3) Others");
                                System.out.println("4) Delete account");
                                Scanner scannerRequest = new Scanner(System.in);
                                int optionRequest = scannerRequest.nextInt();
                                switch (optionRequest) {
                                    case 1:
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                System.out.println("Type description: ");
                                                Scanner scannerDescription = new Scanner(System.in);
                                                String optionDescription = scannerDescription.nextLine();
                                                Request request = new Request();
                                                request.setRequestType(RequestTypes.ACTOR_ISSUE);
                                                request.setCreationDate(LocalDateTime.now());
                                                request.setCreatedByUsername(user.getUsername());
                                                request.setDescription(optionDescription);
                                                request.setActorName(actor.getName());
                                                for (User user1 : users) {
                                                    if (user1 instanceof Staff<?> staffMember) {
                                                        if (staffMember.containsContribution(actor.getName())) {
                                                            request.setTo(user1.getUsername());
                                                            user1.addNotification("You have a new request");
                                                        }
                                                    }
                                                }
                                                requests.add(request);
                                                System.out.println("Request created");
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                System.out.println("Type description: ");
                                                Scanner scannerDescription = new Scanner(System.in);
                                                String optionDescription = scannerDescription.nextLine();
                                                Request request = new Request();
                                                request.setRequestType(RequestTypes.MOVIE_ISSUE);
                                                request.setCreationDate(LocalDateTime.now());
                                                request.setCreatedByUsername(user.getUsername());
                                                request.setDescription(optionDescription);
                                                request.setMovieTitle(production.getTitle());
                                                for (User user1 : users) {
                                                    if (user1 instanceof Staff<?> staffMember) {
                                                        if (staffMember.containsContribution(production.getTitle())) {
                                                            request.setTo(user1.getUsername());
                                                            user1.addNotification("You have a new request");
                                                        }
                                                    }
                                                }
                                                requests.add(request);
                                                System.out.println("Request created");
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type description: ");
                                        Scanner scannerDescription = new Scanner(System.in);
                                        String optionDescription = scannerDescription.nextLine();
                                        Request request = new Request();
                                        request.setRequestType(RequestTypes.OTHERS);
                                        request.setCreationDate(LocalDateTime.now());
                                        request.setCreatedByUsername(user.getUsername());
                                        request.setDescription(optionDescription);
                                        request.setTo("ADMIN");
                                        RequestsHolder.addRequest(request);
                                        requests.add(request);
                                        System.out.println("Request created");
                                        break;
                                    case 4:
                                        System.out.println("Type description: ");
                                        Scanner scannerDescription1 = new Scanner(System.in);
                                        String optionDescription1 = scannerDescription1.nextLine();
                                        Request request1 = new Request();
                                        request1.setRequestType(RequestTypes.DELETE_ACCOUNT);
                                        request1.setCreationDate(LocalDateTime.now());
                                        request1.setCreatedByUsername(user.getUsername());
                                        request1.setDescription(optionDescription1);
                                        request1.setTo("ADMIN");
                                        requests.add(request1);
                                        RequestsHolder.addRequest(request1);
                                        System.out.println("Request created");
                                        break;
                                }
                                break;
                            }
                            case 9: {
                                System.out.println("Remove request");
                                System.out.println("Select request: ");
                                for (Request request : requests) {
                                    if (request.getCreatedByUsername().equals(user.getUsername())) {
                                        System.out.println(request.getCreatedByUsername() + " " + request.getRequestType() + " " + request.getCreationDate() + " " + request.getDescription());
                                    }
                                }
                                Scanner scannerRemoveRequest = new Scanner(System.in);
                                int optionRemoveRequest = scannerRemoveRequest.nextInt();
                                int i = 0;
                                for (Request request : requests) {
                                    if (request.getCreatedByUsername().equals(user.getUsername())) {
                                        i++;
                                        if (i == optionRemoveRequest) {
                                            if (request.getTo().equals("ADMIN")) {
                                                RequestsHolder.removeRequest(request);
                                            }else {
                                                String requestTo = request.getTo();
                                                for (User user1 : users) {
                                                    if (user1.getUsername().equals(requestTo)) {
                                                        user.addNotification("Your request has been removed");
                                                    }
                                                }
                                            }
                                            requests.remove(request);
                                            System.out.println("Request removed");
                                        }
                                    }
                                }
                            }
                            case 10: {
                                System.out.println("Add/Delete from IMDB: ");
                                System.out.println("1) Add/Remove actor");
                                System.out.println("2) Add/Remove movie");
                                System.out.println("3) Add/Remove series");
                                Scanner scannerIMDB = new Scanner(System.in);
                                int optionIMDB = scannerIMDB.nextInt();
                                switch (optionIMDB) {
                                    case 1: {
                                        System.out.println("Add/Remove actor: ");
                                        System.out.println("1) Add actor");
                                        System.out.println("2) Remove actor");
                                        Scanner scannerIMDBActor = new Scanner(System.in);
                                        int optionIMDBActor = scannerIMDBActor.nextInt();
                                        switch (optionIMDBActor) {
                                            case 1: {
                                                System.out.println("Type actor name: ");
                                                Scanner scannerIMDBActorAdd = new Scanner(System.in);
                                                String optionIMDBActorAdd = scannerIMDBActorAdd.nextLine();
                                                boolean actorFound = false;
                                                for (Actor actor : actors) {
                                                    if (actor.getName().equals(optionIMDBActorAdd)) {
                                                        actorFound = true;
                                                        System.out.println("Actor already in IMDB");
                                                        break;
                                                    }
                                                }
                                                if (!actorFound) {
                                                    System.out.println("Type actor biography: ");
                                                    Scanner scannerIMDBActorBiography = new Scanner(System.in);
                                                    String optionIMDBActorBiography = scannerIMDBActorBiography.nextLine();
                                                    Actor actor = new Actor(optionIMDBActorAdd, optionIMDBActorBiography);
                                                    boolean addProduction = true;
                                                    while (addProduction) {
                                                        System.out.println("Add production: ");
                                                        System.out.println("1) Movie/Series");
                                                        System.out.println("2) Exit");
                                                        Scanner scannerIMDBActorAddProduction = new Scanner(System.in);
                                                        int optionIMDBActorAddProduction = scannerIMDBActorAddProduction.nextInt();
                                                        switch (optionIMDBActorAddProduction) {
                                                            case 1:
                                                                System.out.println("Type production name: ");
                                                                Scanner scannerIMDBActorAddProductionName = new Scanner(System.in);
                                                                String optionIMDBActorAddProductionName = scannerIMDBActorAddProductionName.nextLine();
                                                                System.out.println("Type production type: ");
                                                                Scanner scannerIMDBActorAddProductionType = new Scanner(System.in);
                                                                String optionIMDBActorAddProductionType = scannerIMDBActorAddProductionType.nextLine();
                                                                actor.addProduction(optionIMDBActorAddProductionName, optionIMDBActorAddProductionType);
                                                                break;
                                                            case 2:
                                                                addProduction = false;
                                                                break;
                                                        }
                                                    }
                                                    actors.add(actor);
                                                    ((Contributor)user).addContribution(optionIMDBActorAdd);
                                                    System.out.println("Actor added");
                                                }
                                                break;
                                            }
                                            case 2:
                                                System.out.println("Type actor name: ");
                                                Scanner scannerIMDBActorRemove = new Scanner(System.in);
                                                String optionIMDBActorRemove = scannerIMDBActorRemove.nextLine();
                                                boolean actorFound = false;
                                                for (Actor actor : actors) {
                                                    if (actor.getName().equals(optionIMDBActorRemove)&& user instanceof Staff<?> staffMember && staffMember.containsContribution(optionIMDBActorRemove)) {
                                                        IMDB.getInstance().actors.remove(actor);
                                                        actorFound = true;
                                                        System.out.println("Actor removed");
                                                        break;
                                                    }
                                                }
                                                if (!actorFound) {
                                                    System.out.println("Actor not found");
                                                }
                                                break;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Add/Remove movie: ");
                                        System.out.println("1) Add movie");
                                        System.out.println("2) Remove movie");
                                        Scanner scannerIMDBMovie = new Scanner(System.in);
                                        int optionIMDBMovie = scannerIMDBMovie.nextInt();
                                        switch (optionIMDBMovie) {
                                            case 1:
                                                System.out.println("Type movie name: ");
                                                Scanner scannerIMDBMovieAdd = new Scanner(System.in);
                                                String optionIMDBMovieAdd = scannerIMDBMovieAdd.nextLine();
                                                boolean movieFound = false;
                                                for (Production production : productions) {
                                                    if (production.getTitle().equals(optionIMDBMovieAdd)) {
                                                        movieFound = true;
                                                        System.out.println("Movie already in IMDB");
                                                        break;
                                                    }
                                                }
                                                if (!movieFound) {
                                                    System.out.println("Type movie release year: ");
                                                    Scanner scannerIMDBMovieReleaseYear = new Scanner(System.in);
                                                    int optionIMDBMovieReleaseYear = scannerIMDBMovieReleaseYear.nextInt();
                                                    System.out.println("Type movie duration: ");
                                                    Scanner scannerIMDBMovieDuration = new Scanner(System.in);
                                                    String optionIMDBMovieDuration = scannerIMDBMovieDuration.nextLine();
                                                    System.out.println("Type movie plot: ");
                                                    Scanner scannerIMDBMoviePlot = new Scanner(System.in);
                                                    String optionIMDBMoviePlot = scannerIMDBMoviePlot.nextLine();
                                                    System.out.println("Type movie average rating: ");
                                                    Scanner scannerIMDBMovieAverageRating = new Scanner(System.in);
                                                    double optionIMDBMovieAverageRating = scannerIMDBMovieAverageRating.nextDouble();
                                                    System.out.println("Type movie genre: ");
                                                    Scanner scannerIMDBMovieGenre = new Scanner(System.in);
                                                    String optionIMDBMovieGenre = scannerIMDBMovieGenre.nextLine();
                                                    List<Genre> genres = new ArrayList<>();
                                                    genres.add(Genre.valueOf(optionIMDBMovieGenre));
                                                    System.out.println("Type movie director: ");
                                                    Scanner scannerIMDBMovieDirector = new Scanner(System.in);
                                                    String optionIMDBMovieDirector = scannerIMDBMovieDirector.nextLine();
                                                    List<String> directors = new ArrayList<>();
                                                    directors.add(optionIMDBMovieDirector);
                                                    System.out.println("Type movie actor: ");
                                                    Scanner scannerIMDBMovieActor = new Scanner(System.in);
                                                    String optionIMDBMovieActor = scannerIMDBMovieActor.nextLine();
                                                    List<String> actors = new ArrayList<>();
                                                    actors.add(optionIMDBMovieActor);
                                                    Movie movie = new Movie(optionIMDBMovieAdd, directors, actors, genres, null, optionIMDBMoviePlot, optionIMDBMovieDuration, optionIMDBMovieReleaseYear);
                                                    productions.add(movie);
                                                    ((Contributor) user).addContribution(optionIMDBMovieAdd);
                                                    System.out.println("Movie added");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Type movie name: ");
                                                Scanner scannerIMDBMovieRemove = new Scanner(System.in);
                                                String optionIMDBMovieRemove = scannerIMDBMovieRemove.nextLine();
                                                boolean movieFound1 = false;
                                                for (Production production : productions) {
                                                    if (production.getTitle().equals(optionIMDBMovieRemove) && user instanceof Staff<?> staffMember && staffMember.containsContribution(optionIMDBMovieRemove)) {
                                                        IMDB.getInstance().productions.remove(production);
                                                        movieFound = true;
                                                        System.out.println("Movie removed");
                                                        break;
                                                    }
                                                }
                                                if (!movieFound1) {
                                                    System.out.println("Movie not found");
                                                }
                                                break;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Add/Remove series: ");
                                        System.out.println("1) Add series");
                                        System.out.println("2) Remove series");
                                        Scanner scannerIMDBSeries = new Scanner(System.in);
                                        int optionIMDBSeries = scannerIMDBSeries.nextInt();
                                        switch (optionIMDBSeries) {
                                            case 1:
                                                System.out.println("Type series name: ");
                                                Scanner scannerIMDBSeriesAdd = new Scanner(System.in);
                                                String optionIMDBSeriesAdd = scannerIMDBSeriesAdd.nextLine();
                                                boolean seriesFound = false;
                                                for (Production production : productions) {
                                                    if (production.getTitle().equals(optionIMDBSeriesAdd)) {
                                                        seriesFound = true;
                                                        System.out.println("Series already in IMDB");
                                                        break;
                                                    }
                                                }
                                                if (!seriesFound) {
                                                    System.out.println("Type series release year: ");
                                                    Scanner scannerIMDBSeriesReleaseYear = new Scanner(System.in);
                                                    int optionIMDBSeriesReleaseYear = scannerIMDBSeriesReleaseYear.nextInt();
                                                    System.out.println("Type series number of seasons: ");
                                                    Scanner scannerIMDBSeriesNumberOfSeasons = new Scanner(System.in);
                                                    int optionIMDBSeriesNumberOfSeasons = scannerIMDBSeriesNumberOfSeasons.nextInt();
                                                    Map<String, List<Episode>> seasons = new HashMap<>();
                                                    for (int i = 1; i <= optionIMDBSeriesNumberOfSeasons; i++) {
                                                        String seasonKey = "Season " + i;
                                                        System.out.println("Type number of episodes for season " + i + ": ");
                                                        Scanner scannerIMDBSeriesNumberOfEpisodes = new Scanner(System.in);
                                                        int optionIMDBSeriesNumberOfEpisodes = scannerIMDBSeriesNumberOfEpisodes.nextInt();
                                                        List<Episode> episodes = new ArrayList<>();
                                                        for (int j = 1; j <= optionIMDBSeriesNumberOfEpisodes; j++) {
                                                            System.out.println("Type episode name: ");
                                                            Scanner scannerIMDBSeriesEpisodeName = new Scanner(System.in);
                                                            String optionIMDBSeriesEpisodeName = scannerIMDBSeriesEpisodeName.nextLine();
                                                            System.out.println("Type episode duration: ");
                                                            Scanner scannerIMDBSeriesEpisodeDuration = new Scanner(System.in);
                                                            String optionIMDBSeriesEpisodeDuration = scannerIMDBSeriesEpisodeDuration.nextLine();
                                                            episodes.add(new Episode(optionIMDBSeriesEpisodeName, optionIMDBSeriesEpisodeDuration));
                                                        }
                                                        seasons.put(seasonKey, episodes);
                                                    }
                                                    System.out.println("Type series plot: ");
                                                    Scanner scannerIMDBSeriesPlot = new Scanner(System.in);
                                                    String optionIMDBSeriesPlot = scannerIMDBSeriesPlot.nextLine();
                                                    System.out.println("Type series average rating: ");
                                                    Scanner scannerIMDBSeries1 = new Scanner(System.in);
                                                    double optionIMDBSeriesAverageRating = scannerIMDBSeries.nextDouble();
                                                    System.out.println("Type series genre: ");
                                                    Scanner scannerIMDBSeriesGenre = new Scanner(System.in);
                                                    String optionIMDBSeriesGenre = scannerIMDBSeriesGenre.nextLine();
                                                    List<Genre> genres = new ArrayList<>();
                                                    genres.add(Genre.valueOf(optionIMDBSeriesGenre));
                                                    System.out.println("Type series director: ");
                                                    Scanner scannerIMDBSeriesDirector = new Scanner(System.in);
                                                    String optionIMDBSeriesDirector = scannerIMDBSeriesDirector.nextLine();
                                                    List<String> directors = new ArrayList<>();
                                                    directors.add(optionIMDBSeriesDirector);
                                                    System.out.println("Type series actor: ");
                                                    Scanner scannerIMDBSeriesActor = new Scanner(System.in);
                                                    String optionIMDBSeriesActor = scannerIMDBSeriesActor.nextLine();
                                                    List<String> actors = new ArrayList<>();
                                                    actors.add(optionIMDBSeriesActor);
                                                    Series series = new Series(optionIMDBSeriesAdd, directors, actors, genres, null, optionIMDBSeriesPlot, optionIMDBSeriesReleaseYear, optionIMDBSeriesNumberOfSeasons, seasons);
                                                    productions.add(series);
                                                    ((Contributor)user).addContribution(optionIMDBSeriesAdd);
                                                    System.out.println("Series added");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Type series name: ");
                                                Scanner scannerIMDBSeriesRemove = new Scanner(System.in);
                                                String optionIMDBSeriesRemove = scannerIMDBSeriesRemove.nextLine();
                                                boolean seriesFound1 = false;
                                                for (Production production : productions){
                                                    if (production.getTitle().equals(optionIMDBSeriesRemove) && user instanceof Staff<?> staffMember && staffMember.containsContribution(optionIMDBSeriesRemove)) {
                                                        IMDB.getInstance().productions.remove(production);
                                                        seriesFound1 = true;
                                                        System.out.println("Series removed");
                                                        break;
                                                    }
                                                }
                                                if (!seriesFound1) {
                                                    System.out.println("Series not found");
                                                }
                                                break;
                                        }
                                        break;
                                    }
                                }
                            }
                            case 11: {
                                System.out.println("Solve request: ");
                                boolean requestFound = false;
                                for (Request requestCheck : requests) {
                                    if (requestCheck.getTo().equals(user.getUsername())) {
                                        requestFound = true;
                                    }
                                }
                                if (!requests.isEmpty()&& requestFound ){
                                    for (Request request : requests) {
                                        if (request.getTo().equals(user.getUsername())) {
                                            System.out.println(request.getRequestType() + " " + request.getCreationDate() + " " + request.getDescription());
                                        }
                                    }
                                }else {
                                    System.out.println("No requests");
                                    break;
                                }
                                Scanner scannerSolveRequest = new Scanner(System.in);
                                int optionSolveRequest = scannerSolveRequest.nextInt();
                                System.out.println("Solve it or delete it?");
                                System.out.println("1) Solved");
                                System.out.println("2) Delete");
                                System.out.println("3) Exit");
                                Scanner scannerSolveRequest1 = new Scanner(System.in);
                                int optionSolveRequest1 = scannerSolveRequest1.nextInt();
                                int i = 0;
                                switch (optionSolveRequest1) {
                                    case 2:
                                    for (Request request : requests) {
                                        if (request.getTo().equals(user.getUsername())) {
                                            i++;
                                            if (i == optionSolveRequest) {
                                                if (request.getTo().equals("ADMIN")) {
                                                    RequestsHolder.removeRequest(request);
                                                }else {
                                                    String getTo = request.getTo();
                                                    for (User user1 : users) {
                                                        if (user1.getUsername().equals(getTo)) {
                                                            user1.addNotification("Your request has been removed");
                                                        }
                                                    }
                                                }
                                                requests.remove(request);
                                                System.out.println("Request removed");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                    case 1:
                                    for (Request request : requests) {
                                        if (request.getTo().equals(user.getUsername())) {
                                            i++;
                                            if (i == optionSolveRequest) {
                                                requests.remove(request);
                                                for (User user1 : users) {
                                                    if (user1.getUsername().equals(request.getCreatedByUsername())) {
                                                        user1.addNotification("Your request has been solved");
                                                        ExperienceStrategy experienceStrategy = new RequestsExperienceStrategy();
                                                        user.updateExperience(experienceStrategy.calculateExperience());
                                                        user1.updateExperience(experienceStrategy.calculateExperience());
                                                    }
                                                }
                                                System.out.println("Request solved");
                                            }
                                        }
                                    }
                                    break;
                                    case 3:
                                        break;
                                }
                                break;
                            }
                            case 12: {
                                System.out.println("Update movie details: ");
                                System.out.println("Type movie name: ");
                                for (Production production : productions) {
                                    if (production instanceof Movie) {
                                        System.out.println(production.getTitle());
                                    }
                                }
                                Scanner scannerMovies = new Scanner(System.in);
                                String optionMovies = scannerMovies.nextLine();
                                for (Production production : productions) {
                                    if (production.getTitle().equals(optionMovies)) {
                                        System.out.println("What do you want to edit?");
                                        System.out.println("1) Title");
                                        System.out.println("2) Release year");
                                        System.out.println("3) Duration");
                                        System.out.println("4) Plot");
                                        System.out.println("5) Genre");
                                        System.out.println("6) Director");
                                        System.out.println("7) Actor");
                                        Scanner scannerEdit = new Scanner(System.in);
                                        int optionEdit = scannerEdit.nextInt();
                                        switch (optionEdit) {
                                            case 1:
                                                System.out.println("Type new title: ");
                                                Scanner scannerEditTitle = new Scanner(System.in);
                                                String optionEditTitle = scannerEditTitle.nextLine();
                                                production.setTitle(optionEditTitle);
                                                System.out.println("Title updated");
                                                break;
                                            case 2:
                                                System.out.println("Type new release year: ");
                                                Scanner scannerEditReleaseYear = new Scanner(System.in);
                                                int optionEditReleaseYear = scannerEditReleaseYear.nextInt();
                                                ((Movie) production).setReleaseYear(optionEditReleaseYear);
                                                System.out.println("Release year updated");
                                                break;
                                            case 3:
                                                System.out.println("Type new duration: ");
                                                Scanner scannerEditDuration = new Scanner(System.in);
                                                String optionEditDuration = scannerEditDuration.nextLine();
                                                ((Movie) production).setDuration(optionEditDuration);
                                                System.out.println("Duration updated");
                                                break;
                                            case 4:
                                                System.out.println("Type new plot: ");
                                                Scanner scannerEditPlot = new Scanner(System.in);
                                                String optionEditPlot = scannerEditPlot.nextLine();
                                                production.setDescription(optionEditPlot);
                                                System.out.println("Plot updated");
                                                break;

                                            case 5:
                                                System.out.println("Type new genre: ");
                                                Scanner scannerEditGenre = new Scanner(System.in);
                                                String optionEditGenre = scannerEditGenre.nextLine();
                                                List<Genre> genres = new ArrayList<>();
                                                genres.add(Genre.valueOf(optionEditGenre));
                                                production.setGenres(genres);
                                                System.out.println("Genre updated");
                                                break;
                                            case 6:
                                                System.out.println("Type new director: ");
                                                Scanner scannerEditDirector = new Scanner(System.in);
                                                String optionEditDirector = scannerEditDirector.nextLine();
                                                List<String> directors = new ArrayList<>();
                                                directors.add(optionEditDirector);
                                                production.setDirectors(directors);
                                                System.out.println("Director updated");
                                                break;
                                            case 7:
                                                System.out.println("Type new actor: ");
                                                Scanner scannerEditActor = new Scanner(System.in);
                                                String optionEditActor = scannerEditActor.nextLine();
                                                List<String> actors = new ArrayList<>();
                                                actors.add(optionEditActor);
                                                production.setActors(actors);
                                                System.out.println("Actor updated");
                                                break;

                                        }
                                    }
                                }
                            }
                            case 13: {
                                System.out.println("Update series details: ");
                                System.out.println("Type series name: ");
                                for (Production production : productions) {
                                    if (production instanceof Series && user instanceof Staff<?> staffMember && staffMember.containsContribution(production.getTitle())) {
                                        System.out.println(production.getTitle());
                                    }
                                }
                                Scanner scannerSeries = new Scanner(System.in);
                                String optionSeries = scannerSeries.nextLine();
                                for (Production production : productions) {
                                    if (production.getTitle().equals(optionSeries)) {
                                        System.out.println("What do you want to edit?");
                                        System.out.println("1) Title");
                                        System.out.println("2) Release year");
                                        System.out.println("3) Number of seasons");
                                        System.out.println("4) Plot");
                                        System.out.println("5) Genre");
                                        System.out.println("6) Director");
                                        System.out.println("7) Actor");
                                        System.out.println("8) Episode");
                                        Scanner scannerEdit = new Scanner(System.in);
                                        int optionEdit = scannerEdit.nextInt();
                                        switch (optionEdit) {
                                            case 1:
                                                System.out.println("Type new title: ");
                                                Scanner scannerEditTitle = new Scanner(System.in);
                                                String optionEditTitle = scannerEditTitle.nextLine();
                                                production.setTitle(optionEditTitle);
                                                System.out.println("Title updated");
                                                break;
                                            case 2:
                                                System.out.println("Type new release year: ");
                                                Scanner scannerEditReleaseYear = new Scanner(System.in);
                                                int optionEditReleaseYear = scannerEditReleaseYear.nextInt();
                                                ((Series) production).setReleaseYear(optionEditReleaseYear);
                                                System.out.println("Release year updated");
                                                break;
                                            case 3:
                                                System.out.println("Type new number of seasons: ");
                                                Scanner scannerEditNumberOfSeasons = new Scanner(System.in);
                                                int optionEditNumberOfSeasons = scannerEditNumberOfSeasons.nextInt();
                                                ((Series) production).setNumberOfSeasons(optionEditNumberOfSeasons);
                                                System.out.println("Number of seasons updated");
                                                break;
                                            case 4:
                                                System.out.println("Type new plot: ");
                                                Scanner scannerEditPlot = new Scanner(System.in);
                                                String optionEditPlot = scannerEditPlot.nextLine();
                                                production.setDescription(optionEditPlot);
                                                System.out.println("Plot updated");
                                                break;

                                            case 5:
                                                System.out.println("Type new genre: ");
                                                Scanner scannerEditGenre = new Scanner(System.in);
                                                String optionEditGenre = scannerEditGenre.nextLine();
                                                List<Genre> genres = new ArrayList<>();
                                                genres.add(Genre.valueOf(optionEditGenre));
                                                production.setGenres(genres);
                                                System.out.println("Genre updated");
                                                break;
                                            case 6:
                                                System.out.println("Type new director: ");
                                                Scanner scannerEditDirector = new Scanner(System.in);
                                                String optionEditDirector = scannerEditDirector.nextLine();
                                                List<String> directors = new ArrayList<>();
                                                directors.add(optionEditDirector);
                                                production.setDirectors(directors);
                                                System.out.println("Director updated");
                                                break;
                                                case 7:
                                                    System.out.println("Type new actor: ");
                                                    Scanner scannerEditActor = new Scanner(System.in);
                                                    String optionEditActor = scannerEditActor.nextLine();
                                                    List<String> actors = new ArrayList<>();
                                                    actors.add(optionEditActor);
                                                    production.setActors(actors);
                                                    System.out.println("Actor updated");
                                                    break;
                                                case 8:
                                                    System.out.println("Type season number: ");
                                                    Scanner scannerEditSeasonNumber = new Scanner(System.in);
                                                    int optionEditSeasonNumber = scannerEditSeasonNumber.nextInt();
                                                    System.out.println("Type episode number: ");
                                                    Scanner scannerEditEpisodeNumber = new Scanner(System.in);
                                                    int optionEditEpisodeNumber = scannerEditEpisodeNumber.nextInt();
                                                    System.out.println("What do you want to edit?");
                                                    System.out.println("1) Episode name");
                                                    System.out.println("2) Episode duration");
                                                    Scanner scannerEditEpisode = new Scanner(System.in);
                                                    int optionEditEpisode = scannerEditEpisode.nextInt();
                                                    switch (optionEditEpisode) {
                                                        case 1:
                                                            System.out.println("Type new episode name: ");
                                                            Scanner scannerEditEpisodeName = new Scanner(System.in);
                                                            String optionEditEpisodeName = scannerEditEpisodeName.nextLine();
                                                            ((Series) production).getSeasons().get("Season " + optionEditSeasonNumber).get(optionEditEpisodeNumber - 1).setName(optionEditEpisodeName);
                                                            System.out.println("Episode name updated");
                                                            break;
                                                        case 2:
                                                            System.out.println("Type new episode duration: ");
                                                            Scanner scannerEditEpisodeDuration = new Scanner(System.in);
                                                            String optionEditEpisodeDuration = scannerEditEpisodeDuration.nextLine();
                                                            ((Series) production).getSeasons().get("Season " + optionEditSeasonNumber).get(optionEditEpisodeNumber - 1).setDuration(optionEditEpisodeDuration);
                                                            System.out.println("Episode duration updated");
                                                            break;
                                                    }
                                        }
                                    }
                                }
                            }
                            case 14: {
                                System.out.println("Update actor details: ");
                                System.out.println("Type actor name: ");
                                for (Actor actor : actors) {
                                    if (user instanceof Staff<?> staffMember && staffMember.containsContribution(actor.getName()))
                                    {
                                        System.out.println(actor.getName());
                                    }
                                }
                                Scanner scannerActors = new Scanner(System.in);
                                String optionActors = scannerActors.nextLine();
                                for (Actor actor : actors) {
                                    if (actor.getName().equals(optionActors)) {
                                        System.out.println("What do you want to edit?");
                                        System.out.println("1) Name");
                                        System.out.println("2) Biography");
                                        System.out.println("3) Production");
                                        Scanner scannerEdit = new Scanner(System.in);
                                        int optionEdit = scannerEdit.nextInt();
                                        switch (optionEdit) {
                                            case 1:
                                                System.out.println("Type new name: ");
                                                Scanner scannerEditName = new Scanner(System.in);
                                                String optionEditName = scannerEditName.nextLine();
                                                actor.setName(optionEditName);
                                                System.out.println("Name updated");
                                                break;
                                            case 2:
                                                System.out.println("Type new biography: ");
                                                Scanner scannerEditBiography = new Scanner(System.in);
                                                String optionEditBiography = scannerEditBiography.nextLine();
                                                actor.setBiography(optionEditBiography);
                                                System.out.println("Biography updated");
                                                break;
                                            case 3:
                                                boolean addProduction = true;
                                                while (addProduction) {
                                                    System.out.println("Add production: ");
                                                    System.out.println("1) Movie/Series");
                                                    System.out.println("2) Exit");
                                                    Scanner scannerIMDBActorAddProduction = new Scanner(System.in);
                                                    int optionIMDBActorAddProduction = scannerIMDBActorAddProduction.nextInt();
                                                    switch (optionIMDBActorAddProduction) {
                                                        case 1:
                                                            System.out.println("Type production name: ");
                                                            Scanner scannerIMDBActorAddProductionName = new Scanner(System.in);
                                                            String optionIMDBActorAddProductionName = scannerIMDBActorAddProductionName.nextLine();
                                                            System.out.println("Type production type: ");
                                                            Scanner scannerIMDBActorAddProductionType = new Scanner(System.in);
                                                            String optionIMDBActorAddProductionType = scannerIMDBActorAddProductionType.nextLine();
                                                            actor.addProduction(optionIMDBActorAddProductionName, optionIMDBActorAddProductionType);
                                                            break;
                                                        case 2:
                                                            addProduction = false;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                }
                            }
                            case 15: {
                                System.out.println("Close the app or log out?");
                                System.out.println("1) Close");
                                System.out.println("2) Log out");
                                Scanner scannerExit = new Scanner(System.in);
                                int optionExit = scannerExit.nextInt();
                                switch (optionExit) {
                                    case 1:
                                        exit1 = true;
                                        authenticated = false;
                                        break;
                                    case 2:
                                        exit1 = true;
                                        break;
                                }
                            }
                        }
                } while (!exit1);
                break;

                case ADMIN:
                    boolean exit2;
                    do {
                        exit2 = false;
                        System.out.println("Username: " + user.getUsername());
                        System.out.println("Experience: ADMIN USER");
                        System.out.println("Choose an option: ");
                        System.out.println("1) View productions details");
                        System.out.println("2) View actor details");
                        System.out.println("3) View notifications");
                        System.out.println("4) Search actor/movie/series");
                        System.out.println("5) Add actor/movie/series to favorites");
                        System.out.println("6) Remove actor/movie/series from favorites");
                        System.out.println("7) View favorites");
                        System.out.println("8) Add/Delete actor/movie/series from IMDB");
                        System.out.println("9) Add/Delete user from IMDB");
                        System.out.println("10) Solve request");
                        System.out.println("11) Update movie details");
                        System.out.println("12) Update actor details");
                        System.out.println("13) Log out");
                        Scanner scannerAdmin = new Scanner(System.in);
                        int optionAdmin = scannerAdmin.nextInt();
                        switch (optionAdmin){
                            case 1: {
                                System.out.println("Filter by: ");
                                System.out.println("1) Genre");
                                System.out.println("2) Rating");
                                Scanner scanner1 = new Scanner(System.in);
                                int option1 = scanner1.nextInt();
                                switch (option1) {
                                    case 1: {
                                        System.out.println("Choose genre: ");
                                        System.out.println("1) Action");
                                        System.out.println("2) Adventure");
                                        System.out.println("3) Comedy");
                                        System.out.println("4) Drama");
                                        System.out.println("5) Horror");
                                        System.out.println("6) SF");
                                        System.out.println("7) Fantasy");
                                        System.out.println("8) Romance");
                                        System.out.println("9) Mystery");
                                        System.out.println("10) Thriller");
                                        System.out.println("11) Crime");
                                        System.out.println("12) Biography");
                                        System.out.println("13) War");
                                        System.out.println("14) Cooking");
                                        Scanner genre = new Scanner(System.in);
                                        int option2 = genre.nextInt();
                                        switch (option2) {
                                            case 1:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Action)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 2:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Adventure)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 3:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Comedy)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 4:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Drama)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 5:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Horror)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 6:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.SF)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 7:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Fantasy)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 8:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Romance)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 9:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Mystery)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 10:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Thriller)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 11:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Crime)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 12:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Biography)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 13:
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.War)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            case 14: {
                                                for (Production production : productions) {
                                                    if (production.getGenres().contains(Genre.Cooking)) {
                                                        production.displayInfo();
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        Scanner scanner2 = new Scanner(System.in);
                                        System.out.println("Choose rating: ");
                                        int option2 = scanner2.nextInt();
                                        for (Production production : productions) {
                                            if (production.getAverageRating() >= option2) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Choose actor: ");
                                for (Actor actor : actors) {
                                    System.out.println(actor.getName());
                                }
                                System.out.println("Type actor name: ");
                                Scanner scannerActors = new Scanner(System.in);
                                String optionActors = scannerActors.nextLine();
                                for (Actor actor : actors) {
                                    if (actor.getName().equals(optionActors)) {
                                        System.out.println("Name: " + actor.getName());
                                        System.out.println("Biography: " + actor.getBiography());
                                        System.out.println("Productions: ");
                                        actor.showProductions();
                                    }
                                }
                                break;
                            }
                            case 3: {
                                System.out.println("Notifications: ");
                                if (user.getNotifications().isEmpty()) {
                                    System.out.println("No notifications");
                                } else {
                                    System.out.println(user.getNotifications());
                                }
                                break;
                            }
                            case 4: {
                                System.out.println("Search by: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerSearch = new Scanner(System.in);
                                int optionSearch = scannerSearch.nextInt();
                                switch (optionSearch) {
                                    case 1:
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                System.out.println("Name: " + actor.getName());
                                                System.out.println("Biography: " + actor.getBiography());
                                                System.out.println("Productions: ");
                                                actor.showProductions();
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                production.displayInfo();
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 5: {
                                System.out.println("Add to favorites: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerAddToFavorites = new Scanner(System.in);
                                int optionAddToFavorites = scannerAddToFavorites.nextInt();
                                switch (optionAddToFavorites) {
                                    case 1:
                                        for (Actor actor : actors) {
                                            System.out.println(actor.getName());
                                        }
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                if (user.getFavorites().contains(actor.getName())) {
                                                    System.out.println("Actor already in favorites");
                                                } else {
                                                    user.addToFavorites(actor.getName());
                                                    System.out.println("Actor added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    System.out.println("Movie already in favorites");
                                                } else {
                                                    user.addToFavorites(production.getTitle());
                                                    System.out.println("Movie added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    System.out.println("Series already in favorites");
                                                } else {
                                                    user.addToFavorites(production.getTitle());
                                                    System.out.println("Series added to favorites");
                                                }
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 6: {
                                System.out.println("Remove from favorites: ");
                                System.out.println("1) Actor");
                                System.out.println("2) Movie");
                                System.out.println("3) Series");
                                Scanner scannerRemoveFromFavorites = new Scanner(System.in);
                                int optionRemoveFromFavorites = scannerRemoveFromFavorites.nextInt();
                                switch (optionRemoveFromFavorites) {
                                    case 1:
                                        for (Actor actor : actors) {
                                            System.out.println(actor.getName());
                                        }
                                        System.out.println("Type actor name: ");
                                        Scanner scannerActors = new Scanner(System.in);
                                        String optionActors = scannerActors.nextLine();
                                        for (Actor actor : actors) {
                                            if (actor.getName().equals(optionActors)) {
                                                if (user.getFavorites().contains(actor.getName())) {
                                                    user.removeFromFavorites(actor.getName());
                                                    System.out.println("Actor removed from favorites");
                                                } else {
                                                    System.out.println("Actor not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Type movie name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Movie) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerMovies = new Scanner(System.in);
                                        String optionMovies = scannerMovies.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionMovies)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    user.removeFromFavorites(production.getTitle());
                                                    System.out.println("Movie removed from favorites");
                                                } else {
                                                    System.out.println("Movie not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Type series name: ");
                                        for (Production production : productions) {
                                            if (production instanceof Series) {
                                                System.out.println(production.getTitle());
                                            }
                                        }
                                        Scanner scannerSeries = new Scanner(System.in);
                                        String optionSeries = scannerSeries.nextLine();
                                        for (Production production : productions) {
                                            if (production.getTitle().equals(optionSeries)) {
                                                if (user.getFavorites().contains(production.getTitle())) {
                                                    user.removeFromFavorites(production.getTitle());
                                                    System.out.println("Series removed from favorites");
                                                } else {
                                                    System.out.println("Series not in favorites");
                                                }
                                            }
                                        }
                                        break;
                                }
                                break;
                            }
                            case 7: {
                                System.out.println("Favorites: ");
                                if (user.getFavorites().isEmpty()) {
                                    System.out.println("No favorites");
                                } else {
                                    System.out.println(user.getFavorites());
                                }
                                break;
                            }
                            case 8: {
                                System.out.println("Add/Delete from IMDB: ");
                                System.out.println("1) Add/Remove actor");
                                System.out.println("2) Add/Remove movie");
                                System.out.println("3) Add/Remove series");
                                Scanner scannerIMDB = new Scanner(System.in);
                                int optionIMDB = scannerIMDB.nextInt();
                                switch (optionIMDB) {
                                    case 1: {
                                        System.out.println("Add/Remove actor: ");
                                        System.out.println("1) Add actor");
                                        System.out.println("2) Remove actor");
                                        Scanner scannerIMDBActor = new Scanner(System.in);
                                        int optionIMDBActor = scannerIMDBActor.nextInt();
                                        switch (optionIMDBActor) {
                                            case 1: {
                                                System.out.println("Type actor name: ");
                                                Scanner scannerIMDBActorAdd = new Scanner(System.in);
                                                String optionIMDBActorAdd = scannerIMDBActorAdd.nextLine();
                                                boolean actorFound = false;
                                                for (Actor actor : actors) {
                                                    if (actor.getName().equals(optionIMDBActorAdd)) {
                                                        actorFound = true;
                                                        System.out.println("Actor already in IMDB");
                                                        break;
                                                    }
                                                }
                                                if (!actorFound) {
                                                    System.out.println("Type actor biography: ");
                                                    Scanner scannerIMDBActorBiography = new Scanner(System.in);
                                                    String optionIMDBActorBiography = scannerIMDBActorBiography.nextLine();
                                                    Actor actor = new Actor(optionIMDBActorAdd, optionIMDBActorBiography);
                                                    boolean addProduction = true;
                                                    while (addProduction) {
                                                        System.out.println("Add production: ");
                                                        System.out.println("1) Movie/Series");
                                                        System.out.println("2) Exit");
                                                        Scanner scannerIMDBActorAddProduction = new Scanner(System.in);
                                                        int optionIMDBActorAddProduction = scannerIMDBActorAddProduction.nextInt();
                                                        switch (optionIMDBActorAddProduction) {
                                                            case 1:
                                                                System.out.println("Type production name: ");
                                                                Scanner scannerIMDBActorAddProductionName = new Scanner(System.in);
                                                                String optionIMDBActorAddProductionName = scannerIMDBActorAddProductionName.nextLine();
                                                                System.out.println("Type production type: ");
                                                                Scanner scannerIMDBActorAddProductionType = new Scanner(System.in);
                                                                String optionIMDBActorAddProductionType = scannerIMDBActorAddProductionType.nextLine();
                                                                actor.addProduction(optionIMDBActorAddProductionName, optionIMDBActorAddProductionType);
                                                                break;
                                                            case 2:
                                                                addProduction = false;
                                                                break;
                                                        }
                                                    }
                                                    actors.add(actor);
                                                    ((Admin)user).addContribution(optionIMDBActorAdd);
                                                    System.out.println("Actor added");
                                                }
                                                break;
                                            }
                                            case 2:
                                                System.out.println("Type actor name: ");
                                                Scanner scannerIMDBActorRemove = new Scanner(System.in);
                                                String optionIMDBActorRemove = scannerIMDBActorRemove.nextLine();
                                                boolean actorFound = false;
                                                for (Actor actor : actors) {
                                                    if (actor.getName().equals(optionIMDBActorRemove)) {
                                                        IMDB.getInstance().actors.remove(actor);
                                                        actorFound = true;
                                                        System.out.println("Actor removed");
                                                        break;
                                                    }
                                                }
                                                if (!actorFound) {
                                                    System.out.println("Actor not found");
                                                }
                                                break;
                                        }
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Add/Remove movie: ");
                                        System.out.println("1) Add movie");
                                        System.out.println("2) Remove movie");
                                        Scanner scannerIMDBMovie = new Scanner(System.in);
                                        int optionIMDBMovie = scannerIMDBMovie.nextInt();
                                        switch (optionIMDBMovie) {
                                            case 1:
                                                System.out.println("Type movie name: ");
                                                Scanner scannerIMDBMovieAdd = new Scanner(System.in);
                                                String optionIMDBMovieAdd = scannerIMDBMovieAdd.nextLine();
                                                boolean movieFound = false;
                                                for (Production production : productions) {
                                                    if (production.getTitle().equals(optionIMDBMovieAdd)) {
                                                        movieFound = true;
                                                        System.out.println("Movie already in IMDB");
                                                        break;
                                                    }
                                                }
                                                if (!movieFound) {
                                                    System.out.println("Type movie release year: ");
                                                    Scanner scannerIMDBMovieReleaseYear = new Scanner(System.in);
                                                    int optionIMDBMovieReleaseYear = scannerIMDBMovieReleaseYear.nextInt();
                                                    System.out.println("Type movie duration: ");
                                                    Scanner scannerIMDBMovieDuration = new Scanner(System.in);
                                                    String optionIMDBMovieDuration = scannerIMDBMovieDuration.nextLine();
                                                    System.out.println("Type movie plot: ");
                                                    Scanner scannerIMDBMoviePlot = new Scanner(System.in);
                                                    String optionIMDBMoviePlot = scannerIMDBMoviePlot.nextLine();
                                                    System.out.println("Type movie average rating: ");
                                                    Scanner scannerIMDBMovieAverageRating = new Scanner(System.in);
                                                    double optionIMDBMovieAverageRating = scannerIMDBMovieAverageRating.nextDouble();
                                                    System.out.println("Type movie genre: ");
                                                    Scanner scannerIMDBMovieGenre = new Scanner(System.in);
                                                    String optionIMDBMovieGenre = scannerIMDBMovieGenre.nextLine();
                                                    List<Genre> genres = new ArrayList<>();
                                                    genres.add(Genre.valueOf(optionIMDBMovieGenre));
                                                    System.out.println("Type movie director: ");
                                                    Scanner scannerIMDBMovieDirector = new Scanner(System.in);
                                                    String optionIMDBMovieDirector = scannerIMDBMovieDirector.nextLine();
                                                    List<String> directors = new ArrayList<>();
                                                    directors.add(optionIMDBMovieDirector);
                                                    System.out.println("Type movie actor: ");
                                                    Scanner scannerIMDBMovieActor = new Scanner(System.in);
                                                    String optionIMDBMovieActor = scannerIMDBMovieActor.nextLine();
                                                    List<String> actors = new ArrayList<>();
                                                    actors.add(optionIMDBMovieActor);
                                                    Movie movie = new Movie(optionIMDBMovieAdd, directors, actors, genres, null, optionIMDBMoviePlot, optionIMDBMovieDuration, optionIMDBMovieReleaseYear);
                                                    productions.add(movie);
                                                    ((Admin)user).addContribution(optionIMDBMovieAdd);
                                                    System.out.println("Movie added");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Type movie name: ");
                                                Scanner scannerIMDBMovieRemove = new Scanner(System.in);
                                                String optionIMDBMovieRemove = scannerIMDBMovieRemove.nextLine();
                                                boolean movieFound1 = false;
                                                for (Production production : productions){
                                                    if (production.getTitle().equals(optionIMDBMovieRemove)) {
                                                        IMDB.getInstance().productions.remove(production);
                                                        movieFound = true;
                                                        System.out.println("Movie removed");
                                                        break;
                                                    }
                                                }
                                                if (!movieFound1) {
                                                    System.out.println("Movie not found");
                                                }
                                                break;
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Add/Remove series: ");
                                        System.out.println("1) Add series");
                                        System.out.println("2) Remove series");
                                        Scanner scannerIMDBSeries = new Scanner(System.in);
                                        int optionIMDBSeries = scannerIMDBSeries.nextInt();
                                        switch (optionIMDBSeries) {
                                            case 1:
                                                System.out.println("Type series name: ");
                                                Scanner scannerIMDBSeriesAdd = new Scanner(System.in);
                                                String optionIMDBSeriesAdd = scannerIMDBSeriesAdd.nextLine();
                                                boolean seriesFound = false;
                                                for (Production production : productions) {
                                                    if (production.getTitle().equals(optionIMDBSeriesAdd)) {
                                                        seriesFound = true;
                                                        System.out.println("Series already in IMDB");
                                                        break;
                                                    }
                                                }
                                                if (!seriesFound) {
                                                    System.out.println("Type series release year: ");
                                                    Scanner scannerIMDBSeriesReleaseYear = new Scanner(System.in);
                                                    int optionIMDBSeriesReleaseYear = scannerIMDBSeriesReleaseYear.nextInt();
                                                    System.out.println("Type series number of seasons: ");
                                                    Scanner scannerIMDBSeriesNumberOfSeasons = new Scanner(System.in);
                                                    int optionIMDBSeriesNumberOfSeasons = scannerIMDBSeriesNumberOfSeasons.nextInt();
                                                    Map<String, List<Episode>> seasons = new HashMap<>();
                                                    for (int i = 1; i <= optionIMDBSeriesNumberOfSeasons; i++) {
                                                        String seasonKey = "Season " + i;
                                                        System.out.println("Type number of episodes for season " + i + ": ");
                                                        Scanner scannerIMDBSeriesNumberOfEpisodes = new Scanner(System.in);
                                                        int optionIMDBSeriesNumberOfEpisodes = scannerIMDBSeriesNumberOfEpisodes.nextInt();
                                                        List<Episode> episodes = new ArrayList<>();
                                                        for (int j = 1; j <= optionIMDBSeriesNumberOfEpisodes; j++) {
                                                            System.out.println("Type episode name: ");
                                                            Scanner scannerIMDBSeriesEpisodeName = new Scanner(System.in);
                                                            String optionIMDBSeriesEpisodeName = scannerIMDBSeriesEpisodeName.nextLine();
                                                            System.out.println("Type episode duration: ");
                                                            Scanner scannerIMDBSeriesEpisodeDuration = new Scanner(System.in);
                                                            String optionIMDBSeriesEpisodeDuration = scannerIMDBSeriesEpisodeDuration.nextLine();
                                                            episodes.add(new Episode(optionIMDBSeriesEpisodeName, optionIMDBSeriesEpisodeDuration));
                                                        }
                                                        seasons.put(seasonKey, episodes);
                                                    }
                                                    System.out.println("Type series plot: ");
                                                    Scanner scannerIMDBSeriesPlot = new Scanner(System.in);
                                                    String optionIMDBSeriesPlot = scannerIMDBSeriesPlot.nextLine();
                                                    System.out.println("Type series average rating: ");
                                                    Scanner scannerIMDBSeries1 = new Scanner(System.in);
                                                    double optionIMDBSeriesAverageRating = scannerIMDBSeries.nextDouble();
                                                    System.out.println("Type series genre: ");
                                                    Scanner scannerIMDBSeriesGenre = new Scanner(System.in);
                                                    String optionIMDBSeriesGenre = scannerIMDBSeriesGenre.nextLine();
                                                    List<Genre> genres = new ArrayList<>();
                                                    genres.add(Genre.valueOf(optionIMDBSeriesGenre));
                                                    System.out.println("Type series director: ");
                                                    Scanner scannerIMDBSeriesDirector = new Scanner(System.in);
                                                    String optionIMDBSeriesDirector = scannerIMDBSeriesDirector.nextLine();
                                                    List<String> directors = new ArrayList<>();
                                                    directors.add(optionIMDBSeriesDirector);
                                                    System.out.println("Type series actor: ");
                                                    Scanner scannerIMDBSeriesActor = new Scanner(System.in);
                                                    String optionIMDBSeriesActor = scannerIMDBSeriesActor.nextLine();
                                                    List<String> actors = new ArrayList<>();
                                                    actors.add(optionIMDBSeriesActor);
                                                    Series series = new Series(optionIMDBSeriesAdd, directors, actors, genres, null, optionIMDBSeriesPlot, optionIMDBSeriesReleaseYear, optionIMDBSeriesNumberOfSeasons, seasons);
                                                    productions.add(series);
                                                    ((Admin)user).addContribution(optionIMDBSeriesAdd);
                                                    System.out.println("Series added");
                                                }
break;
                                            case 2:
                                        }
                                        break;

                                    }
                                }
                            }
                            case 9:{
                                System.out.println("Add/Delete user from IMDB: ");
                                System.out.println("1) Add user");
                                System.out.println("2) Delete user");
                                Scanner scannerIMDBUser = new Scanner(System.in);
                                int optionIMDBUser = scannerIMDBUser.nextInt();
                                switch (optionIMDBUser){
                                    case 1:
                                    {
                                        System.out.println("Type name: ");
                                        Scanner scannerIMDBUserAddName = new Scanner(System.in);
                                        String optionIMDBUserAddName = scannerIMDBUserAddName.nextLine();
                                        System.out.println("Type email: ");
                                        Scanner scannerIMDBUserAddEmail = new Scanner(System.in);
                                        String optionIMDBUserAddEmail = scannerIMDBUserAddEmail.nextLine();
                                        System.out.println("Type account type (REGULAR / CONTRIBUTOR / ADMIN): ");
                                        Scanner scannerIMDBUserAddAccountType = new Scanner(System.in);
                                        String optionIMDBUserAddAccountType = scannerIMDBUserAddAccountType.nextLine();
                                        String generatedUsername = User.generateUsername(optionIMDBUserAddName);
                                        String generatedPassword = User.generatePassword();
                                        System.out.println("Username: " + generatedUsername);
                                        System.out.println("Password: " + generatedPassword);
                                        Credentials credentials = new Credentials(optionIMDBUserAddEmail, generatedPassword);
                                        System.out.println("Type country: ");
                                        Scanner scannerIMDBUserAddCountry = new Scanner(System.in);
                                        String optionIMDBUserAddCountry = scannerIMDBUserAddCountry.nextLine();
                                        System.out.println("Type age: ");
                                        Scanner scannerIMDBUserAddAge = new Scanner(System.in);
                                        int optionIMDBUserAddAge = scannerIMDBUserAddAge.nextInt();
                                        System.out.println("Type gender: ");
                                        Scanner scannerIMDBUserAddGender = new Scanner(System.in);
                                        char optionIMDBUserAddGender = scannerIMDBUserAddGender.next().charAt(0);
                                        System.out.println("Type experience: ");
                                        Scanner scannerIMDBUserAddExperience = new Scanner(System.in);
                                        int optionIMDBUserAddExperience = scannerIMDBUserAddExperience.nextInt();
                                        System.out.println("Type date of birth: ");
                                        Scanner scannerIMDBUserAddDateOfBirth = new Scanner(System.in);
                                        String optionIMDBUserAddDateOfBirth = scannerIMDBUserAddDateOfBirth.nextLine();
                                        User.Information information = new User.Information.Builder(credentials).withName(optionIMDBUserAddName).withCountry(optionIMDBUserAddCountry).withAge(optionIMDBUserAddAge).withGender(optionIMDBUserAddGender).withDateOfBirth(LocalDate.parse(optionIMDBUserAddDateOfBirth)).build();
                                        User newUser = UserFactory.createUser(generatedUsername,information, AccountType.valueOf(optionIMDBUserAddAccountType), optionIMDBUserAddExperience,null,null,null,null);
                                        users.add(newUser);
                                        System.out.println("User added");
                                        break;
                                    }
                                    case 2:
                                    {
                                        System.out.println("Type username / mail: ");
                                        Scanner scannerIMDBUserDelete = new Scanner(System.in);
                                        String optionIMDBUserDelete = scannerIMDBUserDelete.nextLine();
                                        boolean userFound = false;
                                        for (User user1 : users) {
                                            if (user1.getUsername().equals(optionIMDBUserDelete) || user1.getInformation().getCredentials().getEmail().equals(optionIMDBUserDelete)) {
                                                userFound = true;
                                                if (user1.getAccountType().equals(AccountType.ADMIN)) {
                                                    System.out.println("You can't delete an admin");
                                                } else if (user1.getAccountType().equals(AccountType.CONTRIBUTOR)){
                                                    transferContributionsToAdmins(user1);
                                                    IMDB.getInstance().removeUser(user1);
                                                    System.out.println("User deleted");
                                                }else{
                                                    for (Request request : requests) {
                                                        if (request.getCreatedByUsername().equals(user1.getUsername())) {
                                                            if (request.getTo().equals("ADMIN")) {
                                                                RequestsHolder.removeRequest(request);
                                                            } else {
                                                                String getTo = request.getTo();
                                                                for (User user2 : users) {
                                                                    if (user2.getUsername().equals(getTo)) {
                                                                        user2.addNotification("Your request has been removed");
                                                                    }
                                                                }
                                                                requests.remove(request);
                                                            }
                                                        }
                                                    }
                                                    IMDB.getInstance().removeUser(user1);
                                                    System.out.println("User deleted");
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                            case 10: {
                                if (RequestsHolder.getRequests().isEmpty())
                                {
                                    System.out.println("No requests");
                                    break;
                                }
                                int index = 0;
                                for (Request request : RequestsHolder.getRequests()){
                                    index++;
                                    System.out.println(index + ") " + request);
                                }
                                System.out.println("Type request id: ");
                                Scanner scannerRequest = new Scanner(System.in);
                                int optionRequest = scannerRequest.nextInt();
                                System.out.println("1) Accept");
                                System.out.println("2) Decline");
                                System.out.println("3) Exit");
                                Scanner scannerRequestOption = new Scanner(System.in);
                                int optionRequestOption = scannerRequestOption.nextInt();
                                int i = 0;
                                switch (optionRequestOption){
                                    case 1: {
                                        for (Request request1 : RequestsHolder.getRequests()) {
                                            if (request1.getTo().equals("ADMIN")) {
                                                i++;
                                                if (i == optionRequest) {
                                                    RequestsHolder.removeRequest(request1);
                                                    String createdBy = request1.getCreatedByUsername();
                                                    for (User user1 : users) {
                                                        if (user1.getUsername().equals(createdBy)) {
                                                            user1.addNotification("Your request has been accepted");
                                                            ExperienceStrategy experienceStrategy = new RequestsExperienceStrategy();
                                                            user.updateExperience(experienceStrategy.calculateExperience());
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }
                                        case 2:
                                        {
                                            for (Request request : requests) {
                                                if (request.getTo().equals(user.getUsername())) {
                                                    i++;
                                                    if (i == optionRequest) {
                                                        if (request.getTo().equals("ADMIN")) {
                                                            RequestsHolder.removeRequest(request);
                                                        }else {
                                                            String getTo = request.getTo();
                                                            for (User user1 : users) {
                                                                if (user1.getUsername().equals(getTo)) {
                                                                    user1.addNotification("Your request has been removed");
                                                                }
                                                            }
                                                        }
                                                        requests.remove(request);
                                                        System.out.println("Request removed");
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        case 3:
                                        {
                                            break;
                                        }
                                }
                                break;
                            }
                            case 11: {
                                System.out.println("Update series details: ");
                                System.out.println("Type series name: ");
                                for (Production production : productions) {
                                    if (production instanceof Series) {
                                        if (user instanceof Staff<?> staffMember && staffMember.containsContribution(production.getTitle()) || Admin.containsAdminProductionSystem(production.getTitle()) ) {
                                            System.out.println(production.getTitle());
                                        }
                                    }
                                }
                                Scanner scannerSeries = new Scanner(System.in);
                                String optionSeries = scannerSeries.nextLine();
                                for (Production production : productions) {
                                    if (production.getTitle().equals(optionSeries)) {
                                        System.out.println("What do you want to edit?");
                                        System.out.println("1) Title");
                                        System.out.println("2) Release year");
                                        System.out.println("3) Number of seasons");
                                        System.out.println("4) Plot");
                                        System.out.println("5) Genre");
                                        System.out.println("6) Director");
                                        System.out.println("7) Actor");
                                        System.out.println("8) Episode");
                                        Scanner scannerEdit = new Scanner(System.in);
                                        int optionEdit = scannerEdit.nextInt();
                                        switch (optionEdit) {
                                            case 1:
                                                System.out.println("Type new title: ");
                                                Scanner scannerEditTitle = new Scanner(System.in);
                                                String optionEditTitle = scannerEditTitle.nextLine();
                                                production.setTitle(optionEditTitle);
                                                System.out.println("Title updated");
                                                break;
                                            case 2:
                                                System.out.println("Type new release year: ");
                                                Scanner scannerEditReleaseYear = new Scanner(System.in);
                                                int optionEditReleaseYear = scannerEditReleaseYear.nextInt();
                                                ((Series) production).setReleaseYear(optionEditReleaseYear);
                                                System.out.println("Release year updated");
                                                break;
                                            case 3:
                                                System.out.println("Type new number of seasons: ");
                                                Scanner scannerEditNumberOfSeasons = new Scanner(System.in);
                                                int optionEditNumberOfSeasons = scannerEditNumberOfSeasons.nextInt();
                                                ((Series) production).setNumberOfSeasons(optionEditNumberOfSeasons);
                                                System.out.println("Number of seasons updated");
                                                break;
                                            case 4:
                                                System.out.println("Type new plot: ");
                                                Scanner scannerEditPlot = new Scanner(System.in);
                                                String optionEditPlot = scannerEditPlot.nextLine();
                                                production.setDescription(optionEditPlot);
                                                System.out.println("Plot updated");
                                                break;

                                            case 5:
                                                System.out.println("Type new genre: ");
                                                Scanner scannerEditGenre = new Scanner(System.in);
                                                String optionEditGenre = scannerEditGenre.nextLine();
                                                List<Genre> genres = new ArrayList<>();
                                                genres.add(Genre.valueOf(optionEditGenre));
                                                production.setGenres(genres);
                                                System.out.println("Genre updated");
                                                break;
                                            case 6:
                                                System.out.println("Type new director: ");
                                                Scanner scannerEditDirector = new Scanner(System.in);
                                                String optionEditDirector = scannerEditDirector.nextLine();
                                                List<String> directors = new ArrayList<>();
                                                directors.add(optionEditDirector);
                                                production.setDirectors(directors);
                                                System.out.println("Director updated");
                                                break;
                                            case 7:
                                                System.out.println("Type new actor: ");
                                                Scanner scannerEditActor = new Scanner(System.in);
                                                String optionEditActor = scannerEditActor.nextLine();
                                                List<String> actors = new ArrayList<>();
                                                actors.add(optionEditActor);
                                                production.setActors(actors);
                                                System.out.println("Actor updated");
                                                break;
                                            case 8:
                                                System.out.println("Type season number: ");
                                                Scanner scannerEditSeasonNumber = new Scanner(System.in);
                                                int optionEditSeasonNumber = scannerEditSeasonNumber.nextInt();
                                                System.out.println("Type episode number: ");
                                                Scanner scannerEditEpisodeNumber = new Scanner(System.in);
                                                int optionEditEpisodeNumber = scannerEditEpisodeNumber.nextInt();
                                                System.out.println("What do you want to edit?");
                                                System.out.println("1) Episode name");
                                                System.out.println("2) Episode duration");
                                                Scanner scannerEditEpisode = new Scanner(System.in);
                                                int optionEditEpisode = scannerEditEpisode.nextInt();
                                                switch (optionEditEpisode) {
                                                    case 1:
                                                        System.out.println("Type new episode name: ");
                                                        Scanner scannerEditEpisodeName = new Scanner(System.in);
                                                        String optionEditEpisodeName = scannerEditEpisodeName.nextLine();
                                                        ((Series) production).getSeasons().get("Season " + optionEditSeasonNumber).get(optionEditEpisodeNumber - 1).setName(optionEditEpisodeName);
                                                        System.out.println("Episode name updated");
                                                        break;
                                                    case 2:
                                                        System.out.println("Type new episode duration: ");
                                                        Scanner scannerEditEpisodeDuration = new Scanner(System.in);
                                                        String optionEditEpisodeDuration = scannerEditEpisodeDuration.nextLine();
                                                        ((Series) production).getSeasons().get("Season " + optionEditSeasonNumber).get(optionEditEpisodeNumber - 1).setDuration(optionEditEpisodeDuration);
                                                        System.out.println("Episode duration updated");
                                                        break;
                                                }
                                        }
                                    }
                                }
                            }
                            case 12: {
                                System.out.println("Update actor details: ");
                                System.out.println("Type actor name: ");
                                for (Actor actor : actors) {
                                    System.out.println(actor.getName());
                                }
                                Scanner scannerActors = new Scanner(System.in);
                                String optionActors = scannerActors.nextLine();
                                for (Actor actor : actors) {
                                    if (actor.getName().equals(optionActors)) {
                                        System.out.println("What do you want to edit?");
                                        System.out.println("1) Name");
                                        System.out.println("2) Biography");
                                        System.out.println("3) Production");
                                        Scanner scannerEdit = new Scanner(System.in);
                                        int optionEdit = scannerEdit.nextInt();
                                        switch (optionEdit) {
                                            case 1:
                                                System.out.println("Type new name: ");
                                                Scanner scannerEditName = new Scanner(System.in);
                                                String optionEditName = scannerEditName.nextLine();
                                                actor.setName(optionEditName);
                                                System.out.println("Name updated");
                                                break;
                                            case 2:
                                                System.out.println("Type new biography: ");
                                                Scanner scannerEditBiography = new Scanner(System.in);
                                                String optionEditBiography = scannerEditBiography.nextLine();
                                                actor.setBiography(optionEditBiography);
                                                System.out.println("Biography updated");
                                                break;
                                            case 3:
                                                boolean addProduction = true;
                                                while (addProduction) {
                                                    System.out.println("Add production: ");
                                                    System.out.println("1) Movie/Series");
                                                    System.out.println("2) Exit");
                                                    Scanner scannerIMDBActorAddProduction = new Scanner(System.in);
                                                    int optionIMDBActorAddProduction = scannerIMDBActorAddProduction.nextInt();
                                                    switch (optionIMDBActorAddProduction) {
                                                        case 1:
                                                            System.out.println("Type production name: ");
                                                            Scanner scannerIMDBActorAddProductionName = new Scanner(System.in);
                                                            String optionIMDBActorAddProductionName = scannerIMDBActorAddProductionName.nextLine();
                                                            System.out.println("Type production type: ");
                                                            Scanner scannerIMDBActorAddProductionType = new Scanner(System.in);
                                                            String optionIMDBActorAddProductionType = scannerIMDBActorAddProductionType.nextLine();
                                                            actor.addProduction(optionIMDBActorAddProductionName, optionIMDBActorAddProductionType);
                                                            break;
                                                        case 2:
                                                            addProduction = false;
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                }
                            }
                            case 13: {
                                System.out.println("Close the app or log out?");
                                System.out.println("1) Close");
                                System.out.println("2) Log out");
                                Scanner scannerExit = new Scanner(System.in);
                                int optionExit = scannerExit.nextInt();
                                switch (optionExit) {
                                    case 1:
                                        exit2 = true;
                                        authenticated = false;
                                        break;
                                    case 2:
                                        exit2 = true;
                                        break;
                                }
                            }
                        }
                    } while (!exit2);
            }
        } while (authenticated);
    }

    private void removeUser(User user1) {
        if(IMDB.getInstance().users.contains(user1) && user1 != null){
            IMDB.getInstance().users.remove(user1);
        }
    }

    private void removeActor(Actor actor) {
        if(IMDB.getInstance().actors.contains(actor) && actor != null){
            IMDB.getInstance().actors.remove(actor);
        }
    }

    private void removeProduction(Production production) {
        if(IMDB.getInstance().productions.contains(production) && production != null){
            IMDB.getInstance().productions.remove(production);
        }
    }

    public List<Actor> readActorsData(String filePath){
            List<Actor> actors = new ArrayList<>();
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader(filePath)){
                Object obj = jsonParser.parse(reader);
                JSONArray actorList = (JSONArray) obj;

                for (Object actorObj : actorList){
                    JSONObject actorJSON = (JSONObject) actorObj;
                    String name = (String) actorJSON.get("name");
                    String biography = (String) actorJSON.get("biography");
                    Actor actor = new Actor(name, biography);


                    JSONArray performances = (JSONArray) actorJSON.get("performances");
                    for (Object performanceObj : performances){
                        JSONObject performanceJSON = (JSONObject) performanceObj;
                        String productionName = (String) performanceJSON.get("title");
                        String productionType = (String) performanceJSON.get("type");
                        actor.addProduction(productionName, productionType);
                    }
                    actors.add(actor);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e){
                e.printStackTrace();
            }
            return actors;
        }
        public List<Production> readProductionsData(String filePath){
        List<Production> productions = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)){
            Object obj = jsonParser.parse(reader);
            JSONArray productionList = (JSONArray) obj;

            for (Object productionObj : productionList){
                JSONObject productionJSON = (JSONObject) productionObj;
                String title = (String) productionJSON.get("title");
                String type = (String) productionJSON.get("type");
                List<String> directors = new ArrayList<>();
                JSONArray directorsJSON = (JSONArray) productionJSON.get("directors");
                for (Object directorObj : directorsJSON){
                    String director = (String) directorObj;
                    directors.add(director);
                }
                List<String> actors = new ArrayList<>();
                JSONArray actorsJSON = (JSONArray) productionJSON.get("actors");
                for (Object actorObj : actorsJSON){
                    String actor = (String) actorObj;
                    actors.add(actor);
                }
                List<Genre> genres = new ArrayList<>();
                JSONArray genresJSON = (JSONArray) productionJSON.get("genres");
                for (Object genreObj : genresJSON){
                    String genre = (String) genreObj;
                    genres.add(Genre.valueOf(genre));
                }
                List<Rating> ratings = new ArrayList<>();
                JSONArray ratingsJSON = (JSONArray) productionJSON.get("ratings");
                for (Object ratingObj : ratingsJSON){
                    JSONObject ratingJSON = (JSONObject) ratingObj;
                    String source = (String) ratingJSON.get("username");
                    long value = (long) ratingJSON.get("rating");
                    String comment = (String) ratingJSON.get("comment");
                    Rating rating = new Rating(source, value, comment);
                    ratings.add(rating);
                }
                String plot = (String) productionJSON.get("plot");
                Double averageRating = (Double) productionJSON.get("averageRating");
                if (type.equals("Movie")){
                    Object releaseYearObj = productionJSON.get("releaseYear");
                    int releaseYear = releaseYearObj != null ? (int) (long) releaseYearObj : -1;
                    String duration = (String) productionJSON.getOrDefault("duration", "Unknown");
                    Movie movie = new Movie(title, directors, actors, genres, ratings, plot, duration, (int) releaseYear);
                    productions.add(movie);
                }else if (type.equals("Series")) {
                    int releaseYear = (int) (long) productionJSON.get("releaseYear");
                    int numberOfSeasons = (int) (long) productionJSON.get("numSeasons");
                    Map<String, List<Episode>> seasons = new HashMap<>();

                    JSONObject seasonsJSON = (JSONObject) productionJSON.get("seasons");
                    for (int i = 1; i <= numberOfSeasons; i++) {
                        String seasonKey = "Season " + i;
                        JSONArray seasonEpisodesJSON = (JSONArray) seasonsJSON.get(seasonKey);
                        List<Episode> episodes = new ArrayList<>();

                        for (Object episodeObj : seasonEpisodesJSON) {
                            JSONObject episodeJSON = (JSONObject) episodeObj;
                            String episodeName = (String) episodeJSON.get("episodeName");
                            String duration = (String) episodeJSON.get("duration");
                            episodes.add(new Episode(episodeName, duration));
                        }
                        seasons.put(seasonKey, episodes);
                    }
                    Series series = new Series(title, directors, actors, genres, ratings, plot, releaseYear, numberOfSeasons, seasons);
                    productions.add(series);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }   catch (ParseException e) {
            e.printStackTrace();
        }
            return productions;
        }
        public List<User> readUserData(String filePath) {
        List<User> users = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)){
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;

            for (Object userObj : userList){
                JSONObject userJSON = (JSONObject) userObj;
                String username = (String) userJSON.get("username");
                Object experienceObj = userJSON.get("experience");
                int experience = experienceObj != null ? Integer.parseInt(experienceObj.toString()) : 0;
                JSONObject informationJSON = (JSONObject) userJSON.get("information");
                String userType = (String) userJSON.get("userType");
                AccountType accountType = AccountType.valueOf(userType.toUpperCase());
                JSONObject credentialsJSON = (JSONObject) informationJSON.get("credentials");
                String email = (String) credentialsJSON.get("email");
                String password = (String) credentialsJSON.get("password");
                Credentials credentials = new Credentials(email, password);
                User.Information info = new User.Information.Builder(credentials)
                        .withName((String) informationJSON.get("name"))
                        .withCountry((String) informationJSON.get("country"))
                        .withAge(((Long) informationJSON.get("age")).intValue())
                        .withGender(((String) informationJSON.get("gender")).charAt(0))
                        .withDateOfBirth(LocalDate.parse((String) informationJSON.get("birthDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                        .build();
                SortedSet<String> favorites = new TreeSet<>();
                ArrayList<String> notifications = new ArrayList<>();
                SortedSet<String> contributions = new TreeSet<>();
                for (Object keyObj : userJSON.keySet()){
                    String key = (String) keyObj;
                    if (key.startsWith("favorite")){
                        JSONArray favoritesJSON = (JSONArray) userJSON.get(key);
                        for (Object favoriteObj : favoritesJSON){
                            favorites.add((String) favoriteObj);
                        }
                    }
                }
                JSONArray notificationsJSON = (JSONArray) userJSON.get("notifications");
                if (notificationsJSON != null) {
                    for (Object notificationObj : notificationsJSON) {
                        notifications.add((String) notificationObj);
                    }
                }
                if (accountType == AccountType.ADMIN || accountType == AccountType.CONTRIBUTOR){
                    for (Object object : userJSON.keySet()) {
                        String key = (String) object;
                        if (key.endsWith("Contribution")) {
                            JSONArray contributionsJSON = (JSONArray) userJSON.get(key);
                            for (Object contributionObj : contributionsJSON) {
                                if (accountType == AccountType.ADMIN) {
                                    for (Production production : productions) {
                                        if (production.getTitle().equals(contributionObj)) {
                                            Admin.addAdminProductionSystem(production);
                                        }
                                    }
                                }
                                contributions.add((String) contributionObj);
                            }
                        }
                    }
                }
                User user = UserFactory.createUser(username,info, accountType, experience, notifications, favorites, null, contributions);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }
        return users;
    }

        public List<Request> readRequestData(String filePath) {
            List<Request> requests = new ArrayList<>();
            JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader(filePath)) {
                Object obj = jsonParser.parse(reader);
                JSONArray requestList = (JSONArray) obj;

                for (Object requestObj : requestList) {
                    JSONObject requestJSON = (JSONObject) requestObj;
                    String type = (String) requestJSON.get("type");
                    LocalDateTime timestamp = LocalDateTime.parse((String) requestJSON.get("createdDate"), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    String username = (String) requestJSON.get("username");
                    String description = (String) requestJSON.get("description");
                    String to = (String) requestJSON.get("to");
                    Request request = new Request();
                    request.setRequestType(RequestTypes.valueOf(type.toUpperCase()));
                    request.setCreationDate(timestamp);
                    request.setCreatedByUsername(username);
                    request.setDescription(description);
                    if (type.equals("ACTOR_ISSUE")){
                        request.setActorName((String) requestJSON.get("actorName"));
                        request.setTo(to);
                    }else if (type.equals("MOVIE_ISSUE")){
                        request.setMovieTitle((String) requestJSON.get("movieTitle"));
                        request.setTo(to);
                    }else if (type.equals("OTHERS")){

                        request.setTo("ADMIN");
                    } else if (type.equals("DELETE_ACCOUNT")) {
                        request.setTo("ADMIN");
                    }
                    requests.add(request);
                    if (request.getTo().equals("ADMIN")){
                        RequestsHolder.addRequest(request);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e){
                e.printStackTrace();
            }
            return requests;
        }

        public User authenticateUser(){
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Enter email: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                for (User user : users){
                    if (user.getInformation().getCredentials().getEmail().equals(username) && user.getInformation().getCredentials().getPassword().equals(password)){
                        return user;
                    }
                }
                System.out.println("Invalid credentials,please try again");
            }
        }

        public void processActorsAndProductions() {
            for (Production production : productions) {
                boolean ok = false;
                List<String> actorNamesInProduction = production.getActors();
                for (String actorName : actorNamesInProduction) {
                    for (Actor actor : actors) {
                        if (actor.getName().equals(actorName)) {
                            ok = true;
                        }
                    }
                    if (!ok)
                    {
                        Actor actor = new Actor(actorName, "Unknown");
                        if (production instanceof Movie) {
                            actor.addProduction(production.getTitle(), "Movie");
                        } else if (production instanceof Series) {
                            actor.addProduction(production.getTitle(), "Series");
                        }
                        Admin.addAdminActorSystem(actor);
                        actors.add(actor);
                    }
                }
            }
        }

        public void transferContributionsToAdmins(User user){
        if (user instanceof Contributor) {
            Contributor contributor = (Contributor) user;
            for (Object production : contributor.getContributions()) {
                if (production instanceof Movie || production instanceof Series) {
                    Admin.addAdminProductionSystem((Production) production);
                } else if (production instanceof Actor) {
                    Admin.addAdminActorSystem((Actor) production);
                }
            }
            for (Production production : productions) {
                if (production.getRatings().contains(user.getUsername())) {
                    production.getRatings().remove(user.getUsername());
                }
            }
            for (Request request : requests) {
                if (request.getCreatedByUsername().equals(user.getUsername())) {
                    requests.remove(request);
                }
            }
        }
    }
    public static void main(String[] args) {
        IMDB imdb = IMDB.getInstance();
        imdb.run();
        }
    }
