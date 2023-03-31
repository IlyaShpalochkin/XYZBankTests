package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.Waiting;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CustomersPage {

    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[6]//td)[1]")
    private WebElement firstNameSixthCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[6]//td)[2]")
    private WebElement lastNameSixthCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[6]//td)[3]")
    private WebElement postCodeSixthCustomerTd;

    @FindBy(xpath = "//tr[contains(@class,'ng-scope')]//td[1]")
    private List<WebElement> firstNameCustomersList;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[1]//td)[1]")
    private WebElement firstNameFirstCustomerTd;

    @FindBy(xpath = "//a[contains(text(),'First Name')]")
    private WebElement sortByFirstNameButton;

    @FindBy(css = "[placeholder='Search Customer']")
    private WebElement searchCustomerInput;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[1]//td)[2]")
    private WebElement lastNameFirstCustomer;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[1]//td)[3]")
    private WebElement postCodeFirstCustomer;

    @Step("Получение Почтового индекса первого пользователя из списка")
    public String getPostCodeFirstCustomerText() {
        return Waiting.waitingElementsDisplay(postCodeFirstCustomer, driver).getText();
    }


    @Step("Получение Фамилии первого пользователя из списка")
    public String getLastNameFirstCustomerText() {
        return Waiting.waitingElementsDisplay(lastNameFirstCustomer, driver).getText();
    }


    @Step("Ввод данных в поле Search Customer")
    public CustomersPage fillSearchCustomerInput(String input) {
        searchCustomerInput.clear();
        searchCustomerInput.sendKeys(input);
        return this;
    }

    @Step("Нажатие кнопки для сортировки по первому имени")
    public CustomersPage clickSortByFirstNameButton() {
        Waiting.waitingElementsDisplay(sortByFirstNameButton, driver).click();
        return this;
    }

    @Step("Получение первого имени пятого клиента из списка")
    public String getFirstNameFirstCustomer() {
        return Waiting.waitingElementsDisplay(firstNameFirstCustomerTd, driver).getText();
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;


    public List<Row> getRows() {
        var newList = new ArrayList<Row>();
        for (WebElement row : rows) {
            newList.add(new Row(row));
        }
        return newList;
    }


    @Step("Получение Post Code у шестого клиента")
    public String getPostCodeAtSixthCustomer() {
        return Waiting.waitingElementsDisplay(postCodeSixthCustomerTd, driver).getText();
    }

    @Step("Получение Last Name у шестого клиента")
    public String getLastNameAtSixthCustomer() {
        return Waiting.waitingElementsDisplay(lastNameSixthCustomerTd, driver).getText();
    }

    @Step("Получение First Name у шестого клиента")
    public String getFirstNameAtSixthCustomer() {
        return Waiting.waitingElementsDisplay(firstNameSixthCustomerTd, driver).getText();
    }
}
