package com.nopcommerce.demo.TestCases;

import com.nopcommerce.demo.Pages.HomePage;
import com.nopcommerce.demo.Pages.LoginPage;
import com.nopcommerce.demo.base.BaseTest;
import com.nopcommerce.demo.utils.ConfigUtils;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test(dataProvider="Valid_Login_Data",enabled=false)
    public void UserShouldBeAbleToLogIn(String email, String password) {

        HomePage homePage = new HomePage(driver);
        boolean successfulLogin = homePage
                .load()
                .login()
                .login(email,password)
                .successfulLogin();
        Assert.assertTrue(successfulLogin);
    }

    @Test(dataProvider="InValid_Login_Pass")
    public void InvalidLogin_Passowrd(String email, String password){
        HomePage homePage = new HomePage(driver);
        homePage
                .load()
                .login()
                .login(email,password);
        LoginPage loginPage = new LoginPage(driver);
        boolean wrongPass = loginPage.wrongPassword();
        Assert.assertTrue(wrongPass);


    }

    @Test(dataProvider="InValid_Login_email")
    public void InvalidLogin_email(String email, String password){
        HomePage homePage = new HomePage(driver);
        homePage
                .load()
                .login()
                .login(email,password);
        LoginPage loginPage = new LoginPage(driver);
        boolean wrongPass = loginPage.wrongEmail();
        Assert.assertTrue(loginPage.wrongEmail());


    }
}
