package com.irctc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Elements
    @FindBy(xpath = "//a[contains(text(),'LOGIN')]")
    private WebElement loginLink;

    @FindBy(xpath = "//input[@formcontrolname='userid']")
    private WebElement username;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[text()='SIGN IN']")
    private WebElement loginBtn;

    // Method
    public void login(String user, String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
