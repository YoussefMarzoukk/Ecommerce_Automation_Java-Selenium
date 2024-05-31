package com.nopcommerce.demo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    private WebDriver driver;

    public WebDriver initDriver(){
    String browser = System.getProperty("browser","CHROME");
    switch (browser){
        case "CHROME":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "EDGE":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        default:
            throw new RuntimeException("Unable to find browser");



    }
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.manage().window().maximize();

    return driver;

}

}
