package tests.pokemonsApi;


import api.pojoClass.Ability;
import api.pojoClass.AbilityWrapper;
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
        Assert.assertTrue(PokemonsSteps.getPokemonRoot(Constants.RATTATA_LINK).getWeight() < PokemonsSteps.getPokemonRoot(Constants.PIDGEOTTO_LINK).getWeight(), "У покемона rattata вес не меньше, чем у pidgeottto");
        assertThat(PokemonsSteps.getPokemonRoot(Constants.RATTATA_LINK).getAbilities()).extracting(AbilityWrapper::getAbility).extracting(Ability::getName).contains("run-away");
        assertThat(PokemonsSteps.getPokemonRoot(Constants.PIDGEOTTO_LINK).getAbilities()).extracting(AbilityWrapper::getAbility).extracting(Ability::getName).doesNotContain("run-away");
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты апи")
    @Story("Тест на проверку лимита")
    @Test
    public void checkLimitPokemonsTest() {
        assertThat(PokemonsSteps.getPokemonListRoot().getResults()).extracting(Results::getLink).hasSize(20);
        assertThat(PokemonsSteps.getPokemonListRoot().getResults()).extracting(Results::getName).doesNotContain("");
    }
}
