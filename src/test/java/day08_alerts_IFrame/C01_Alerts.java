package day08_alerts_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

   // @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        /*
        herhangi bir websitesinde ortaya cıkan uyarilara alert denir

        eger bir alert inspect yapilabiliyorsa o alert otomasyon ile kullanılabilir
        bu tür alertlere html alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur
        tum webElemntler gibi locate edip istedigimiz islemleri yapabiliriz

        driver.get("https://www.facebook.com");

        Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
           js alert'ler locate edilemez
           Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir
         */

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();

        String expectedText = "You successfully clicked an alert";
        String actualText = driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).getText();

        Assert.assertEquals(expectedText,actualText);
    }

}
