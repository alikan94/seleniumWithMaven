package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    /*
    // facebook ana sayfaya gidip
// yeni kayit olustur butonuna basin
// isim kutusunu locate edip,
// geriye kalan alanlari TAB ile dolasarak
// formu doldurun
     */
    @Test
    public void test01() throws InterruptedException {
        // facebook ana sayfaya gidip
        driver.get("https://www.facebook.com/");
        // yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // isim kutusunu locate edip,
        WebElement isimKutusuElementi = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        // geriye kalan alanlari TAB ile dolasarak
        Actions actions = new Actions(driver);
        actions.click(isimKutusuElementi);
        actions.
                sendKeys("Ali").
                sendKeys(Keys.TAB).
                sendKeys("Kan").
                sendKeys(Keys.TAB).
                sendKeys("5444838593").
                sendKeys(Keys.TAB).
                sendKeys("12345aaassdf").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).perform();

        // formu doldurun

        Thread.sleep(5000);

    }
}
