package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // amazon ana sayfaya git
        // account menusunden crate new list diyelim
        driver.get("https://www.amazon.com/");

        Actions actions = new Actions(driver);

        WebElement accountLinkiElementi = driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        actions.moveToElement(accountLinkiElementi).perform();

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        Thread.sleep(5000);

    }
}
