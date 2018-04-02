package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class RestTesting {
	@Test
	public void GetWeatherDetailsCondensed() {

		// System.setProperty("https.proxyHost", "172.22.218.218");
		// System.setProperty("https.proxyPort", "8085");
		// Specify the base URL to the RESTful web service
		RestAssured.proxy("172.22.218.218", 8085);
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a GET request call directly by using RequestSpecification.get() method.
		// Make sure you specify the resource name.
		Response response = httpRequest.get("/Hyderabad");

		// Response.asString method will directly return the content of the body
		// as String.
		System.out.println("Response Body is =>  " + response.asString());

		// Get the status code from the Response. In case of
		// a successfull interaction with the web service, we
		// should get a status code of 200.
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		System.out.println("Status code is " + statusCode);
		Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "Correct status code returned");

		String statusLine = response.getStatusLine();
		System.out.println("Status code is " + statusLine);
		Assert.assertEquals(statusLine /* actual value */, "HTTP/1.1 200 OK" /* expected value */,
				"Correct status code returned");

		// Header

		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);

		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType = response.header("Server");
		System.out.println("Server value: " + serverType);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);

		// Get All Headers
		// Get all the headers. Return value is of type Headers.
		// Headers class implements Iterable interface, hence we
		// can apply an advance for loop to go through all Headers
		// as shown in the code below
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}

		// Validate Header
		String contentTyp = response.header("Content-Type");
		Assert.assertEquals(contentTyp /* actual value */, "application/json" /* expected value */);

		ResponseBody body = response.getBody();

		// By using the ResponseBody.asString() method, we can convert the body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());
	}

}
