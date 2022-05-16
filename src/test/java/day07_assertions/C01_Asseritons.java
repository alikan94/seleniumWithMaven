package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Asseritons {
    /*
        amazon anasayfaya gidin
        uc farkli test methodu olusturarak asagidaki gorevleri yapin
        1- URL'in amazon icerdigini test edin
        2- title'in facebook icermedigini test edin
        3- sol ust kosede amazon logosunun gorundugunu test edin
    */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- URL'in amazon icerdigini test edin
        driver.get("https://www.amazon.com/");
        String arananKelime = "amazon";

        Assert.assertTrue(driver.getCurrentUrl().contains(arananKelime));
    }

    @Test
    public void test02(){
        // 2- title'in facebook icermedigini test edin

        String arananTitleKelimesi = "facebook";
        Assert.assertFalse(driver.getCurrentUrl().contains(arananTitleKelimesi));
    }

    @Test
    public void test03(){
        // 3- sol ust kosede amazon logosunun gorundugunu test edin

        WebElement amazonLogosu = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(amazonLogosu.isDisplayed());
    }

}
