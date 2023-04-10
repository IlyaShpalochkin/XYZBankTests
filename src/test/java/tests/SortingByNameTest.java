package tests;

import constants.Constants;
import io.qameta.allure.Severity;
import io.qameta.allure.Epic;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


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
    @Test
    public void sortingByNameTest() {
        driver.get(Constants.MAIN_PAGE);
        mainPage.clickCustomersButton();
        customersPage.waitingLoadingListCustomersSize(5);
        ArrayList<String> firstNameFirstList = customersPage.firstNameCustomersList();
        customersPage.clickSortByFirstNameButton();
        ArrayList<String> reverseSortFirstNameList = customersPage.firstNameCustomersList();
        Collections.sort(firstNameFirstList, Collections.reverseOrder());
        Assert.assertEquals(firstNameFirstList, reverseSortFirstNameList, "Список не отсортирован в обратном порядке");
        customersPage.clickSortByFirstNameButton();
        ArrayList<String> sortFirstNameList = customersPage.firstNameCustomersList();
        Collections.sort(firstNameFirstList);
        Assert.assertEquals(sortFirstNameList, firstNameFirstList, "Список не отсортирован в алфовитном порядке");
    }
}
