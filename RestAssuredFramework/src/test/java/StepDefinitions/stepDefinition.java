package StepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.testng.Assert.assertTrue;

import POJO.addPlace;
import POJO.location;
import Resources.APIResources;
import Resources.Utilities;
import Resources.testDataBuild;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefinition extends Utilities {
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	static String place_id;
	testDataBuild data = new testDataBuild();
	@Given ("add place payload with {String} {String} {String}")
	public void payload(String name, String language, String address) throws IOException {
		
		 res = given().spec(requestSpecification())
		.body(data.payload(name, language, address));
		
	}
	
	@When ("user calls {String} with {String} http request")
	public void method(String resource, String method) {
		//constructor will be called with value of resource which you pass
		APIResources resourceApi = APIResources.valueOf(resource);
		System.out.println(resourceApi.getResource());
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equals("Post")) 
		 response = res.when().post(resourceApi.getResource());
		else if(method.equals("Get"))
			response = res.when().get(resourceApi.getResource());
				
				
		
	}
	
	@Then ("the api call is success with status code 200")
	public void statuscode() {
		assertEquals(response.getStatusCode(),200);
		assertTrue(response.getTimeIn(TimeUnit.MILLISECONDS)>=1000,"no within time");
		
	}
	
	@And ("{String} in response body is {String}")
	public void payload(String keyvalue, String Expectedkeyvalue) {
		
	 assertEquals(getJsonPath(response,keyvalue),Expectedkeyvalue);
		
	}
	
	@Then ("verify place_Id created maps to {String} using {String}")
	 public void verify_Place_Id(String expectedname, String resource) throws IOException {
	    place_id = getJsonPath(response,"place_id");
		res = given().spec(requestSpecification()).queryParam("place_id",place_id);
		method(resource,"Get");
		String actualname = getJsonPath(response,"name");
		assertEquals(actualname,expectedname);

	}
	
	@Given ("delete place payload")
	 public void delete_place() throws IOException {
		given().spec(requestSpecification()).body(data.deleteplacepayload(place_id));
	}
}
	
