import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Donaldtest {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost/playground/moveme.php";

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);

        driver.manage().window().maximize();

        WebElement donald = driver.findElement(By.id("donald"));
        WebElement finish = driver.findElement(By.id("tree"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald,finish).build().perform();


        WebElement expectedTitle = driver.findElement(By.xpath("//div[contains(@class, 'success')]/h2"));
        Assert.assertTrue(expectedTitle.isDisplayed());
        Assert.assertEquals("HOOO HOOOOO !!!!", expectedTitle.getText());

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
