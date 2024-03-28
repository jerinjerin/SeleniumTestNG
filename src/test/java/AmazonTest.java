import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTest extends BrowserManager{
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserManager.getDriver("chrome");
    }

    @Test
    public void testAmazonHomepage() throws InterruptedException {
        driver.get("https://www.amazon.in/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        WebElement continuebutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='nav-line-2 ' and text()='Account & Lists']")));
        continuebutton.click();
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("+91 9392118138");
        driver.findElement(By.xpath("//span[@class='a-button-inner']")).click();
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Girlboss27*");
        WebElement SignInbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='signInSubmit']")));
        SignInbutton.click();
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
