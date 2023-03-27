package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waiting;

import static org.openqa.selenium.support.PageFactory.initElements;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(css = "[ng-click*='addCust']")
    private WebElement addCustomerButton;

    @FindBy(css = "[ng-click*='showCust()']")
    private WebElement customersButton;


    @Step("Нажатие на кнопку Customers")
    public MainPage clickCustomersButton() {
        Waiting.waitingElementsDisplay(customersButton, driver).click();
        return this;
    }

    @Step("Нажатие на кнопку Add Customer")
    public MainPage clickAddCustomerButton() {
        Waiting.waitingElementsDisplay(addCustomerButton, driver).click();
        return this;
    }


}
