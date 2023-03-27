package helpers;

import com.beust.ah.A;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
    @Step("Получение текста aler'a")
    public static String getAlertMessage(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    @Step("Нажатие кнопки Ок в alert'e")
    public static void clickOkButton(WebDriver driver) {
        driver.switchTo().alert().accept();
    }
}