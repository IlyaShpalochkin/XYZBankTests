package tests;

import constants.Constants;
import helpers.AlertHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.Epic;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
    @Test
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
        customersPage.waitingIlyaCustomerVisible();
        Assert.assertEquals(customersPage.getFirstNameAtLastCustomer(), "Ilya", "Имя последнего клиента в списке не Ilya");
        Assert.assertEquals(customersPage.getLastNameAtLastCustomer(), "Ponomarev", "Фамилия последнего клиента в списке не Ponomarev");
        Assert.assertEquals(customersPage.getPostCodeAtLastCustomer(), "Code1111", "Почтовый индекс последнего клиента в списке не Code1111");
    }


}
