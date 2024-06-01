package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import com.nopcommerce.demo.utils.ConfigUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ico-login")
    private WebElement loginButton;
    @FindBy(css = ".ico-register")
    private WebElement registerButton;
    @FindBy(css = ".ico-account")
    private WebElement myAccount;
    @FindBy(css = ".ico-logout")
    private WebElement logout;
    @FindBy(css = "#small-searchterms")
    private WebElement searchBox;
    @FindBy(css = ".search-box-button")
    private WebElement searchButton;
    @FindBy(css = "body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(5) > a")
    private WebElement Books;
    @FindBy(css = "    #main > div > div.center-2 > div > div.page-body > div.products-container > div.products-wrapper > div > div > div:nth-child(1) > div > div.details > div.add-info > div.buttons > button.button-2.product-box-add-to-cart-button\n")
    private WebElement Book1;
    @FindBy(css = ".cart-label")
    private WebElement cartButton;
    @FindBy(css = "#bar-notification > div > p")
    private WebElement addedSuccessfully;



    public HomePage load() {
        driver.get(ConfigUtils.getInstance().baseURL());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return new HomePage(driver);
    }

    public LoginPage login() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public HomePage logout() {
        logout.click();
        return new HomePage(driver);
    }

    public RegisterPage register() {
        registerButton.click();
        return new RegisterPage(driver);
    }
    public ShoppingCartPage cartButton() {
        cartButton.click();
        return new ShoppingCartPage(driver);
    }

    public boolean successfulLogin() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return myAccount.isDisplayed();
    }

    public HomePage setAddProductToCart() {

        Books.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
        wait.until(ExpectedConditions.visibilityOf(Book1));
        Book1.click();
        return new HomePage(driver);
    }


    public boolean itemAddedSuccessfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return addedSuccessfully.isDisplayed();
    }





}
