import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

import java.util.List;

public class ColourTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/stroopeffect.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() throws InterruptedException{
        driver.get(BASE_URL);

        /*List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class, 'colours')]/h1"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
            System.out.println(title.getCssValue("color"));
            String hexColor;
            hexColor = Color.fromString(title.getCssValue("color")).asHex();
            System.out.println(hexColor);
        }*/

        String rgba = driver.findElement(By.xpath("//div[contains(@class, 'colours')]/h1[1]")).getCssValue("color");
        String hexColor = Color.fromString(rgba).asHex();
        Assert.assertEquals("#ff0e0e", hexColor);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
