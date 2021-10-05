package com.accesshq.tests;

import com.accesshq.ui.HomePage;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;

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
        homePage.getNotAMemberButton().click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(homePage.getUsernameTextbox()));
        homePage.getSignupButton().click();

        //Assert
        Assertions.assertEquals("Username is required",homePage.getUsernameError().getText());
        Assertions.assertEquals("Password is required",homePage.getPasswordError().getText());
        Assertions.assertEquals("Please confirm your password",homePage.getConfirmError().getText());

        //Clean
        clean();
    }

    @Test
    public void invalidSignupTest() {
        //Setup
        setup();
        HomePage homePage = new HomePage(driver);

        //Act
        homePage.getLoginButton().click();
        homePage.getNotAMemberButton().click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(homePage.getUsernameTextbox()));
        homePage.getUsernameTextbox().sendKeys("abc");
        homePage.getPasswordTextbox().sendKeys("abc");
        homePage.getConfirmTextbox().sendKeys("def");

        homePage.getSignupButton().click();

        //Assert
        Assertions.assertEquals("Username must be minimum of 6 characters",homePage.getUsernameError().getText());
        Assertions.assertEquals("Password must be minimum of 8 characters",homePage.getPasswordError().getText());
        Assertions.assertEquals("Your passwords do not match",homePage.getConfirmError().getText());

        //Clean
        clean();
    }

    @Test
    public void userAlreadyExistsTest() {
        //Setup
        setup();
        HomePage homePage = new HomePage(driver);

        //Act
        homePage.getLoginButton().click();
        homePage.getNotAMemberButton().click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(homePage.getUsernameTextbox()));
        homePage.getUsernameTextbox().sendKeys("donaldtrump");
        homePage.getSignupButton().click();

        //Assert
        Assertions.assertEquals("Username already exists",homePage.getUsernameError().getText());

        //Clean
        clean();
    }

    @Test
    public void signupSuccessTest() {
        //Setup
        setup();
        HomePage homePage = new HomePage(driver);

        //Act
        homePage.getLoginButton().click();
        homePage.getNotAMemberButton().click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(homePage.getUsernameTextbox()));
        homePage.getUsernameTextbox().sendKeys("robinhood");
        homePage.getPasswordTextbox().sendKeys("letmein2019");
        homePage.getConfirmTextbox().sendKeys("letmein2019");

        homePage.getSignupButton().click();

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(homePage.getPopup()));

        //Assert
        Assertions.assertTrue(homePage.getPopup().isDisplayed());

        //Clean
        clean();
    }
}
