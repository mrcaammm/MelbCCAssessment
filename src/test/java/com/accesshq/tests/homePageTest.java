package com.accesshq.tests;

import com.accesshq.ui.HomePage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class homePageTest {

    WebDriver driver;

    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://d3udduv23dv8b4.cloudfront.net/");
    }

    public void clean() {driver.quit();}

    @Test
    public void clickEmptyLoginTest() {
        //Setup
        setup();
        HomePage homePage = new HomePage(driver);

        //Act
        homePage.getLoginButton().click();
        homePage.getNotAMember().click();
        homePage.getSignup().click();

        //Assert
        Assertions.assertEquals("Username is required",homePage.getUsernameError().getText());
        Assertions.assertEquals("Password is required",homePage.getPasswordError().getText());
        Assertions.assertEquals("Please confirm your password",homePage.getConfirmError().getText());

        //Clean
        clean();
    }
}
