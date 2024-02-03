package com.virgingames.virgingamesinfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class BingoSteps {

    @Step("Getting the Bingo information with Currency : {0}")
    public ValidatableResponse getBingoAllRecordsAccordingToCurrenct(String currency) {

        return SerenityRest.given()
                .queryParam("currency",currency)
                .when()
                .get()
                .then().log().all();
    }
}
