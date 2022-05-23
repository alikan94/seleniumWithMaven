package day08_alerts_IFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    /*
    ●   Bir class olusturun: IframeTest
    ●   https://the-internet.herokuapp.com/iframe adresine gidin.
    ●   Bir metod olusturun: iframeTest
        ○   “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        ○   Text Box’a “Merhaba Dunya!” yazin.
        ○   TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
            dogrulayin ve  konsolda yazdirin.
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        //  ●   https://the-internet.herokuapp.com/iframe adresine gidin.
        //  ●   Bir metod olusturun: iframeTest
        driver.get("https://the-internet.herokuapp.com/iframe");

        //  “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println("Baslik : " + baslikElementi.getText());

        //  Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);
        WebElement textKutusuElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textKutusuElementi.clear();
        textKutusuElementi.sendKeys("Merhaba Dunya");

        //  TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //  dogrulayin ve  konsolda yazdirin.

        driver.switchTo().parentFrame();
        WebElement linkYaziElementi = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText());
    }
}
