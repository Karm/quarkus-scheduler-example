package com.example.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@QuarkusTest
public class HelloApplicationTest {

    @Test
    public void test() {
        await().atMost(20, TimeUnit.SECONDS).untilAsserted(() -> assertThat(Integer.parseInt(given()
                .when()
                .get("/app/counter")
                .then()
                .statusCode(200)
                .extract().body().asString()), greaterThanOrEqualTo(10)));
    }
}
