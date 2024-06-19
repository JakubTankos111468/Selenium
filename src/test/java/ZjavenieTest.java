import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZjavenieTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/zjavenie.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);

        driver.findElement(By.id("showHim")).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//img[@class='brano']")));

        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='brano']")).isDisplayed());


    }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
