package restAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class PostInRest {

	@Test
	public void postDetails() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		// JSONObject is a class that represents a simple
		// JSON. We can add Key - Value pairs using the put
		// method
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Kishore"); // Cast
		requestParams.put("LastName", "Latti");

		requestParams.put("UserName", "latti_35");
		requestParams.put("Password", "rest.03592");
		requestParams.put("Email", "kishan.03592@gmail.com");

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());

		// Post the request and check the response
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

}
