package com.virgingames.cucumber.steps;

import com.virgingames.virgingamesinfo.BingoSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class BingoTest {

    @Steps
    BingoSteps steps;
    static ValidatableResponse response;
    @When("I send a GET request to get the pots with {string}")
    public void iSendAGETRequestToGetThePotsWith(String currency) {
        response = steps.getBingoAllRecordsAccordingToCurrenct(currency);
    }


    @Then("I get the valid status code {int}")
    public void iGetTheValidStatusCode(int statusCode) {
        response.statusCode(statusCode);
    }

    @Then("I send ID: {string} to find corresponding Name: {string}")
    public void iSendIDToFindCorrespondingName(String id, String name) {
        String actualName = response.extract().path("data.pots.findAll{it.id == '"+id+"'}.name[0]");
        Assert.assertEquals("Name is not matched with ID", actualName, name);
    }
}
