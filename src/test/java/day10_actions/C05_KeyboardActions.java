package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    /*
    // once arama kutusuna click yapip
// sonra harf harf Nutella yazisini yazdiralim
// sonra da ENTER tusuna basalim
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));

        // once arama kutusuna click yapip
        // sonra harf harf Nutella yazisini yazdiralim
        // sonra da ENTER tusuna basalim

        Actions actions = new Actions(driver);
        actions.click(aramaKutusuElementi).perform();
        actions.
                keyDown(Keys.SHIFT).
                sendKeys("n").
                keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(2000);

    }

}
