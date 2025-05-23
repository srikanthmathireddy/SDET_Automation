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
import static org.junit.Assert.*;


public class Backend_Automation_Scenario_2
{
    Response response;
    int countryCount;

    @Given("I call the RestCountries API to get all countries")
    public void i_call_the_api()
    {
        response = given()
                .when()
                .get("https://restcountries.com/v3.1/all")
                .then()
                .statusCode(200)
                .extract().response();
    }
    @When("I count the number of unique countries returned")
    public void i_count_countries()
    {
        List<Map<String, Object>> countries = response.jsonPath().getList("$");
        countryCount = countries.size();
    }

    @Then("the number of countries should be {int}")
    public void the_number_should_be(int expectedCount)
    {
        assertEquals(expectedCount, countryCount);
    }

}
