package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waiting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CustomersPage {

    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[last()]//td)[2]")
    private WebElement lastNameLastCustomerTd;


    @FindBy(xpath = "((//tr[contains(@class,'ng-scope')])[1]//td)[1]")
    private WebElement nameFirstCustomerTd;

    @FindBy(xpath = "//a[contains(text(),'First Name')]")
    private WebElement sortByFirstNameButton;

    @FindBy(css = "[placeholder='Search Customer']")
    private WebElement searchCustomerInput;

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;


    public String getPostCodeFirstCustomerText() {
        return getRows().get(0).getCellText(2);
    }


    public String getLastNameFirstCustomerText() {
        return getRows().get(0).getCellText(1);
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

    public String getFirstNameFirstCustomer() {
        return getRows().get(0).getCellText(0);
    }


    public ArrayList<String> getFirstNameCustomers() {
        var firstCustomerName = new CustomersPage(driver)
                .getRows()
                .stream()
                .map(it -> it.getCellText(0))
                .collect(Collectors.toList());
        return (ArrayList) firstCustomerName;
    }

    public List<Row> getRows() {
        var newList = new ArrayList<Row>();
        for (WebElement row : rows) {
            newList.add(new Row(row));
        }
        return newList;
    }

    public String getPostCodeAtLastCustomer() {
        return getRows().get(5).getCellText(2);
    }

    public String getLastNameAtLastCustomer() {
        return getRows().get(5).getCellText(1);
    }

    @Step("Ожидание появления последнего клиента")
    public void waitingLastNameAtLastCustomerVisible() {
        Waiting.waitingElementsDisplay(lastNameLastCustomerTd, driver);
    }

    public String getFirstNameAtLastCustomer() {
        return getRows().get(5).getCellText(0);
    }
}
