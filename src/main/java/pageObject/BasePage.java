package pageObject;

import enums.TopMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigate(TopMenuEnum mainNavigate){
        driver.findElement(By.linkText(mainNavigate.getTopMenu()));
    }

    public void navigate(String subMenu){
    }
}
