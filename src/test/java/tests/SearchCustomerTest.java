package tests;

import constants.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.MainPage;

@Epic("Тесты сайта globalsqa")

public class SearchCustomerTest extends BasicTestClass {

    public MainPage mainPage;
    public CustomersPage customersPage;

    @BeforeMethod
    public void beforeTest() {
        mainPage = new MainPage(driver);
        customersPage = new CustomersPage(driver);
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты на главной странице")
    @Story("Поиск клиента")
    @Test
    public void searchCustomerTest() {
        driver.get(Constants.MAIN_PAGE);
        mainPage.clickCustomersButton();
        Assert.assertEquals(customersPage.getFirstNameFirstCustomer(), "Hermoine");
        customersPage.fillSearchCustomerInput("Harry");
        Assert.assertEquals(customersPage.getFirstNameFirstCustomer(), "Harry");
        customersPage.fillSearchCustomerInput("Granger");
        Assert.assertEquals(customersPage.getLastNameFirstCustomerText(), "Granger");
        customersPage.fillSearchCustomerInput("E55656");
        Assert.assertEquals(customersPage.getPostCodeFirstCustomerText(), "E55656");

    }

}
