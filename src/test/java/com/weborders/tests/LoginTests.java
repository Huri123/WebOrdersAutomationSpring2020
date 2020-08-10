package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test(description = "Just login and verify title")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        //Assert.assertEquals(Driver.getDriver().getTitle(),"Web Orders","Page title is wrong");
        //assertion
        String actual = Driver.getDriver().getTitle();
        String expected = "Web Orders";
        Assert.assertEquals(actual, expected, "Page title is wrong!");
        BrowserUtils.takeScreenshot();
    }


}


/*
Vasyl'in Kodlari:

import com.weborders.pages.LoginPage;
import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test(description = "Just login and verify title")
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //assertion
        String actual = Driver.getDriver().getTitle();
        String expected = "Web Orders";
        Assert.assertEquals(actual, expected, "Page title is wrong!");
        BrowserUtils.takeScreenshot();
    }
} */
