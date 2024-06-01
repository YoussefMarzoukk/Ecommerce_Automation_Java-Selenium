package com.nopcommerce.demo.TestCases;

import com.nopcommerce.demo.Pages.CheckoutPage;
import com.nopcommerce.demo.Pages.HomePage;
import com.nopcommerce.demo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckOutTest extends BaseTest {

    @Test
    public void validCheckout() {
        // Navigate to the home page and add a product to the cart
        HomePage homePage = new HomePage(driver);
        homePage.load().setAddProductToCart().cartButton().acceptTerms().proceedToCheckout().GuestCheckout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

        // Initialize the checkout page
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Execute the checkout sequence
        checkoutPage.checkOutSequence();

        // Verify that the order was successful
        boolean isSuccessful = checkoutPage.isSuccessful();
        Assert.assertTrue(isSuccessful);
    }}