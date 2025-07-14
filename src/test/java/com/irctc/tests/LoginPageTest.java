package com.irctc.tests;

import org.testng.annotations.Test;
import com.irctc.base.BaseTest;
import com.irctc.pages.LoginPage;
import org.testng.Assert;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifyLoginFunctionality() {
      
        LoginPage loginPage = new LoginPage(driver);
        String username = "pradeepjadhav3"; 
        String password = "Pradeep@2025"; 
        
        loginPage.login(username, password);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("train-search") || currentURL.contains("home"), 
            "Login might have failed or redirected to unexpected page");

        System.out.println("Login test executed. Current URL: " + currentURL);
    }
}
