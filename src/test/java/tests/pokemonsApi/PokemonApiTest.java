package tests.pokemonsApi;


import api.pojoClass.Ability;
import api.pojoClass.AbilityWrapper;
import api.pojoClass.PokemonRoot;
import api.pojoClass.PokemonListRoot;
import api.pojoClass.Results;

import api.steps.PokemonsSteps;
import constants.Constants;
import io.qameta.allure.Severity;
import io.qameta.allure.Epic;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Api Тесты сайта pokeapi")
public class PokemonApiTest {
    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты апи")
    @Story("Тест на сравнение параметров у покемонов")
    @Test
    public void comparisonPokemonsParametersTest() {
        PokemonRoot rattataRoot = PokemonsSteps.getPokemonRoot(Constants.RATTATA_LINK);
        PokemonRoot pidgeottoRoot = PokemonsSteps.getPokemonRoot(Constants.PIDGEOTTO_LINK);
        Assert.assertTrue(rattataRoot.getWeight() < pidgeottoRoot.getWeight(), "У покемона rattata вес не меньше, чем у pidgeottto");
        assertThat(rattataRoot.getAbilities()).extracting(AbilityWrapper::getAbility).extracting(Ability::getName).contains("run-away");
        assertThat(pidgeottoRoot.getAbilities()).extracting(AbilityWrapper::getAbility).extracting(Ability::getName).doesNotContain("run-away");
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты апи")
    @Story("Тест на проверку лимита")
    @Test
    public void checkLimitPokemonsTest() {
        PokemonListRoot pokemonListRoot = PokemonsSteps.getPokemonListRoot();
        assertThat(pokemonListRoot.getResults()).extracting(Results::getLink).hasSize(20);
        assertThat(pokemonListRoot.getResults()).extracting(Results::getName).doesNotContain("");
    }
}
