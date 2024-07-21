package com.duckduckgo;

import com.duckduckgo.model.Icon;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ApiTests {

    @Test
    public void verifyAllResultsShouldContainTheSearchedWord() {
        Response response = RestAssured.when().get("https://api.duckduckgo.com/?q=simpsons&format=json");
        response.then().statusCode(200);

        List<String> urls = response.jsonPath()
                .getList("RelatedTopics.Icon", Icon.class)
                .stream().filter(Objects::nonNull)
                .map(Icon::getUrl).collect(Collectors.toList());
        System.out.println(urls);
    }

}
