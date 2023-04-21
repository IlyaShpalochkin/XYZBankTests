package tests.pokemonsApi;


import api.pojoClass.Ability;
import api.pojoClass.Results;
import api.Specifications;
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
        Assert.assertTrue(Specifications.getPokemonRoot(Constants.RATTATA_LINK).getWeight() < Specifications.getPokemonRoot(Constants.PIDGEOTTO_LINK).getWeight(), "У покемона rattata вес не меньше, чем у pidgeottto");
        assertThat(Specifications.getPokemonAbilities(Constants.RATTATA_LINK)).extracting(Ability::getName).contains("run-away");
        assertThat(Specifications.getPokemonAbilities(Constants.PIDGEOTTO_LINK)).extracting(Ability::getName).doesNotContain("run-away");
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты апи")
    @Story("Тест на проверку лимита")
    @Test
    public void checkLimitPokemonsTest() {
        assertThat(Specifications.getPokemonsNameList()).extracting(Results::getLink).hasSize(20);
        assertThat(Specifications.getPokemonsNameList()).extracting(Results::getName).doesNotContain("");
    }
}
