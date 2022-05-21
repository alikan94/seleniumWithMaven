package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DersTesti2 {
    /*
        Bir Class olusturalim YanlisEmailTesti
       - http://automationpractice.com/index.php sayfasina gidelim
       - Sign in butonuna basalim
       - Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
            “Invalid email address” uyarisi ciktigini test edelim
     */

    static WebDriver driver;

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
    public void test01() {
        //- http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        //       - Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();
        //       - Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        String hataliEmail = "abc.gmail.com";
        driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys(hataliEmail + Keys.ENTER);
        //            “Invalid email address” uyarisi ciktigini test edelim
        WebElement invalidMailWarning = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalidMailWarning.isDisplayed());
    }
}
