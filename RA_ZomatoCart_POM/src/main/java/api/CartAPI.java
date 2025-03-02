package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CartAPI {

	private static final String BASE_URL = "https://mockapi.com";

    public static Response applyOffer(int cartValue, int userId, int restaurantId) {
        return RestAssured.given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body("{\"cart_value\":" + cartValue + ",\"user_id\":" + userId + ",\"restaurant_id\":" + restaurantId + "}")
            .post("/api/v1/cart/apply_offer");
    }
}
