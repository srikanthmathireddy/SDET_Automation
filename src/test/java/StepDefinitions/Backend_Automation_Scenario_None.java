package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Map;

import static org.hamcrest.Matchers.*;

public class Backend_Automation_Scenario_None
{
    private String requestBody;
    private Response response;

    @Given("I have the following quote request for NONE tier")
    public void i_have_the_following_quote_request(io.cucumber.datatable.DataTable dataTable) {
        Logger.getRootLogger().setLevel(Level.OFF);
        Map<String, String> data = dataTable.asMaps().get(0);
        requestBody = String.format(
                "{ \"fareAmount\": %s, \"currency\": \"%s\", \"cabinClass\": \"%s\", \"customerTier\": \"%s\", \"promoCode\": \"%s\" }",
                data.get("fareAmount"),
                data.get("currency"),
                data.get("cabinClass"),
                data.get("customerTier"),
                data.get("promoCode")
        );
    }

    @When("I send the quote request to the API for NONE tier")
    public void i_send_the_quote_request_to_the_api()
    {
        response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("http://localhost:8080/v1/points/quote");
    }

    @Then("the response should contain the correct points calculation for NONE tier")
    public void the_response_should_contain_the_correct_points_calculation()
    {
        System.out.println("API Response for NONE Quote:"+response.body().asString());
        response.then()
                .statusCode(200)
                .body("basePoints", equalTo(1234))
                .body("tierBonus", equalTo(0))
                .body("promoBonus", equalTo(308))
                .body("totalPoints", lessThanOrEqualTo(50000))
                .body("effectiveFxRate", notNullValue());
    }

}
