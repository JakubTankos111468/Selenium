import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SemaforTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/semafor.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        String expectedGreen = "rgb(10, 129, 0)";
        String expectedRed = "rgb(205, 58, 63)";
        String expectedOrange = "rgb(191, 111, 7)";

        driver.get(BASE_URL);
        Actions actions = new Actions(driver);

        WebElement trafficLight = driver.findElement(By.className("light"));
        String actualRedColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedRed,actualRedColor);

        actions.moveToElement(trafficLight).build().perform();
        String actualGreenColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedGreen,actualGreenColor);

        actions.clickAndHold(trafficLight).build().perform();
        String actualOrange = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedOrange,actualOrange);

    }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
