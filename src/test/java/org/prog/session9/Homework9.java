package org.prog.session9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Homework9 {

    @Test
    public void myRestTest() {
        RequestSpecification requestSpecification = generateRequestSpecification("https://randomuser.me/");

        Response response = requestSpecification.get();
        List<String> genders = response.jsonPath().get("results.gender");
        Assert.assertTrue(genders.contains("male"),
                " should have at least 1 male");

        response.prettyPrint();

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.body("results.gender", Matchers.hasItem("male"));
        validatableResponse.body("results.gender", Matchers.hasItem("female"));

    }

    @Test
    public void myRestTest2() {
        RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("api/")
                .queryParam("inc", "gender,name,nat")
                .queryParam("results", 3)
                .queryParam("noinfo")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("results.gender", Matchers.hasItem("male"))
                .body("results.gender", Matchers.hasItem("female"));
    }

    @Test
    public void testLocationFields() {
        RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("api/")
                .queryParam("inc", "location") // включаємо тільки локацію
                .queryParam("results", 3)
                .queryParam("noinfo")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                // Перевіряємо що street name не порожній
                .body("results.location.street.name", Matchers.everyItem(Matchers.notNullValue()))
                .body("results.location.street.name", Matchers.everyItem(Matchers.not(Matchers.emptyString())))
                // Перевіряємо що street number не порожній
                .body("results.location.street.number", Matchers.everyItem(Matchers.notNullValue()))
                // Перевіряємо що координати не порожні
                .body("results.location.coordinates.latitude", Matchers.everyItem(Matchers.notNullValue()))
                .body("results.location.coordinates.latitude", Matchers.everyItem(Matchers.not(Matchers.emptyString())))
                .body("results.location.coordinates.longitude", Matchers.everyItem(Matchers.notNullValue()))
                .body("results.location.coordinates.longitude", Matchers.everyItem(Matchers.not(Matchers.emptyString())));
    }

    private RequestSpecification generateRequestSpecification(String baseUri) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri(baseUri);
        requestSpecification.basePath("api/");

        requestSpecification.queryParam("inc", "gender,name,nat");
        requestSpecification.queryParam("results", 3);
        requestSpecification.queryParam("noinfo");
        return requestSpecification;
    }
}