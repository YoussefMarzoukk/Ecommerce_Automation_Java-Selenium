package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr:nth-child(1) > td.unit-price > span")
    private WebElement productPrice;
    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(css = ".qty-input")
    private WebElement productQuantity;
    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr:nth-child(1) > td.subtotal > span")
    private WebElement totalPrice;
    @FindBy(css = ".up")
    private WebElement quantityUP;
    @FindBy(css = ".down")
    private WebElement quantityDown;
    @FindBy(css = "#shopping-cart-form > div.table-wrapper > table > tbody > tr > td.remove-from-cart > button")
    private WebElement removeItem;
    @FindBy(css = "#shopping-cart-form > div.cart-options > div.common-buttons > button.button-2.continue-shopping-button")
    private WebElement continueShoppingButton;
    @FindBy(css = "#open-estimate-shipping-popup")
    private WebElement estimateShippingButton;
    @FindBy(css = "#termsofservice")
    private WebElement termsBox;
    @FindBy(css = "#checkout")
    private WebElement checkoutButton;
    @FindBy(css = "#main > div > div > div > div.page-body > div > div")
    private WebElement emptyCart;
    @FindBy(css = ".checkout-as-guest-button")
    private WebElement checkoutAsGuest;




    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    public String incQuantity(){
            quantityUP.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
            return productQuantity.getText();
    }
    public String decQuantity() {
            quantityDown.click();
        return productQuantity.getText();

    }

    public String getProductQuantity(WebElement productPrice) {
        return productPrice.getText();
    }
    public String getProductPriceText() {
        return productPrice.getText();
    }

    public String getProductNameText() {
        return productName.getText();
    }

    public String getProductQuantityText() {
        return productQuantity.getText();
    }

    public String getTotalPriceText() {
        return totalPrice.getText();
    }
    public boolean emptyCartCheck() {
        return emptyCart.isDisplayed();
    }

    public ShoppingCartPage removeItemFromCart() {
        removeItem.click();
        return new ShoppingCartPage(driver);
    }

    public HomePage continueShopping() {
        continueShoppingButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        return new HomePage(driver);
    }

    public void estimateShipping() {
        estimateShippingButton.click();
    }

    public ShoppingCartPage acceptTerms() {
        if (!termsBox.isSelected()) {
            termsBox.click();
        }
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage proceedToCheckout() {
        checkoutButton.click();
        return new ShoppingCartPage(driver);
    }
    public CheckoutPage GuestCheckout() {
        checkoutAsGuest.click();
        return new CheckoutPage(driver);
    }




}
