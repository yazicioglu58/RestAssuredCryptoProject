package getRequest;


import io.restassured.RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


// import io.restassured.RestAssured ---> change to import static io.restassured.RestAssured.*; so in the code
// need to say --> Response response = get("");
public class GetData {

@Test
public void testResponseCode(){
   Response response = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=2166bc1df42056ebff03982acdc177de");

   response.getBody().prettyPrint();

    JsonPath jsonPath = getResponseAsJson(response);

    int code = response.statusCode();
    System.out.println(code);
    Assert.assertEquals(code,200);
}

    @Test
    public void testResponseCodeCrypto(){

        Response response = RestAssured.get("https://min-api.cryptocompare.com/data/pricemultifull?fsyms=BTC&tsyms=USD");
        response.getBody().prettyPrint();

        JsonPath jsonPath = getResponseAsJson(response);

        String price =jsonPath.getString("RAW.BTC.USD.PRICE");

        System.out.println("price -> " +price);

        int code = response.statusCode();
        System.out.println(code);
        Assert.assertEquals(code,200);
    }

    public JsonPath getResponseAsJson(Response response){
        return new JsonPath((response.asString()));
    }

    @Test
    public void testBody(){
        Response response = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=2166bc1df42056ebff03982acdc177de");

    String data = response.jsonPath().prettify();
    String data2 = response.asString();
        System.out.println("Data is " + data);
        System.out.println(data2);

        System.out.println("Response time "+ response.getTime());
    }

@Test
    public void testResponseCode2(){
    int code = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=2166bc1df42056ebff03982acdc177de").getStatusCode();
    System.out.println("Status code is "+ code);
}

    @Test
    public void testBody2(){
        String data = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=2166bc1df42056ebff03982acdc177de").asString();
        long time = RestAssured.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=2166bc1df42056ebff03982acdc177de").getTime();
        System.out.println("Response time is "+ time);
    }


}
