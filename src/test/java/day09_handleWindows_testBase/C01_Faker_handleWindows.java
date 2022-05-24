package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Faker_handleWindows {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

   @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void myTest01(){

        /*
        1- Amazon ana sayfaya gidin,
        2- nutella icin arama yaptir
        3- ilk urunun resmini farklı bir taba ac
        4- yeni tabda acilan urunun basligini yazdirin
         */
        driver.get("https://www.amazon.com/");
        String ilkSayfaHandleDegeri =driver.getWindowHandle();  // CDwindow-3037B035A69D65C1A06E4B6F7EDAFDA4

        // eger sayfalar arası geçiş yapıyorsak ve herhangi bir sayfadan suanda bulundugumuz sayfaya
        // gecmek istersek
        // driver.switchTo().window("CDwindow-3037B035A69D65C1A06E4B6F7EDAFDA4");
        // bu sayfanın window handle degerini girerek bu sayfaya gecisi saglayabiliriz


        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        WebElement ilkUrunResmiElementi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
Bu komutu kullandigimizda driver otomatik olarak olusturulan
new Tab'a gecer
yeni tab'da gorevi gerceklestirmek icin
adimlari bastan almamiz gerekir
 */
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        System.out.println("Urun basligi : " + driver.findElement(By.id("productTitle")).getText());

        // ilk sayfaya gecip url yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());
    }
}
