package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class  LoginPage extends BasePage{

    @FindBy(id="ctl00_MainContent_username")
    private WebElement userNameElement;

    @FindBy(id="ctl00_MainContent_password")
    private WebElement passwordElement;

    /*
    public BasePage(){ buna gerek yok. cunku zaten BasePage i extend yapiyor.Yani onu ordan zaten inherit ediyor.
        PageFactory.initElements(Driver.getDriver(),this);  //this is a reference to the object. Yani bu sayfa diyor.
    }
     */

    public void login(String userName, String password){ //method lar nonstatic olmali.
        wait.until(ExpectedConditions.visibilityOf(userNameElement)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password, Keys.ENTER); //Keys.ENTER BUNUNLA LOGIN BUTTON A BASTIK
    }
/*
    public void login(){ //method lar nonstatic olmali.
        String userName = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        wait.until(ExpectedConditions.visibilityOf(userNameElement)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password, Keys.ENTER);
    }

 */
    public void login(){
        String userName = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        userNameElement.sendKeys(userName);
        passwordElement.sendKeys(password, Keys.ENTER);
    }


}

/*
Vasyl'in Kodlari:

import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "ctl00_MainContent_username")
    private WebElement userNameElement;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement passwordElement;

    public void login(String userName, String password){
        wait.until(ExpectedConditions.visibilityOf(userNameElement)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password, Keys.ENTER);
    }

    public void login(){
        String userName = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        userNameElement.sendKeys(userName);
        passwordElement.sendKeys(password, Keys.ENTER);
    }

} */
