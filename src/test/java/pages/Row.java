package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Row {
    @FindBy(css = "td")
    private List<WebElement> cells;

    public Row(WebElement rootElement) {
        PageFactory.initElements(rootElement, this);
    }

    public String getCellText(int index) {
        return cells.get(index).getText();
    }
}
