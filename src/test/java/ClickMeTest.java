import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class ClickMeTest extends MainTest{

    @Before
    public void openBaseUrl() {
        driver.get(getBASE_URL() + "clickmebaby.php");
    }

    @Test
    public void test() {
        Assert.assertEquals("inicialny pocet klikov","0",driver.findElement(By.id("clicks")).getText());
        Assert.assertEquals("klikov",driver.findElement(By.className("description")).getText());

        for (int i = 1; i < 11; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(String.valueOf(i),driver.findElement(By.id("clicks")).getText());
            if(i==1){
                System.out.println("Overujem slovo klik");
                Assert.assertEquals("klik",driver.findElement(By.className("description")).getText());
            }

            if(i>=2 && i<=4){
                System.out.println("Overujem slovo kliky");
                Assert.assertEquals("kliky",driver.findElement(By.className("description")).getText());
            }

            if(i>4){
                System.out.println("Overujem slovo klikov");
                Assert.assertEquals("klikov",driver.findElement(By.className("description")).getText());
            }

        }

    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
