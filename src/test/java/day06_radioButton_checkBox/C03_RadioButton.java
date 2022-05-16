package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
            1. Bir class oluşturun : RadioButtonTest
            2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
            -https://www.facebook.com adresine gidin
            -Cookies’i kabul edin
            -“Create an Account” button’una basin
            -“radio buttons” elementlerini locate edin
            -Secili degilse cinsiyet butonundan size uygun olani secin
     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //@After
    public void quit(){
        driver.close();
    }


    @Test
    public void test01() throws InterruptedException {
        //  -https://www.facebook.com adresine gidin

        driver.get("https://www.facebook.com");

        //  -“Create an Account” button’una basin

        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //  -“radio buttons” elementlerini locate edin

        WebElement radioButtonKadin = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement radioButtonErkek = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement radioButtonOzel = driver.findElement(By.xpath("//input[@value='-1']"));

        //  -Secili degilse cinsiyet butonundan size uygun olani secin


        Thread.sleep(3000);
        if(!radioButtonErkek.isSelected()){
            radioButtonErkek.click();
        }
        Thread.sleep(3000);

    }
}
