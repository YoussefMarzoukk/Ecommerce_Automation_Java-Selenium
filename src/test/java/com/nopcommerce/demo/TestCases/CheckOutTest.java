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
        HomePage homePage = new HomePage(driver);
        homePage
            .load()
            .setAddProductToCart()
            .cartButton()
            .acceptTerms()
            .proceedToCheckout()
            .GuestCheckout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkOutSequence();
        boolean isSuccessful = checkoutPage.isSuccessful();
        Assert.assertTrue(isSuccessful);
    }}
