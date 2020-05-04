package org.example.ta.endpoint;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.ta.bo.User;

import java.util.Objects;

public class UserEndpointService {
    private static final String BASE_URL = "https://reqres.in/api";

    public Response createUser(User user) {
        Objects.requireNonNull(user, "User cannot be null.");
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(user);
        return request.post("/users");
    }

    public Response getPageInfo(int pageNumber) {
        if (pageNumber < 1) {
            throw new IllegalArgumentException("Page number must be greater than zero: " + pageNumber);
        }
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        return request.get("/users?page=" + pageNumber);
    }
}
