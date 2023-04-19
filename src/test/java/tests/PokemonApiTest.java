package tests;


import api.Ability;
import api.PokemonRoot;
import api.Results;
import constants.Constants;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class PokemonApiTest {

    @Test
    public void comparisonPokemonsParametersTest() {
        PokemonRoot rattata = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(Constants.RATTATA_LINK)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().as(PokemonRoot.class);
        PokemonRoot pidgeotto = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(Constants.PIDGEOTTO_LINK)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().body().as(PokemonRoot.class);
        List<Ability> rattataAbilitiesList = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(Constants.RATTATA_LINK)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("abilities.ability", Ability.class);
        List<Ability> pidgeottoAbilitiesList = given()
                .baseUri(Constants.POKEMON_API)
                .basePath(Constants.PIDGEOTTO_LINK)
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("abilities.ability", Ability.class);
        Assert.assertTrue(rattata.getWeight() < pidgeotto.getWeight(), "У покемона rattata вес не меньше, чем у pidgeottto");
        assertThat(rattataAbilitiesList).extracting(Ability::getName).contains("run-away");
        assertThat(pidgeottoAbilitiesList).extracting(Ability::getName).doesNotContain("run-away");
    }

    @Test
    public void checkLimitPokemonsTest() {
        List<Results> pokemonsNameList = given()
                .baseUri(Constants.POKEMON_API)
                .basePath("/pokemon?limit=20")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("results", Results.class);
        assertThat(pokemonsNameList).extracting(Results::getLink).hasSize(20);
        assertThat(pokemonsNameList).extracting(Results::getName).doesNotContain("");
    }
}
