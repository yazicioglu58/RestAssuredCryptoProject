package getRequest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class WeatherCondition {


    @Test
    public void getWeatherDetails(){
        // Specify base URI
        RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        // Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/London");


        // print response in console window
    String responseBody = response.getBody().asString();
        System.out.println("Response body is " + responseBody);


    }
}
