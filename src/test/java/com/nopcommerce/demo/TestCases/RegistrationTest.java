package com.nopcommerce.demo.TestCases;

import com.nopcommerce.demo.Pages.HomePage;
import com.nopcommerce.demo.Pages.LoginPage;
import com.nopcommerce.demo.Pages.RegisterPage;
import com.nopcommerce.demo.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

//~~VALID~~
@Test(dataProvider = "Valid_Registration_Data")
    public void validRegistration(String firstname, String lastname,String email,String password){
    HomePage homePage = new HomePage(driver);
     boolean IsRegSuccessful = homePage.load()
             .register()
             .Register(firstname,lastname,email,password,password).isRegistrationMessageDisplayed();
    Assert.assertTrue(IsRegSuccessful);
}

//~~INVALID~~
   @Test (dataProvider="InValid_Registration_Data(InvalidFirstName)")
   public void InvalidRegistration_fname(String firstname, String lastname,String email,String password){
       HomePage homePage = new HomePage(driver);
       homePage.load()
               .register()
               .Register(firstname,lastname,email,password,password);
       RegisterPage registerPage = new RegisterPage(driver);
       boolean fNameError = registerPage.isFirstNameErrorDisplayed();
       Assert.assertTrue(fNameError);
   }
    @Test (dataProvider="InValid_Registration_Data(InvalidLastName)")
    public void InvalidRegistration_lname(String firstname, String lastname,String email,String password){
        HomePage homePage = new HomePage(driver);
        homePage.load()
                .register()
                .Register(firstname,lastname,email,password,password);
        RegisterPage registerPage = new RegisterPage(driver);
        boolean lNameError = registerPage.isLastNameErrorDisplayed();
        Assert.assertTrue(lNameError);

    }
    @Test (dataProvider="InValid_Registration_Data(InvalidEmail)")
    public void InvalidRegistration_email(String firstname, String lastname,String email,String password){
        HomePage homePage = new HomePage(driver);
        homePage.load()
                .register()
                .Register(firstname,lastname,email,password,password);
        RegisterPage registerPage = new RegisterPage(driver);
        boolean InvalidEmailError = registerPage.isInvalidEmailErrorDisplayed();
        Assert.assertTrue(InvalidEmailError);
    }
    @Test (dataProvider="InValid_Registration_Data(DuplicateEmail)")
    public void InvalidRegistration_duplicate_email(String firstname, String lastname,String email,String password){
        HomePage homePage = new HomePage(driver);
        homePage.load()
                .register()
                .Register(firstname,lastname,email,password,password);
        RegisterPage registerPage = new RegisterPage(driver);
        boolean DuplicateEmailError = registerPage.isDuplicateEmailErrorDisplayed();
        Assert.assertTrue(DuplicateEmailError);
    }



}
