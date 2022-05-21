package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownMenu {
    /*
    Amazon anasayfaya gidip
    dropdown menuden books secelim
    sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplam sayisinin
    28 oldugunu test edin

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
    public void testAmazonaGit(){
        // 1- amazona Git
        driver.get("https://www.amazon.com");

    }

    @Test
    public void testDDMenuSecim(){
        // 2- ddm'den books sec
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(ddm);
        select.selectByVisibleText("Books");
        // bir dropdown menu ile calisiyorken, son secilen option'a ulasmak isterseniz
        // select.getFirstSelectedOption() method'unu kullanmalisiniz
        // bu method bize WebElement dondurur
        // uzeindeki yaziyi yazdirmak icin getText() unutulmamalidir.
        System.out.println(select.getFirstSelectedOption().getText());


        // dropdown'daki opsiyonlarin toplam sayisinin
        // 28 oldugunu test edin

        int expectedOptionSayisi= 28;
        int actualOptionSayisi= select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }
}
