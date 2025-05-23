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

public class Backend_Automation_Scenario_3
{
    private Response response;

    @Given("I fetch all countries from the API")
    public void i_fetch_all_countries_from_the_api()
    {
        response = RestAssured.get("https://restcountries.com/v3.1/all");
    }

    @Then("South African Sign Language should be listed as an official language of South Africa")
    public void validate_south_african_sign_language()
    {
        boolean saslPresent = response.jsonPath()
                .getList("")
                .stream()
                .filter(country -> "South Africa".equals(((Map)country).get("name.common")))
                .anyMatch(country -> ((Map)((Map)country).get("languages")).containsValue("South African Sign Language"));
        assertTrue("South African Sign Language should be present as an official language.", saslPresent);
    }
}
