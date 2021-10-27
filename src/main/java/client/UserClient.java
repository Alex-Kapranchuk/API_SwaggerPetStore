package client;

import io.restassured.response.Response;
import model.user.User;

import static io.restassured.RestAssured.given;

public class UserClient extends HttpClient {

    public UserClient() {
        super("user");
    }

    public Response createUser(User user) {
        return given(defaultRequestSpecification)
                .body(user)
                .post();
    }

    public Response getUser(String username) {
        return given(defaultRequestSpecification)
                .get("/{username}", username);
    }

    public Response updateUser(String username, User user) {
        return given(defaultRequestSpecification)
                .body(user)
                .put("/{username}", username);
    }

    public Response deleteUser(String username) {
        return given(defaultRequestSpecification)
                .delete("/{username}", username);
    }
}
