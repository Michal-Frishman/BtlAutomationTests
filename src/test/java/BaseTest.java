import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static ExtentSparkReporter reporter;
    protected WebDriver driver;

    @BeforeEach
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.btl.gov.il/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @BeforeAll
    public static void setupReport() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        reporter = new ExtentSparkReporter("./target/test-output/ExtentReport_" + timestamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void testSearch() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.Search("חישוב סכום דמי לידה ליום");
        Thread.sleep(3000);
        ResultsPage resultsPage = new ResultsPage(driver);
        String actualTitle = resultsPage.getResultsTitle("//div//h1[contains(text(),'חישוב סכום דמי לידה ליום')]");
        Assertions.assertEquals("חישוב סכום דמי לידה ליום", actualTitle, "Title does not match!");
    }

    @Test
    public void testBranches() {
        HomePage home = new HomePage(driver);
        BranchesPage branchesPage = home.getBranchesPage();

        Assertions.assertEquals("סניפים וערוצי שירות", branchesPage.getPageTitle(), "Title mismatch");

        branchesPage.clickBranchByName("אשדוד");

        Assertions.assertNotNull(branchesPage.getLabelText("כתובת"));
        Assertions.assertNotNull(branchesPage.getLabelText("קבלת קהל"));
        Assertions.assertNotNull(branchesPage.getLabelText("מענה טלפוני"));
    }

    @Test
    @Description("בדיקת מחשבון חישוב דמי ביטוח לבחור ישיבה")
    public void testYeshivaStudentInsuranceCalculation() {
        HomePage home = new HomePage(driver);
        home.navigateToInsurancePage();

        NationalInsurancePage insurancePage = new NationalInsurancePage(driver);
        Assertions.assertEquals("דמי ביטוח לאומי", insurancePage.getPageTitle());

        insurancePage.clickCalculatorLink();

        InsuranceCalculatorPage step1 = new InsuranceCalculatorPage(driver);
        Assertions.assertTrue(step1.isStepOneVisible());

        step1.fillStepOne("11/01/2006");
        step1.clickNext();

        InsuranceCalculatorStep2Page step2 = new InsuranceCalculatorStep2Page(driver);
        Assertions.assertTrue(step2.isStepTwoVisible());

        step2.selectDisabilityPension();
        step2.clickNext();

        InsuranceCalculatorResultsPage resultsPage = new InsuranceCalculatorResultsPage(driver);
        Assertions.assertTrue(resultsPage.isResultsVisible());
        String totalAmount = resultsPage.getTotalAmount();
        Assertions.assertTrue(totalAmount.contains("163"), "error in totalAmount");
    }

}
