package base;

import io.restassured.RestAssured;

public class BaseTest {

	public BaseTest() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
	}
}
