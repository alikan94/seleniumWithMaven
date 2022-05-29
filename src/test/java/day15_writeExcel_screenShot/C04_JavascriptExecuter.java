package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JavascriptExecuter extends TestBase {

    @Test
    public void JSExecuterTest() throws InterruptedException {
        // amazona gidelim
        driver.get("https://www.amazon.com/");
        // en alttaki sign in butonuna inelim, javascript ile yapalım
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement signInButtonElement = driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButtonElement);
        // sign in buttonuna js ile click yapalim

        jse.executeScript("arguments[0].click();",signInButtonElement);
        Thread.sleep(3000);

    }
}
