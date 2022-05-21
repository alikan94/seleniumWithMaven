package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    Amazona gidip
    dropdown'dan books secenegi secip
    Java aratalim

    ve arama sonuclarinin Java icerigini test edelim
     */

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
    public void test01(){
        driver.get("https://www.amazon.com/");

        // Dropdown'dam bir option secmek icin 3 adim vardir
        // 1- dropdowni locate edin

        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- Bir Select objesi olusturalim
        // parametre olarak locate ettiğimiz ddm'yi girelim

        Select select = new Select(ddm);

        // 3- Dropdownda var olan optionlardan istedigimiz bir taneyi secelim

        //select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String arananKelime = "Java";

        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

    }
}
