package org.example.ta.tests.api;

import io.restassured.response.Response;
import org.example.ta.endpoint.UserEndpointService;
import org.example.ta.bo.User;
import org.example.ta.services.api.UserApiService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UserApiTest {
    private final UserApiService userApiService = new UserApiService();
    private final UserEndpointService userEndpointService = new UserEndpointService();

    @Test(description = "Check that all user fields received from the page #2 are not null.")
    public void checkAllUserFieldsAreReceivedFromSecondPage() {
        int pageNumber = 2;
        List<User> users = userApiService.getUsers(pageNumber);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(users.size() > 0, "Number of users must be greater than zero.");

        for (User user: users) {
            softAssert.assertNotNull(user.getId(), "Id cannot be null.");
            softAssert.assertNotNull(user.getEmail(), "Email cannot be null.");
            softAssert.assertNotNull(user.getFirst_name(), "First name cannot be null.");
            softAssert.assertNotNull(user.getLast_name(), "Last name cannot be null.");
            softAssert.assertNotNull(user.getAvatar(), "Avatar url cannot be null.");
        }
        softAssert.assertAll();
    }

    @Test(description = "Check that all user fields received from all pages are not null.")
    public void checkAllUserFieldsAreReceived() {
        List<User> users = userApiService.getAllUsers();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(users.size() > 0, "Number of users must be greater than zero.");

        for (User user: users) {
            softAssert.assertNotNull(user.getId(), "Id cannot be null.");
            softAssert.assertNotNull(user.getEmail(), "Email cannot be null.");
            softAssert.assertNotNull(user.getFirst_name(), "First name cannot be null.");
            softAssert.assertNotNull(user.getLast_name(), "Last name cannot be null.");
            softAssert.assertNotNull(user.getAvatar(), "Avatar url cannot be null.");
        }
        softAssert.assertAll();
    }

    @Test(description = "Check that user is created")
    public void checkUserIsCreated() {
        try {
            User userToBeCreated = new User("1", "george.bluth@reqres.in", "George", "Bluth",
                    new URL("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
            Response response = userEndpointService.createUser(userToBeCreated);
            User createdUser = response.as(User.class);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(response.getStatusCode(), 201, "Invalid status code.");
            softAssert.assertEquals(createdUser, userToBeCreated, "Users are not the same");
            softAssert.assertAll();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
