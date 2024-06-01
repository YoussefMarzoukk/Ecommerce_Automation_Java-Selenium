package com.nopcommerce.demo.base;

import com.nopcommerce.demo.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new DriverFactory().initDriver();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void teardown() {

        driver.quit();
    }

    //Data For LoginTC
    @DataProvider(name = "Valid_Login_Data")
    public static Object[][] ValidLogin() {
        return new Object[][]{{"youssefmarzouk111@gmail.com","STG77aug"}};
    }
    @DataProvider(name = "InValid_Login_Pass")
    public static Object[][] InValidLogin1() {
        return new Object[][]{{"youssefmarzouk111@gmail.com","STGG77aug"}};
    }
    @DataProvider(name = "InValid_Login_email")
    public static Object[][] InValidLogin2() {
        return new Object[][]{{".com","STG77aug"}};
    }
//DATA FOR REGISTRATION
    @DataProvider(name="Valid_Registration_Data")
    public static Object[][]Valid_Registration(){
        return new Object[][]{{"Youssef","Marzouk","test123t3@test.com","Youssef123"}};
    }
    @DataProvider(name="InValid_Registration_Data(InvalidFirstName)")
    public static Object[][]InvalidFirstName(){
        return new Object[][]{{"","Marzouk","testqt@test.com","Youssef123"}};
    }
    @DataProvider(name="InValid_Registration_Data(InvalidLastName)")
    public static Object[][]InvalidLastName(){
        return new Object[][]{{"Youssef","","testqt@test.com","Youssef123"}};
    }
    @DataProvider(name="InValid_Registration_Data(InvalidEmail)")
    public static Object[][]InvalidEmail(){
        return new Object[][]{{"Youssef","Marzouk","test","Youssef123"}};
    }
    @DataProvider(name="InValid_Registration_Data(DuplicateEmail)")
    public static Object[][]DuplicateEmail(){
        return new Object[][]{{"Youssef","Marzouk","youssefmarzouk111@gmail.com","Youssef123"}};
    }




}
