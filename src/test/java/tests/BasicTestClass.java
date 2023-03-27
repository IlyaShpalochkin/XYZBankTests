package tests;

import chromeDriver.GetChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

abstract public class BasicTestClass {
    protected WebDriver driver;

    @BeforeMethod
    public void driver() {
        driver = GetChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
