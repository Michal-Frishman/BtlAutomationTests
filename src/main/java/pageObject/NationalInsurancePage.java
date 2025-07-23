package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NationalInsurancePage extends BtlBasePage {
    public NationalInsurancePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.tagName("h1")).getText();
    }

    public void clickCalculatorLink() {
        driver.findElement(By.linkText("מחשבון לחישוב דמי הביטוח")).click();
    }
}
