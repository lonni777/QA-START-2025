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

//TODO: add check for location.street.number
//TODO: add check for location.street.name
//TODO: add check for location.coordinates.latitude
//TODO: add check for location.coordinates.longitude

public class RestTests {

    @Test
    public void myRestTest() {
        RequestSpecification requestSpecification =
                generateRequestSpecification("https://randomuser.me/");

        Response response = requestSpecification.get();
        List<String> genders = response.jsonPath().get("results.gender");
        Assert.assertTrue(genders.contains("male"),
                " should have at least 1 male");

        response.prettyPrint();
        ResultsDto dto = response.as(ResultsDto.class);

//        List<String> firstLastNames = dto.getResults().stream()
//                .filter(p -> p.getGender().equals("male"))
//                .map(PersonDto::getName)
//                .map(name -> name.getFirst() + " " + name.getLast())
//                .toList();
//
//        System.out.println(firstLastNames.size());

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.contentType(ContentType.JSON);
        validatableResponse.body("results.gender", Matchers.hasItem("male"));
        validatableResponse.body("results.gender", Matchers.hasItem("female"));

        //        List<String> values = response.jsonPath()
//                .get("results.findAll { it.gender == 'female' }.collect { it.name.first + ' ' + it.name.last }");
//        System.out.println(values.size());

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
