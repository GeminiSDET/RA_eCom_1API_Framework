package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

private static final String BASE_URL = "https://mockapi.com";  // Mock API base URL

    public static Response get(String endpoint) {
        return RestAssured.given()
            .baseUri(BASE_URL)
            .get(endpoint);
    }

    public static Response post(String endpoint, String requestBody) {
        return RestAssured.given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
            .post(endpoint);
    }

    public static Response put(String endpoint, String requestBody) {
        return RestAssured.given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
            .put(endpoint);
    }

    public static Response delete(String endpoint) {
        return RestAssured.given()
            .baseUri(BASE_URL)
            .delete(endpoint);
    }
}
