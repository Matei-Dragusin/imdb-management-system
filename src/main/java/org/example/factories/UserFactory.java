package org.example;

import java.util.List;
import java.util.SortedSet;

public class UserFactory {

    public static <T> User createUser(String username,User.Information information, AccountType type, int experience, List<String> notifications, SortedSet<String> favorites, List<Request> assignedRequests, SortedSet<T> addedItems) {
        switch (type) {
            case REGULAR:
                return new Regular(username, information, type, experience, notifications, favorites);
            case CONTRIBUTOR:
                return new Contributor(username, information, type, experience, notifications, favorites, assignedRequests, addedItems);
            case ADMIN:
                return new Admin(username, information, type, experience, notifications, favorites, assignedRequests, addedItems);
            default:
                throw new IllegalArgumentException("Invalid account type");
        }
    }
}