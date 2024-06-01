package com.nopcommerce.demo.TestCases;

import com.nopcommerce.demo.Pages.CheckoutPage;
import com.nopcommerce.demo.Pages.HomePage;
import com.nopcommerce.demo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

@Test
    public void AddItemtoCart(){
    HomePage homePage = new HomePage(driver);
    boolean isAdded = homePage.load().setAddProductToCart().itemAddedSuccessfully();
    Assert.assertTrue(isAdded);

}

@Test
    public void checkProductPrice(){
    HomePage homePage = new HomePage(driver);
    String shownPrice = homePage.load().setAddProductToCart().cartButton().getProductPriceText();
    String ActualPrice= "$27.00";
    Assert.assertEquals(shownPrice, ActualPrice);
}

    @Test
    public void removeItemFromCart() {
        HomePage homePage = new HomePage(driver);
        boolean isItemDeleted = homePage.load().setAddProductToCart().cartButton().removeItemFromCart().emptyCartCheck();
        Assert.assertTrue(isItemDeleted);
    }

    @Test
    public void continueShopping() {
        HomePage homePage = new HomePage(driver);
         homePage.load().setAddProductToCart().cartButton().continueShopping();

    }

    @Test
    public void proceedToCheckout() {
        HomePage homePage = new HomePage(driver);
        homePage.load().setAddProductToCart().cartButton().acceptTerms().proceedToCheckout();
    }



}
