package api;

import api.pojoClass.Ability;
import api.pojoClass.PokemonRoot;
import api.pojoClass.Results;
import constants.Constants;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Specifications {

    @Step("Отправка Get запроса для получения root")
    public static PokemonRoot getPokemonRoot(String pokemonLink) {
        PokemonRoot pokemonRoot = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(pokemonLink)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().as(PokemonRoot.class);
        return pokemonRoot;
    }

    @Step("Отправка Get запроса для получения списка способностей покемона")
    public static List<Ability> getPokemonAbilities(String pokemonLink) {
        List<Ability> pokemonAbilitiesList = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(pokemonLink)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("abilities.ability", Ability.class);
        return pokemonAbilitiesList;
    }

    @Step("Получение списка покемонов")
    public static List<Results> getPokemonsNameList() {
        List<Results> pokemonsNameList = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(Constants.POKEMON_LIMIT)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("results", Results.class);
        return pokemonsNameList;
    }
}
