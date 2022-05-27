package day13_cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_Odev extends TestBase {
    /*
            Bir Class olusturun D19_WebtablesHomework
          1. “https://demoqa.com/webtables” sayfasina gidin
          2. Headers da bulunan department isimlerini yazdirin
          3. sutunun basligini yazdirin
          4. Tablodaki tum datalari yazdirin
          5. Tabloda kac cell (data) oldugunu yazdirin
          6. Tablodaki satir sayisini yazdirin
          7. Tablodaki sutun sayisini yazdirin
          8. Tablodaki 3.kolonu yazdirin
          9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
          10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
     */

    @Test
    public void test01(){
        //          1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //          2. Headers da bulunan department isimlerini yazdirin
        List<WebElement> headerTextsElementsList = driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-thead -header']//div[@class='rt-resizable-header-content']"));
        headerTextsElementsList.stream().map(WebElement::getText).forEach(System.out::println);
        //          3. sutunun basligini yazdirin


        //          4. Tablodaki tum datalari yazdirin
        List<WebElement> allCellElementsList = driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-tbody']//div[@role='gridcell']"));
        allCellElementsList.stream().map(WebElement::getText).forEach(System.out::println);

        //          5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("Cell (data) sayisi = " + allCellElementsList.size());

        //          6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarElementsList = driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-tbody']//div[@role='rowgroup']"));
        satirlarElementsList.stream().map(WebElement::getText).forEach(System.out::println);
        System.out.println("Satir sayisi = " + satirlarElementsList.size());

        //          7. Tablodaki sutun sayisini yazdirin
        System.out.println("Sutun sayisi = " + headerTextsElementsList.size());

        //          8. Tablodaki 3.kolonu yazdirin
        int girilenKolon = 3;
        System.out.println("Girdiginiz kolon numarasi : " + girilenKolon);
        List<WebElement> girilenKolonunElementListesi = driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-tbody']//div[@role='gridcell']["+ girilenKolon +"]"));
        girilenKolonunElementListesi.stream().map(WebElement::getText).forEach(System.out::println);


        //          9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        String arananBaslik = "First Name";
        int arananBaslikNo = 0;

        for (int i = 0; i < headerTextsElementsList.size(); i++) {
            if (headerTextsElementsList.get(i).getText().equals(arananBaslik)){
                arananBaslikNo=i+1;
            }
        }

        String expectedName = "Kierra";
        int arananSatirNo = 0;
        girilenKolonunElementListesi = driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-tbody']//div[@role='gridcell']["+ arananBaslikNo +"]"));

        for (int i = 0; i < girilenKolonunElementListesi.size(); i++) {
            if (girilenKolonunElementListesi.get(i).getText().equals(expectedName)){
                arananSatirNo=i+1;
            }
        }

        arananBaslik = "Salary";
        arananBaslikNo = 0;

        for (int i = 0; i < headerTextsElementsList.size(); i++) {
            if (headerTextsElementsList.get(i).getText().equals(arananBaslik)){
                arananBaslikNo=i+1;
            }
        }

        System.out.println(expectedName + " isimli kisinin " + arananBaslik + " bilgisi : " + driver.findElement(By.xpath("//div[@class='rt-table']//div[@class='rt-tr-group']["+ arananSatirNo+"]//div[@role='gridcell']["+arananBaslikNo+"]")).getText());


        //          10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        tableDetay(2,6);

    }

    public void tableDetay(int satir, int sutun){
        List<WebElement> headerTextsElementsList = driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-thead -header']//div[@class='rt-resizable-header-content']"));

        System.out.println(satir + ". satirin " + headerTextsElementsList.get(sutun-1).getText() + " bilgisi : " + driver.findElement(By.xpath("//div[@class='rt-table']//div[@class='rt-tr-group']["+ satir+"]//div[@role='gridcell']["+sutun+"]")).getText());

    }
}
