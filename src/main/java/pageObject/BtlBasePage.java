package pageObject;

import enums.TopMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BtlBasePage extends BasePage{

    public BtlBasePage(WebDriver driver){
        super(driver);
    }

    public void navigate(TopMenuEnum mainNavigate, String subMenu){
        driver.findElement(By.linkText(mainNavigate.getTopMenu()));
    }
}
