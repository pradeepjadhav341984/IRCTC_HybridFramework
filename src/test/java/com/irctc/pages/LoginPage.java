package com.irctc.pages;

import org.openqa.selenium.By;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void login(String userIdVal, String passwordVal) {

        try {
            // Close popup if it appears
            WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa.fa-window-close")));
            popupClose.click();
        } catch (Exception e) {
            System.out.println("No alert popup");
        }

        // Click LOGIN button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'LOGIN')]")));
        loginBtn.click();

        // Wait for username field
        WebElement userId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='userid']")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='password']")));

        userId.sendKeys(userIdVal);
        password.sendKeys(passwordVal);

        // Click sign in
        WebElement signInBtn = driver.findElement(By.xpath("//button[@label='SIGN IN']"));
        signInBtn.click();
    }
}
