package day09_handleWindows_testBase;

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
import java.util.Set;

public class C03_windowHandles {

    /*
            ● Tests package’inda yeni bir class olusturun: WindowHandle2
            ● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void myTest01() {
        //            ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //            ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandleValue= driver.getWindowHandle();
        //            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=sayfadakiYaziElementi.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        //            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //            ● Click Here butonuna basın.
        WebElement clickHereElementi = driver.findElement(By.linkText("Click Here"));
        clickHereElementi.click();

        /*
        Switchto().newWindow() demeden link tiklayarak yeni sekme olustugunda
        biz drivera yeni sayfaya gec demedikce driver eski sayfada kalir
        veyeni sayfa ile ilgili islem yapamayiz
        yeni sayfa ile calismak istiyorsan önce driveri yeni sekmeye goturmelisin

         */

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikinciSayfaWindowHandleValue="";

        for (String each: windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleValue)){
                ikinciSayfaWindowHandleValue = each;
            }
        }

        //            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWindowHandleValue);
        String expectedIkinciTitle = "New Window";
        String actualIkinciTitle = driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle,actualIkinciTitle);
        //            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElementi = driver.findElement(By.xpath("//h3"));
        String expectedIkinciYazi = "New Window";
        String actualIkinciYazi = ikinciSayfaYaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);
        //            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleValue);
        String expectedUcuncuTitle = "The Internet";
        String actualUcuncuTitle = driver.getTitle();
        Assert.assertEquals(expectedUcuncuTitle,actualUcuncuTitle);

    }

}
