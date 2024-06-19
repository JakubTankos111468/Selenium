
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TabulkaTest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/tabulka.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for (WebElement row : rows) {
            //System.out.println(row.getText());
            //System.out.println(row.findElement(By.xpath("./td[3]")).getText());
            Assert.assertFalse(row.findElement(By.xpath("./td[3]")).getText().isEmpty());
        }


        //System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        /*int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());

        for (int i = 1; i < rows; i++) {
            System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[3]")).getText().isEmpty());
        }
*/
    }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
