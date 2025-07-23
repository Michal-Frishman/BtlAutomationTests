package pageObject;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;

public class InsuranceCalculatorPage extends BtlBasePage {
    public InsuranceCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isStepOneVisible() {
        return driver.findElement(By.xpath("//h2[contains(text(),'צעד ראשון')]")).isDisplayed();
    }

    public void fillStepOne(String birthDate) {
        WebElement employeeRadio = driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_employeType_2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", employeeRadio);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", employeeRadio);

        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_rdb_Gender_0")).click();

        WebElement birthDateField = driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_DynDatePicker_BirthDate_Date"));
        birthDateField.sendKeys(birthDate);
        birthDateField.sendKeys(Keys.ENTER);
    }


    public void clickNext() {
        driver.findElement(By.id("ctl00_ctl43_g_642b1586_5c41_436a_a04c_e3b5ba94ba69_ctl00_InsuranceNotSachirWizard_StartNavigationTemplateContainerID_StartNextButton")).click(); // התאמה לפי ID האמיתי באתר
    }
}
