package day10_actions;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions extends TestBase {

    /*
        1- Yeni bir class olusturalim: MouseActions1
        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        3- Cizili alan uzerinde sag click yapalim
        4- Alert’te cikan yazinin “You selected a context menu” oldugunu
            test edelim.
        5- Tamam diyerek alert’i kapatalim
        6- Elemental Selenium linkine tiklayalim
        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

     */

    @Test
    public void test01() throws InterruptedException {
        //        2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaHerOkuAppWindowHandle = driver.getWindowHandle();

        //        3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();
        Thread.sleep(2000);

        //        4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //            test edelim.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualText);
        //        5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //        6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();
        //        7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> windowHandleSeti = driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";
        for (String w: windowHandleSeti
             ) {
            if (!w.equals(ilkSayfaHerOkuAppWindowHandle)){
                ikinciSayfaWindowHandleDegeri=w;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
