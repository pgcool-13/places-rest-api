package com.aerztekasse.api;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PlaceControllerApiTest {

    @Test
    public void placeAPITest(){
                given().
                when().
                    get("http://localhost:8080/api/place/id/2").
                then().
                    assertThat().
                    statusCode(200).
                    body("name", equalTo("Priya Cafe")).
                and().
                    contentType(ContentType.JSON);
    }
}
