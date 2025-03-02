package steps;

import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.ExtentTest;

import api.CartAPI;
import api.OfferAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.ExtentReportManager;

public class OfferSteps {

	private Response offerResponse;
    private Response applyOfferResponse;
    private double finalPrice;
    private ExtentTest test;

    public OfferSteps() {
        test = ExtentReportManager.startTest("Verify FLAT Offer for Segment P1");
    }
    
    @Given("I add a FLAT offer of {int} {string} for segment {string} for restaurant {int}")
    public void i_add_a_FLAT_offer_of_for_segment_for_restaurant(int offerValue, String offerType, String segment, int restaurantId) {
        offerResponse = OfferAPI.addOffer(restaurantId, offerType, offerValue, new String[]{segment});
        assertEquals(offerResponse.getStatusCode(), 200);
        test.pass("Offer added successfully for segment " + segment);
    }

    @When("I apply the offer on cart with value {int} for user {int} and restaurant {int}")
    public void i_apply_the_offer_on_cart_with_value_for_user_and_restaurant(int cartValue, int userId, int restaurantId) {
        applyOfferResponse = CartAPI.applyOffer(cartValue, userId, restaurantId);
        assertEquals(applyOfferResponse.getStatusCode(), 200);
        finalPrice = applyOfferResponse.jsonPath().getDouble("cart_value");
        test.info("Cart Value: " + cartValue + ", Discount Applied: " + (cartValue - finalPrice));
    }

    @Then("the final cart value should be {double}")
    public void the_final_cart_value_should_be(double expectedFinalPrice) {
        assertEquals(finalPrice, expectedFinalPrice, 0.01);
        test.pass("Final cart value: " + finalPrice + " matches expected value: " + expectedFinalPrice);
    }
}
