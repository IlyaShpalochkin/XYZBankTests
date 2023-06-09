package tests;

import chromeDriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

abstract public class BasicTestClass {
    protected WebDriver driver;

    @BeforeMethod
    public void driver() {
        driver = DriverManager.getChromeDriver();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
