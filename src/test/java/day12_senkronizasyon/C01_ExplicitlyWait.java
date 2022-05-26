package day12_senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    /*
        1. Bir class olusturun : WaitTest
        2. Iki tane metod olusturun : implicitWait() , explicitWait()
             Iki metod icin de asagidaki adimlari test edin.
        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        4. Remove butonuna basin.
        5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        6. Add buttonuna basin
        7. It’s back mesajinin gorundugunu test edin
     */

    @Test
    public void implicitWaitTesti() throws InterruptedException {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }

    @Test
    public void explicitWait() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYazisi = driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYazisi));
        Assert.assertTrue(itsGoneYazisi.isDisplayed());

        yazinin gorunur olmasini beklerken yazinin locatini kullanmak sorun olusturur.
        cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir.
        Html kodlari yazan developer farkli uygulamalar yapabilir
        bu durumda bekleme islemi ve locate birlikte yapilmalidir
        */

        WebElement itsGoneYazisiElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackElementi.isDisplayed());

    }
}
