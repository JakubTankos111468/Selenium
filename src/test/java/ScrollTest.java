import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/moveme.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        WebElement donald = driver.findElement(By.id("donald"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(donald).moveByOffset(1200,0).release().build().perform();

    }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
