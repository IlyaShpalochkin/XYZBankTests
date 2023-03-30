package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<Row> getRows() {
        var newList = new ArrayList<Row>();
        for (WebElement row : rows) {
            newList.add(new Row(row));
        }
        return newList;
    }
}

