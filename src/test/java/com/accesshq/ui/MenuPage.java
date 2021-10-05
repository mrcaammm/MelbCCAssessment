package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MenuPage {
    public WebDriver driver;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickMenu(){
        return driver.findElement(By.cssSelector("[aria-label='menu']"));
    }

    public List<WebElement> getPizzas() {
        return driver.findElements(By.cssSelector("[class='flex mb-2 mt-5 xs12 sm6 md3 lg2']"));
    }

    public List<WebElement> getVegan(List<WebElement> pizzas) {
        var veganPizzas = new ArrayList<WebElement>();
        for (WebElement pizza : pizzas) {
            if (pizza.getText().contains("Vegan")){
                veganPizzas.add(pizza);
            }
        }
        return veganPizzas;
    }

    public int checkPizzaPrice(List<WebElement> veganPizzas) {
        int count = 0;
        for (WebElement pizza : veganPizzas) {
            if (pizza.getText().contains("$14.99")){
                count++;
            }
        }
        return count;
    }
}