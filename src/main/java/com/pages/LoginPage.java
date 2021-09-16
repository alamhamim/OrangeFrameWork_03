package com.pages;

import com.utility.Helper;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "userName")
    WebElement userName;

    @FindBy(xpath = "passWord")
    WebElement passWord;

    @FindBy(xpath = "login button")
    WebElement logiButton;

    public void loginToAPP(String username, String password) {
        try {
            userName.sendKeys(username);
            passWord.sendKeys(password);
            Helper.waitForElement(driver, logiButton, 10);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Login button it not working");
        }
    }
}
