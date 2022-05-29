package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenElementSS extends TestBase {

    @Test
    public void webElementSS() throws IOException {
        // amazona gidip nutella aratalım
        // sonuc sayisinin oldugu web eementin sssinin alalim

        driver.get("https://www.amazon.com");

        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        File sonucYazisiElementiSS = new File("target/screenShots/falanfilan.jpeg");

        FileUtils.copyFile(temp,sonucYazisiElementiSS);
    }
}
