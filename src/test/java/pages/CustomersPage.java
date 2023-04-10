package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//a[contains(text(),'First Name')]")
    private WebElement sortByFirstNameButton;

    @FindBy(css = "[placeholder='Search Customer']")
    private WebElement searchCustomerInput;

    @FindBy(css = "tbody tr")
    private List<WebElement> rowsList;

    private By rows = By.cssSelector("tbody tr");

    public String getPostCodeFirstCustomerText() {
        return getRowsList().get(0).getCellText(2);
    }

    public String getLastNameFirstCustomerText() {
        return getRowsList().get(0).getCellText(1);
    }

    @Step("Ввод данных в поле Search Customer")
    public CustomersPage fillSearchCustomerInput(String input) {
        searchCustomerInput.clear();
        searchCustomerInput.sendKeys(input);
        return this;
    }

    @Step("Нажатие кнопки для сортировки по первому имени")
    public CustomersPage clickSortByFirstNameButton() {
        Waiting.waitingElementDisplayByWebelement(sortByFirstNameButton, driver).click();
        return this;
    }

    public String getFirstNameFirstCustomer() {
        return getRowsList().get(0).getCellText(0);
    }

    public ArrayList<String> firstNameCustomersList() {
        return (ArrayList<String>) new CustomersPage(driver).getRowsList().stream().map(it -> it.getCellText(0)).collect(Collectors.toList());
    }

    public List<Row> getRowsList() {
        var newList = new ArrayList<Row>();
        for (WebElement row : rowsList) {
            newList.add(new Row(row));
        }
        return newList;
    }

    public String getPostCodeAtLastCustomer() {
        return getRowsList().get(getRowsList().size() - 1).getCellText(2);
    }

    public String getLastNameAtLastCustomer() {
        return getRowsList().get(getRowsList().size() - 1).getCellText(1);
    }

    public String getFirstNameAtLastCustomer() {
        return getRowsList().get(getRowsList().size() - 1).getCellText(0);
    }

    @Step("Ожидание прогрузки списка строк с размером size")
    public void waitingLoadingListCustomersSize(Integer size) {
        Waiting.waitingLoadingElementsListSize(rows, size, driver);
    }

    @Step("Ожидание ячейки с текстом text")
    public CustomersPage waitingCellWithTextVisible(String text) {
        Waiting.waitingElementDisplayByLocator((By.xpath("//td[text()='" + text + "']")), driver);
        return this;
    }
}
