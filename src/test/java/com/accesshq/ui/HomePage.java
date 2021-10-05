package com.accesshq.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("[aria-label='login or signup']"));
    }

    public WebElement getNotAMemberButton() {
        var find = driver.findElements(By.tagName("a"));
        for (WebElement button : find) {
            if (button.getText().equals("Sign Up")) {
                return button;
            }
        }
        throw new NoSuchElementException("Could not find button");
    }

    public WebElement getSignupButton() {
        return driver.findElement(By.cssSelector("[aria-label='signup']"));
    }

    public WebElement getUsernameTextbox() {
        return driver.findElement(By.cssSelector("[id='gen-20211005-username']"));
        //or "[id='input-108']"
    }

    public WebElement getPasswordTextbox() {
        return driver.findElement(By.cssSelector("[id='input-111']"));
    }

    public WebElement getConfirmTextbox() {
        return driver.findElement(By.cssSelector("[id='input-114']"));
    }

    public WebElement getUsernameError() {return driver.findElement(By.cssSelector("[id='username-err']"));}

    public WebElement getPasswordError() {return driver.findElement(By.cssSelector("[id='password-err']"));}

    public WebElement getConfirmError() {return driver.findElement(By.cssSelector("[id='confirm-err']"));}

    public WebElement getPopup() {return driver.findElement(By.cssSelector("[aria-live='polite']"));}
}