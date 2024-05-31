package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoveryPage extends BasePage {

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Email")
    private WebElement emailRecovery;
    @FindBy(css=".password-recovery-button")
    private WebElement recoverButton;
    @FindBy(css="#bar-notification > div")
    private WebElement recoveryEmailSuccess;

    public void setEmailRecovery(String email){
        emailRecovery.sendKeys(email);
        recoverButton.click();
    }


}
