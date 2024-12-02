package endpoints;
import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.response.Response;


public class ProductEndPoints {

	public static  Response addProduct(String token,File file,String productDetails) {
		return given()
				.header("Authorization", token)
                .contentType("multipart/form-data")
                .multiPart("productName", "Laptop")
                .multiPart("productAddedBy", "testuser")
                .multiPart("productCategory", "electronics")
                .multiPart("productPrice", "500")
                .multiPart("productDescription", "High quality laptop")
                .multiPart("productFor", "all")
                .multiPart("productImage", file)
                .body(productDetails)
                .when()
                .post("/api/ecom/product/add-product");
	}
}
