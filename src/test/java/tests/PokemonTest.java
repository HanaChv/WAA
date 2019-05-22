package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import pages.PokemonPage;

public class PokemonTest extends TestBase {
    private PokemonPage pokePage;

    @Before
    public void openPage() {
        //1.otvorit stranku
        driver.get(BASE_URL + "/vybersi.php");
        pokePage = new PokemonPage(driver);
    }

    @Test
    public void itShouldSelectPokemons() {
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Diglett", "Geodude"};

        for (String pokemon : selectedPokemons) {
            //vyberiem pokemona
            pokePage.selectPokemon(pokemon);
            //overim hlasku
            Assert.assertEquals(getExpectedMessage(pokemon), getActualMessage());
        }
    }
    public String getExpectedMessage(String pokemonName) {
        return String.format("I choose you %s !", pokemonName);
    }
}