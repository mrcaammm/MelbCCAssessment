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

    public WebElement getNotAMember() {
        var find = driver.findElements(By.tagName("a"));
        for (WebElement button : find) {
            if (button.getText().equals("Sign Up")) {
                return button;
            }
        }
        throw new NoSuchElementException("Could not find button");
    }

    public WebElement getUsername() {
        var find = driver.findElements(By.tagName("label"));
        for (WebElement element : find) {
            if (element.getText().equals("Username")) {
                return element;
            }
        }
        throw new NoSuchElementException("Could not find button");
    }

    public WebElement getPassword() {
        var find = driver.findElements(By.tagName("label"));
        for (WebElement element : find) {
            if (element.getText().equals("Username")) {
                return element;
            }
        }
        throw new NoSuchElementException("Could not find button");
    }

    public WebElement getSignup() {
        return driver.findElement(By.cssSelector("[aria-label='signup']"));
    }

    public WebElement getUsernameError() {return driver.findElement(By.cssSelector("[id='username-err']"));}

    public WebElement getPasswordError() {return driver.findElement(By.cssSelector("[id='password-err']"));}

    public WebElement getConfirmError() {return driver.findElement(By.cssSelector("[id='confirm-err']"));}
}