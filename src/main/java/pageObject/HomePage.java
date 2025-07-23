package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BtlBasePage {
    @FindBy(id = "ctl00_SiteHeader_reserve_btnSearch")
    WebElement searchIcon;
    @FindBy(id = "TopQuestions")
    WebElement searchField;

    @FindBy(id = "ctl00_Topmneu_BranchesHyperLink")
    WebElement BranchesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void Search(String stringForSearch) {
        searchField.sendKeys(stringForSearch);
        searchIcon.click();
    }

    public BranchesPage getBranchesPage() {
        BranchesButton.click();
        return new BranchesPage(super.driver);
    }
    public void navigateToInsurancePage() {
        driver.findElement(By.linkText("דמי ביטוח")).click();
        driver.findElement(By.linkText("דמי ביטוח לאומי")).click();
    }

}
