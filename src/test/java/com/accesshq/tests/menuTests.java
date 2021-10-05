package com.accesshq.tests;

import com.accesshq.ui.MenuPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class menuTests {
    WebDriver driver;

    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://d3udduv23dv8b4.cloudfront.net/");
    }

    public void clean() {driver.quit();}

    @Test
    public void confirmVeganPrices() {
        //Setup
        setup();
        MenuPage menuPage = new MenuPage(driver);

        //Act
        menuPage.clickMenu().click();
        var pizzas = menuPage.getPizzas();
        var veganPizzas = menuPage.getVegan(pizzas);
        int count = menuPage.checkPizzaPrice(veganPizzas);

        //Assert
        Assertions.assertEquals(veganPizzas.size(),count);

        //Clean
        clean();
    }
}
