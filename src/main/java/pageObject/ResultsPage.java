package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BtlBasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getResultsTitle(String xpath) {
        WebElement titleElement = driver.findElement(By.xpath(xpath));
        return titleElement.getText();
    }
}
