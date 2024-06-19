import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackForwardTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/registracia.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        String email = "brano@manohy.sk";
        driver.findElement(By.name("email")).sendKeys("brano@manohy.sk");
        driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();

        driver.navigate().back();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        Assert.assertEquals(email, driver.findElement(By.name("email")).getAttribute("value"));


    }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
