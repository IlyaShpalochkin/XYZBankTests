package tests;

import constants.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Collections;

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
        ArrayList<String> firstNameFirstList = customersPage.getFirstNameCustomersList();
        customersPage.clickSortByFirstNameButton();
        ArrayList<String> reverseSortFirstNameList = customersPage.getFirstNameCustomersList();
        Collections.sort(firstNameFirstList, Collections.reverseOrder());
        Assert.assertEquals(firstNameFirstList, reverseSortFirstNameList);
        customersPage.clickSortByFirstNameButton();
        ArrayList<String> sortFirstNameList = customersPage.getFirstNameCustomersList();
        Collections.sort(firstNameFirstList);
        Assert.assertEquals(sortFirstNameList, firstNameFirstList);
    }
}
