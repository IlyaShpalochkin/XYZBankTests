package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waiting;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CustomersPage {

    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[6]//td)[1]")
    private WebElement fistNameSixthCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[6]//td)[2]")
    private WebElement lastNameSixthCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[6]//td)[3]")
    private WebElement postCodeSixthCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[1]//td)[1]")
    private WebElement firstNameFirstCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[2]//td)[1]")
    private WebElement firstNameSecondCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[3]//td)[1]")
    private WebElement firstNameThirdCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[4]//td)[1]")
    private WebElement firstNameFourthCustomerTd;

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[5]//td)[1]")
    private WebElement firstNameFifthCustomerTd;

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
        sortByFirstNameButton.click();
        return this;
    }

    @Step("Получение первого имени пятого клиента из списка")
    public String getFirstNameFifthCustomer() {
        return firstNameFifthCustomerTd.getText();
    }

    @Step("Получение первого имени четвертого клиента из списка")
    public String getFirstNameFourthCustomer() {
        return firstNameFourthCustomerTd.getText();
    }


    @Step("Получение первого имени третьего клиента из списка")
    public String getFirstNameThirdCustomer() {
        return firstNameThirdCustomerTd.getText();
    }


    @Step("Получение первого имени второго клиента из списка")
    public String getFirstNameSecondCustomer() {
        return firstNameSecondCustomerTd.getText();
    }

    @Step("Получение первого имени первого клиента из списка")
    public String getFirstNameFirstCustomer() {
        return Waiting.waitingElementsDisplay(firstNameFirstCustomerTd, driver).getText();
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
        return Waiting.waitingElementsDisplay(fistNameSixthCustomerTd, driver).getText();
    }
}
