package com.nopcommerce.demo.Pages;

import com.nopcommerce.demo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement fname;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lname;

    @FindBy(xpath = "//*[@id='BillingNewAddress_CountryId']")
    private WebElement countryElement;
    private Select countrySelect;

    @FindBy(xpath = "//*[@id='BillingNewAddress_StateProvinceId']")
    private WebElement stateElement;
    private Select stateSelect;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1;

    @FindBy(id = "BillingNewAddress_Address2")
    private WebElement address2;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipcode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phone;

    @FindBy(id = "BillingNewAddress_FaxNumber")
    private WebElement fax;

    @FindBy(xpath = "(//button[contains(@class,'button-1 new-address-next-step-button')])[1]")
    private WebElement continue1;

    @FindBy(xpath = "//button[contains(@class,'button-1 shipping-method-next-step-button')]")
    private WebElement continue2;

    @FindBy(xpath = "//button[contains(@class,'button-1 payment-method-next-step-button')]")
    private WebElement continue3;

    @FindBy(xpath = "//button[contains(@class,'button-1 payment-info-next-step-button')]")
    private WebElement continue4;

    @FindBy(xpath = "(//a[contains(@href,'/digital')])[6]")
    private WebElement itemInfo;

    @FindBy(xpath = "//button[contains(@class,'button-1 confirm-order-next-step-button')]")
    private WebElement confirm;

    @FindBy(xpath = "(//strong)[1]")
    private WebElement successfulMessage;

    @FindBy(xpath = "//button[contains(@class,'button-1 order-completed-continue-button')]")
    private WebElement finishProcess;

    // Initialize Select elements for country and state
    public void initializeSelectElements() {
        countrySelect = new Select(countryElement);
        stateSelect = new Select(stateElement);
    }

    // Methods to interact with the elements
    public void selectCountryByIndex(int index) {
        countrySelect.selectByIndex(index);
    }

    public void selectStateByIndex(int index) {
        stateSelect.selectByIndex(index);
    }

    public void enterFirstName(String firstName) {
        fname.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lname.sendKeys(lastName);
    }

    public void enterCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void enterAddress1(String addr1) {
        address1.sendKeys(addr1);
    }

    public void enterAddress2(String addr2) {
        address2.sendKeys(addr2);
    }

    public void enterZipcode(String zip) {
        zipcode.sendKeys(zip);
    }

    public void enterPhone(String phoneNumber) {
        phone.sendKeys(phoneNumber);
    }

    public void enterFax(String faxNumber) {
        fax.sendKeys(faxNumber);
    }

    public void clickContinue1() {
        continue1.click();
    }

    public void clickContinue2() {
        continue2.click();
    }

    public void clickContinue3() {
        continue3.click();
    }

    public void clickContinue4() {
        continue4.click();
    }

    public void clickItemInfo() {
        itemInfo.click();
    }

    public void clickConfirm() {
        confirm.click();
    }

    public String getSuccessfulMessage() {
        return successfulMessage.getText();
    }

    public void clickFinishProcess() {
        finishProcess.click();
    }

    // Complete the checkout sequence
    public void checkOutSequence() {
        enterFirstName("Youssef");
        enterLastName("Marzouk");
        initializeSelectElements();
        selectCountryByIndex(1); // Select the second option in the country dropdown
        enterCity("New York");
        enterAddress1("123 Main St");
        enterAddress2("Apt 4B");
        enterZipcode("10001");
        enterPhone("1234567890");
        enterFax("0987654321");
        clickContinue1();
        clickContinue2();
        clickContinue3();
        clickContinue4();
        clickConfirm();
    }
}
