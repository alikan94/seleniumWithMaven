package day13_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    /*
            ● Bir class oluşturun : C02_WebTables
            ● login( ) metodun oluşturun ve oturum açın.
            ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
                        ○ Username : manager
                        ○ Password : Manager1!
            ● table( ) metodu oluşturun
                        ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
                        ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
            ● printRows( ) metodu oluşturun //tr
                        ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
                        ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
                        ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */


    @Test
    public void loginTesti() {
        //          ● login( ) metodun oluşturun ve oturum açın.
        //          ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //              ○ Username : manager
        //              ○ Password : Manager1!
        girisYap();
        //          ● table( ) metodu oluşturun
        //              ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //              ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        table();
        //          ● printRows( ) metodu oluşturun //tr
        //              ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //              ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //              ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        printRows();

    }

    private void printRows() {
        //              ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + satirListesi.size());
        //              ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirListesi.
                stream().
                map(WebElement::getText).
                forEach(System.out::println);
        //              ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        satirListesi.
                stream().
                skip(3).
                limit(1).
                map(WebElement::getText).
                forEach(System.out::println);
        // tüm cell'leri yazdir
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//td"));
        cellList.
                stream().
                map(WebElement::getText).
                forEach(System.out::println);

        // email baslgindaki tüm elementleri yazdirin

        List<WebElement> basliktakiElementlerListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        basliktakiElementlerListesi.
                stream().
                map(WebElement::getText).
                forEach(System.out::println);

        // email basliginin kacinci sutunda oldugunu bulalım
        int emailSutunNo = 0;
        for (int i = 0; i < basliktakiElementlerListesi.size(); i++) {
            if (basliktakiElementlerListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
                break;
            }
        }

        // email basligi altındaki tum elementleri (sütun) yazdirin
        List<WebElement> emailSutunElementList = driver.findElements(By.xpath("//tbody//td[" + (emailSutunNo + 1) + "]"));
        emailSutunElementList.
                stream().
                map(WebElement::getText).
                forEach(System.out::println);

    }

    private void table() {
        //              ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklariListesi.size());
        //              ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumTableBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumTableBody.getText());
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

//        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
//        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!");
    }

}
