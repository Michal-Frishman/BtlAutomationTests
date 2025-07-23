package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BranchesPage extends BtlBasePage {
    public BranchesPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        WebElement titleElement = driver.findElement(By.xpath("//div//h1[contains(text(),'סניפים וערוצי שירות')]"));
        return titleElement.getText();
    }

    public void clickBranchByName(String branchName) {
        WebElement branch = driver.findElement(By.xpath("//a[contains(text(),'" + branchName + "')]"));
        branch.click();
    }

    public String getLabelText(String label) {
        WebElement labelElement = driver.findElement(By.xpath("//li//label[contains(text(),'" + label + "')]"));
        return labelElement.getText();
    }
}
