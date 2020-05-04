package org.example.ta.services.api;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.example.ta.endpoint.UserEndpointService;
import org.example.ta.bo.User;

import java.util.ArrayList;
import java.util.List;

public class UserApiService {
    private final UserEndpointService userEndpointService = new UserEndpointService();

    public int getNumberOfPages() {
        Response pageInfoResponse = userEndpointService.getPageInfo(1);
        return pageInfoResponse.path("total_pages");
    }

    public List<User> getUsers(int pageNumber) {
        if (pageNumber < 1) {
            throw new IllegalArgumentException("Page number must be greater than zero: " + pageNumber);
        }
        Response pageInfoResponse = userEndpointService.getPageInfo(pageNumber);
        JsonPath jsonPath = pageInfoResponse.jsonPath();
        return jsonPath.getList("data", User.class);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        int numberOfPages = getNumberOfPages();
        for (int pageIndex = 0; pageIndex < numberOfPages; pageIndex++) {
            List<User> users = getUsers(pageIndex + 1);
            allUsers.addAll(users);
        }
        return allUsers;
    }
}
