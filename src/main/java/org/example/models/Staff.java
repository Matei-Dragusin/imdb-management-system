package org.example;
import java.util.List;
import java.util.SortedSet;
public abstract class Staff<T extends Comparable<T>> extends User<T> implements StaffInterface{
    private List<Request> assignedRequests;
    private SortedSet<T> addedItems;

    public Staff(String username,Information information, AccountType accountType, int experience, List<String> notifications, SortedSet<String> favorites, List<Request> assignedRequests, SortedSet<T> addedItems) {
        super(username,information, accountType, experience, notifications, favorites);
        this.assignedRequests = assignedRequests;
        this.addedItems = addedItems;
    }

    public void addContribution(T contribution){
        addedItems.add(contribution);
    }

    public void removeContribution(T contribution){
        addedItems.remove(contribution);
    }

    public SortedSet<T> getContributions(){
        return addedItems;
    }

    public boolean containsContribution(String contribution){
        return addedItems.contains(contribution);
    }
}
