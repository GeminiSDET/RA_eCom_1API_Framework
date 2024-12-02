package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.File;

import org.testng.Assert;

import endpoints.ProductEndPoints;
import io.restassured.response.Response;

public class ProductTests {

	
	@Test
	public void testAddProductSuccessfully() {
		File productImage = new File ("src/test/resources/product.jpg");
		Response response=ProductEndPoints.addProduct(token, productImage, "");
		
		AssertJUnit.assertEquals(response.statusCode(), 201);
		AssertJUnit.assertTrue(response.jsonPath().getString("message").contains("successfully added"));
	}
	
	@Test
	public void testAddProductWithoutImage() {
		Response response=ProductEndPoints.addProduct(token, productImage, "");
		
		AssertJUnit.assertEquals(response.getStatusCode(), 400);
		AssertJUnit.assertTrue(response.jsonPath().getString("message").contains("Image required"));
	}
}
