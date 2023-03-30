package tests;

import constants.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.MainPage;
import pages.TablePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

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
    @Test
    public void sortingByNameTest() {
        var firstCustomerName = new TablePage(driver)
                .getRows()
                .stream()
                .map(it -> it.getCellText(0))
                .collect(Collectors.toList());
        driver.get(Constants.MAIN_PAGE);
        mainPage.clickCustomersButton();
        Assert.assertEquals(customersPage.getFirstNameFirstCustomer(), "Hermoine");
        ArrayList<String> firstNameFirstList = (ArrayList<String>) firstCustomerName;
        customersPage.clickSortByFirstNameButton();
        String reverseSortFirstNameList = firstCustomerName.toString();
        Collections.sort(firstNameFirstList, Collections.reverseOrder());
        Assert.assertEquals(firstNameFirstList, reverseSortFirstNameList);
        customersPage.clickSortByFirstNameButton();
        ArrayList<String> sortFirstNameList = (ArrayList<String>) firstCustomerName;
        Collections.sort(firstNameFirstList);
        Assert.assertEquals(sortFirstNameList, firstNameFirstList);
    }
}
