package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsuranceCalculatorResultsPage extends BtlBasePage {
    public InsuranceCalculatorResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultsVisible() {
        return driver.findElement(By.id("header")).isDisplayed();
    }

    public String getTotalAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_div_Result']/ul/li[3]")
        ));
        return resultItem.getText();
    }
}
