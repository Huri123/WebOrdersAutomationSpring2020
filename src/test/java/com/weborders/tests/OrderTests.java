package com.weborders.tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTests extends TestBase{

    /**
     *
     Scenario: 1. Create order
     Given user is on the login page
     And user logs in
     And user navigates to "Order" page
     When user enters product information:
     | Product     | Quantity | Price per unit | Discount |
     | ScreenSaver | 12       | 20             | 10%      |
     And user click on calculate button
     Then user should verify that total 216 is displayed
     When user enters address information:
     | Customer name | Street  | City     | State    | Zip   |
     | Test User     | 5th Ave | New York | New York | 10011 |
     And user enters payment information:
     | Card | Card Nr:    | Expire date (mm/yy) |
     | Visa | 12345667890 | 04/25               |
     And user clicks on process button
     And user navigates to "View all orders" page
     Then user verifies that order is displayed
     | Name      | Product     |
     | Test User | ScreenSaver |
     */
    @Test(description = "Create random order")
    public void createOrder() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        OrderPage orderPage = new OrderPage();

        loginPage.login();
        loginPage.clickOnOrder();
        //When user enters product information:
        orderPage.selectProduct("ScreenSaver");
        orderPage.enterQuantity("12");
        orderPage.enterPricePerUnit("20");
        orderPage.enterDiscount("10");
        orderPage.clickToCalculate();
        // Then user should verify that total 216 is displayed
        Assert.assertEquals(orderPage.getTotal(), "216", "Total is not matching!");
        // When user enters address information:
        orderPage.enterCustomerName("Test User");
        orderPage.enterStreet("5th Ave");
        orderPage.enterCity("New York");
        orderPage.enterState("New York");
        orderPage.enterZip("10011");
        // And user enters payment information:
        orderPage.selectCard("Visa");
        orderPage.enterCardNumber("12345667890");
        orderPage.enterExpirationDate("04/25");

        orderPage.clickOnProcessButton();
        orderPage.clickOnViewAllOrders();
        Thread.sleep(4000);
    }
}