package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterResultPage extends BasePage {


    public RegisterResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#main > div > div > div > div.page-body > div.result")
    private WebElement RegistrationCompleteMSG;

    public boolean isRegistrationMessageDisplayed(){
        return RegistrationCompleteMSG.isDisplayed();
    }

}
