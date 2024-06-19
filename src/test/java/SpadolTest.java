
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class SpadolTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/vybersi.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
        String actualTitle = driver.findElement(By.xpath("//div[contains(@class, 'pokemon')]/h3")).getText();
        Assert.assertTrue(actualTitle.contains("Pikachu"));

    }
    @After
    public void tearDown() throws IOException {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenShot, new File("C://tmp/screenshot.png"));
        driver.getPageSource();
    }
}
