package com.yandex.diplom3;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUserStep {
    private String bearer;
    private Response responseOfUserLogin;
    private Response responseOfUserDeleting;

    public DeleteUserStep(){
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @Step
    public void deleteUser(String email, String password){

        String json = "{\"email\":\"" + email + "\", \"password\": \"" + password + "\"}";

        responseOfUserLogin = given()
            .header("Content-type", "application/json")
            .and()
            .body(json)
            .when()
            .post(Urls.LOGIN_USER);

        bearer = DataHelper.bearerToken(responseOfUserLogin.asString());

        if(bearer != null){
            responseOfUserDeleting = given()
            .headers(
                "Authorization",
                "Bearer " + bearer,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON
                )
            .when()
            .delete(Urls.DELETE_USER);
        }
    }
}
