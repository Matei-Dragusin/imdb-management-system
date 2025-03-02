package org.example;

import java.util.List;
import java.util.ArrayList;

public class RequestsHolder {

    private static List<Request> requestsForAdmins = new ArrayList<>();

    public static void addRequest(Request request){
        requestsForAdmins.add(request);
    }

    public static void removeRequest(Request request){
        requestsForAdmins.remove(request);
    }

    public static List<Request> getRequests(){
        return requestsForAdmins;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("RequestsHolder{\n");
        for (Request request : requestsForAdmins){
            result.append(request.toString());
        }
        result.append("}");
        return result.toString();
    }
}
