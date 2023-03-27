package tests;

import constants.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomersPage;
import pages.MainPage;

@Epic("Тесты сайта globalsqa")

public class SortingByNameTest extends BasicTestClass {

    public MainPage mainPage;
    public CustomersPage customersPage;

    @BeforeMethod
    public void beforeTest() {
        mainPage = new MainPage(driver);
        customersPage = new CustomersPage(driver);
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Feature("Тесты на главной странице")
    @Story("Сортировка по имени")
    @Test(priority = 1)
    public void sortingByNameTest() {
        driver.get(Constants.MAIN_PAGE);
        mainPage.clickCustomersButton();
        Assert.assertEquals(customersPage.getFirstNameFirstCustomer(), "Hermoine");
        customersPage.clickSortByFirstNameButton();
        Assert.assertEquals(customersPage.getFirstNameFirstCustomer(), "Ron");
        Assert.assertEquals(customersPage.getFirstNameSecondCustomer(), "Neville");
        Assert.assertEquals(customersPage.getFirstNameThirdCustomer(), "Hermoine");
        Assert.assertEquals(customersPage.getFirstNameFourthCustomer(), "Harry");
        Assert.assertEquals(customersPage.getFirstNameFifthCustomer(), "Albus");
        customersPage.clickSortByFirstNameButton();
        Assert.assertEquals(customersPage.getFirstNameFirstCustomer(), "Albus");
        Assert.assertEquals(customersPage.getFirstNameSecondCustomer(), "Harry");
        Assert.assertEquals(customersPage.getFirstNameThirdCustomer(), "Hermoine");
        Assert.assertEquals(customersPage.getFirstNameFourthCustomer(), "Neville");
        Assert.assertEquals(customersPage.getFirstNameFifthCustomer(), "Ron");
    }


}
