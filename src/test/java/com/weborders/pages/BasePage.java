package com.weborders.pages;

import com.weborders.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Base page is like basement. it is a class that have comman things with other class. This class also never been instantiated. instantiate demek object olusturmak demek
public abstract class BasePage {  //object olusturamiyoruz. because it's abstract
    //explicit wait
    //will be used inside every page class
    //since this variable is protected
    //it will not be visible in test classes
    protected static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20); //object olusturunca tum class lar paylasabilsin diye
    //protected

    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrders;

    @FindBy(linkText = "View all products")
    private WebElement viewAllProducts;

    @FindBy(linkText = "Order")
    private WebElement order;

    //yukardakiyle ayni
    //private WebElement order2 = Driver.getDriver().findElement(By.linkText("Order"));

    public BasePage(){
        //we put this line to be able to use @FindBy @FindBys.. annotations
        PageFactory.initElements(Driver.getDriver(),this);  //this is a reference to the object. Yani bu sayfa diyor.
    }

    public void clickOnViewAllOrders(){
        System.out.println("Clicking on 'View All Orders'page");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllOrders));
        viewAllOrders.click();
    }
    public void clickOnViewAllProducts(){
        System.out.println("Clicking on 'View All Products'page");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts));
        viewAllProducts.click();
    }
    public void clickOnOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(order)).click();
    }


}


/*
Vasyl'in Kodlari:

import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    //explicit wait
    //will be used inside every page class
    //since this variable is protected
    //it will not be visible in test classes
    protected static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrders;

    @FindBy(linkText = "View all products")
    private WebElement viewAllProducts;

    @FindBy(linkText = "Order")
    private WebElement order;

    public BasePage() {
        //we put this line to be able to use @FindBy, @FindBys.. annotations
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickOnViewAllOrders(){
        System.out.println("Clicking on 'View All Orders'");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllOrders));
        viewAllOrders.click();
    }

    public void clickOnViewAllProducts(){
        System.out.println("Clicking on 'View All Products'");
        wait.until(ExpectedConditions.elementToBeClickable(viewAllProducts));
        viewAllProducts.click();
    }

    public void clickOnOrder(){
        System.out.println("Clicking on 'Order'");
        wait.until(ExpectedConditions.elementToBeClickable(order)).click();
    }

} */
