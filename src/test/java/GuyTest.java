//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.util.Assert;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//public class GuyTest {
//    @Test
//    public void testInsuranceCalculationForYeshivaStudent() throws InterruptedException {
//        // שלב 1: גישה לדף דמי ביטוח לאומי
//        WebElement insuranceLink = driver.findElement(By.linkText("דמי ביטוח"));
//        insuranceLink.click();
//
//        String expectedTitle = "דמי ביטוח לאומי";
//        Thread.sleep(3000);
//        WebElement actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'דמי ביטוח לאומי')]"));
//        Assertions.assertEquals(expectedTitle, actualTitle.getText());
//
//        // שלב 2: גישה למחשבון דמי ביטוח
//        WebElement calculatorLink = driver.findElement(By.linkText("מחשבון לחישוב דמי ביטוח"));
//        calculatorLink.click();
//
//        String expectedCalculatorTitle = "חישוב דמי ביטוח עבור עצמאי, תלמיד, שוהה בחוץ לארץ ומי שלא עובד";
//        Thread.sleep(3000);
//        WebElement actualCalculatorTitle = driver.findElement(By.xpath("//h1[contains(text(),'חישוב דמי ביטוח עבור עצמאי')]"));
//        Assertions.assertEquals(expectedCalculatorTitle, actualCalculatorTitle.getText());
//
//        // שלב 3: חישוב דמי ביטוח עבור תלמיד ישיבה
//        // הגדרת תאריך לידה
//        LocalDateTime birthDate = LocalDateTime.now().minusYears(18).minusDays(1); // תאריך לידה 18 שנה אחורה
//        String formattedDate = birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
//        WebElement birthDateField = driver.findElement(By.id("birthDate")); // עדכן את ה-selector לפי הצורך
//        birthDateField.sendKeys(formattedDate);
//
//        // מקבל קצבת נכות
//        WebElement disabilityBenefitField = driver.findElement(By.id("disabilityBenefit")); // עדכן את ה-selector לפי הצורך
//        disabilityBenefitField.sendKeys("לא");
//
//        // לחיצה על המשך
//        WebElement continueButton = driver.findElement(By.id("continueButton")); // עדכן את ה-selector לפי הצורך
//        continueButton.click();
//
//        // שלב 4: בדיקת הגעה לשלב סיום
//        Thread.sleep(3000);
//        String expectedFinalTitle = "סיום חישוב דמי ביטוח"; // עדכן את הכותרת הצפויה
//        WebElement actualFinalTitle = driver.findElement(By.xpath("//h1[contains(text(),'סיום חישוב דמי ביטוח')]"));
//        Assertions.assertEquals(expectedFinalTitle, actualFinalTitle.getText());
//
//        // בדיקת תוצאות החישוב
//        WebElement insuranceFee = driver.findElement(By.id("insuranceFee")); // עדכן את ה-selector לפי הצורך
//        WebElement healthInsuranceFee = driver.findElement(By.id("healthInsuranceFee")); // עדכן את ה-selector לפי הצורך
//        WebElement totalFee = driver.findElement(By.id("totalFee")); // עדכן את ה-selector לפי הצורך
//
//        Assertions.assertEquals("43 ש\"ח", insuranceFee.getText());
//        Assertions.assertEquals("120.00 ש\"ח", healthInsuranceFee.getText());
//        Assertions.assertEquals("163 ש\"ח", totalFee.getText());
//    }
//
//}
