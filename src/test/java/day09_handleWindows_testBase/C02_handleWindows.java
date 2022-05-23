package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    // 1- amazon anasayfaya gidelim
    // 2- url'in  amazon icerdigini test edelim
    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    // 4- title'in BestBuy icerdigini test edelim
    // 5- ilk sayfaya donup sayfada java aratalim
    // 6- arama sonuclarinin Java icerdigini test edelim
    // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
    // 8- logonun gorundugunu test edelim

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
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com/");

        // 2- url'in  amazon icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.bestbuy.com/");
        String ikinciSayfaWindowHandle = driver.getWindowHandle();

        // 4- title'in BestBuy icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        // 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr = sonucYazisiElementi.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
