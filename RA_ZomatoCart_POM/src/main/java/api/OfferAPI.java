package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;

public class OfferAPI {

	 // Adding offer using ApiUtils POST method
    public static Response addOffer(int restaurantId, String offerType, int offerValue, String[] customerSegment) {
        String requestBody = "{"
            + "\"restaurant_id\":" + restaurantId + ","
            + "\"offer_type\":\"" + offerType + "\","
            + "\"offer_value\":" + offerValue + ","
            + "\"customer_segment\":" + customerSegment + "}"
            ;
        return ApiUtils.post("/api/v1/offer", requestBody);
    }

    // Fetching user segment using ApiUtils GET method
    public static Response getUserSegment(int userId) {
        return ApiUtils.get("/api/v1/user_segment?user_id=" + userId);
    }

    // Applying offer on cart using ApiUtils POST method
    public static Response applyOffer(int cartValue, int userId, int restaurantId) {
        String requestBody = "{"
            + "\"cart_value\":" + cartValue + ","
            + "\"user_id\":" + userId + ","
            + "\"restaurant_id\":" + restaurantId + "}"
            ;
        return ApiUtils.post("/api/v1/cart/apply_offer", requestBody);
    }
}
