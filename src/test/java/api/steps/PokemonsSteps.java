package api.steps;

import api.pojoClass.PokemonListRoot;
import api.pojoClass.PokemonRoot;
import constants.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PokemonsSteps {
    public static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri(Constants.POKEMON_API)
                    .setContentType(ContentType.JSON)
                    .build().filter(new AllureRestAssured());

    @Step("Отправка Get запроса для получения root")
    public static PokemonRoot getPokemonRoot(String pokemonLink) {
        return given().spec(REQ_SPEC).basePath(pokemonLink)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().as(PokemonRoot.class);
    }

    @Step("Получение списка покемонов")
    public static PokemonListRoot getPokemonListRoot() {
        return given().spec(REQ_SPEC)
                .basePath(Constants.POKEMON_LIMIT)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().as(PokemonListRoot.class);
    }
}
