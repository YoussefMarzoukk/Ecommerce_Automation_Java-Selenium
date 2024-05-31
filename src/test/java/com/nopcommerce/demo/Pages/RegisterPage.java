package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {
    //supers
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
//~Web Elements~
    @FindBy(css = "#gender-male")
    private WebElement genderMale;
    @FindBy(css = "#gender-female")
    private WebElement genderFemale;
    @FindBy(css = "#FirstName")
    private WebElement firstName;
    @FindBy(css = "#LastName")
    private WebElement lastName;
    @FindBy(css = "#main > div > div > div > div.page-body > form > div:nth-child(1) > div.form-fields > div.inputs.date-of-birth > div > select:nth-child(1)")
    private WebElement DOBDay;
    @FindBy(css = "#main > div > div > div > div.page-body > form > div:nth-child(1) > div.form-fields > div.inputs.date-of-birth > div > select:nth-child(2)")
    private WebElement DOBMonth;
    @FindBy(css = "#main > div > div > div > div.page-body > form > div:nth-child(1) > div.form-fields > div.inputs.date-of-birth > div > select:nth-child(3)")
    private WebElement DOBYear;
    @FindBy(css = "#Email")
    private WebElement email;
    @FindBy(css = "#Company")
    private WebElement company;
    @FindBy(css = "#Newsletter")
    private WebElement newsLetterButton;
    @FindBy(css = "#Password")
    private WebElement password;
    @FindBy(css = "#ConfirmPassword")
    private WebElement confirmPassword;
    @FindBy(name = "register-button")
    private WebElement registerButton;
    @FindBy (css="#main > div > div > div > div.page-body > div.buttons > a")
    private WebElement finishRegistration;

    //~Errors and Messages~


    @FindBy(id="Email-error")
    private WebElement invalidEmailError;
    @FindBy(css = "#main > div > div > div > div.page-body > form > div.message-error.validation-summary-errors > ul > li")
    private WebElement duplicateEmailError;
    @FindBy(id="FirstName-error")
    private WebElement firstNameError;
    @FindBy(id="LastName-error")
    private WebElement lastNameError;
    @FindBy(xpath="//*[@id='Password-error']/p")
    private WebElement invalidPassword;
    @FindBy(id="ConfirmPassword-error")
    private WebElement confirmPasswordError;


    public RegisterResultPage Register(String FirstName,String LastName,String Email,String Password,String ConfirmPassword) {
        genderMale.click();
        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        email.sendKeys(Email);
        newsLetterButton.click();
        password.sendKeys(Password);
        confirmPassword.sendKeys(ConfirmPassword);
        registerButton.click();
        return new RegisterResultPage(driver);


    }




    public boolean isInvalidEmailErrorDisplayed() {
        return invalidEmailError.isDisplayed();
    }

    public boolean isDuplicateEmailErrorDisplayed() {
        return duplicateEmailError.isDisplayed();
    }

    public boolean isFirstNameErrorDisplayed() {
        return firstNameError.isDisplayed();
    }

    public boolean isLastNameErrorDisplayed() {
        return lastNameError.isDisplayed();
    }

    public boolean isInvalidPasswordErrorDisplayed() {
        return invalidPassword.isDisplayed();
    }

    public boolean isConfirmPasswordErrorDisplayed() {
        return confirmPasswordError.isDisplayed();
    }


}
