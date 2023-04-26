package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.Waiting;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AddCustomerPage {

    private WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(css = "[ng-model='fName']")
    private WebElement firstNameInput;

    @FindBy(css = "[ng-model='lName']")
    private WebElement lastNameInput;

    @FindBy(css = "[ng-model='postCd']")
    private WebElement postCodeInput;

    @FindBy(xpath = "//button[text()='Add Customer']")
    private WebElement addCustomerButton;

    @Step("Нажатие на кнопку Add Customer")
    public AddCustomerPage clickAddCustomerButton() {
        addCustomerButton.click();
        return this;
    }

    @Step("Ввод данных в поле Post Code")
    public AddCustomerPage fillPostCodeInput(String postCode) {
        postCodeInput.sendKeys(postCode);
        return this;
    }

    @Step("Ввод данных в поле Last Name")
    public AddCustomerPage fillLastNameInput(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Ввод данных в поле First Name")
    public AddCustomerPage fillFirstNameInput(String firstName) {
        Waiting.waitUntilVisibilityOfElement(firstNameInput, driver).sendKeys(firstName);
        return this;
    }
}
