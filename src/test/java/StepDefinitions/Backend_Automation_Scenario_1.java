package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.lang.module.Configuration;
import java.util.List;
import java.util.Map;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Backend_Automation_Scenario_1

{
    private Response response;

    @Given("the RestCountries API is available")
    public void the_api_is_available()
    {
        // Optionally test health or do nothing
    }

    @When("a user sends a GET request to fetch all countries")
    public void a_user_sends_get_request()
    {
      //  response = RestAssured.get("https://restcountries.com/v3.1/all");
        response = given().when().get("https://restcountries.com/v3.1/all");
      //  System.out.println("Response:"+response.toString());
       // Assert.assertEquals(200, response.getStatusCode());
      //  ResponseBody body = response.getBody();
       // System.out.println("Response: "+ body.asString());

    }

    @Then("the response should conform to the expected schema")
    public void response_should_conform_to_schema()
    {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("country.json"));
        System.out.println("Schema validation passed!");
    }
}
