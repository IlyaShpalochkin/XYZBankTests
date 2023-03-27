package tests;

import constants.Constants;
import helpers.AlertHelper;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomersPage;
import pages.MainPage;


@Epic("Тесты сайта globalsqa")

public class CreateCustomerTest extends BasicTestClass {
    public MainPage mainPage;
    public AddCustomerPage addCustomerPage;

    public CustomersPage customersPage;

    @BeforeMethod
    public void beforeTest() {
        mainPage = new MainPage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        customersPage = new CustomersPage(driver);
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты на главной странице")
    @Story("Добавление клиента")
    @Test(priority = 1)
    public void createClientTest() {
        driver.get(Constants.MAIN_PAGE);
        mainPage.clickAddCustomerButton();
        addCustomerPage.fillFirstNameInput("Ilya")
                .fillLastNameInput("Ponomarev")
                .fillPostCodeInput("Code1111")
                .clickAddCustomerButton();
        Assert.assertEquals(AlertHelper.getAlertMessage(driver), "Customer added successfully with customer id :6");
        AlertHelper.clickOkButton(driver);
        mainPage.clickCustomersButton();
        Assert.assertEquals(customersPage.getFirstNameAtSixthCustomer(), "Ilya");
        Assert.assertEquals(customersPage.getLastNameAtSixthCustomer(), "Ponomarev");
        Assert.assertEquals(customersPage.getPostCodeAtSixthCustomer(), "Code1111");
    }


}