package day13_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    /*
            // onceki class daki adrese gidip
            // girisYap() kullanarak sayfaya giris yapin
            // input olarak verilen satir sayisi ve sutun sayisina sahip
            // cell deki text i yazdirin
     */

    int satir = 4;
    int sutun = 4;

    @Test
    public void test01() {
        girisYap();

        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir +"]//td["+sutun+"]"));

        System.out.println(arananCell.getText());

    }

    private void girisYap() {
        driver.get("https://www.hotelmycamp.com");

        driver.findElement(By.xpath("//a[text()='Log in']")).click(); // login tıkla

        Actions actions = new Actions(driver);
        WebElement userNameTextBoxElementi = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userNameTextBoxElementi).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
