package tests.globalsqa;

import constants.Constants;
import io.qameta.allure.Severity;
import io.qameta.allure.Epic;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.MainPage;
import tests.BasicTestClass;

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
        customersPage.waitingUntilNumberOfRowsToBeSize(5);
        customersPage.fillSearchCustomerInput("Harry");
        Assert.assertEquals(customersPage.getFirstCustomerFirstName(), "Harry", "Первое имя первого клиента в списке не Harry");
        customersPage.fillSearchCustomerInput("Granger");
        Assert.assertEquals(customersPage.getLastNameFirstCustomer(), "Granger", "Фамилия первого клиента в списке не Granger");
        customersPage.fillSearchCustomerInput("E55656");
        Assert.assertEquals(customersPage.getPostCodeFirstCustomer(), "E55656", "Почтовый индекс первого клиента в списке не E55656");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}
