package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css ="#Email" )
    private WebElement email;
    @FindBy(css ="#Password" )
    private WebElement password;
    @FindBy(css ="#RememberMe" )
    private WebElement rememberMeButton;
    @FindBy(css = ".login-button")
    private WebElement loginButton;
    @FindBy(css = ".register-button")
    private WebElement registerButton;
    @FindBy(css = "#Email-error")
    private WebElement invalidEmailMsg;
    @FindBy(css = ".validation-summary-errors")
    private WebElement invalidPassword;



    public HomePage login(String Email, String Password){
        email.sendKeys(Email);
        password.sendKeys(Password);
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        return new HomePage(driver);
    }
    public boolean wrongPassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return invalidPassword.isDisplayed();
    }
    public boolean wrongEmail() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return invalidEmailMsg.isDisplayed();
    }

}

