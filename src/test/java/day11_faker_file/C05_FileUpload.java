package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;

public class C05_FileUpload extends TestBase {

    /*
    //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        /*
        bu islemi selnium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir.

    // 1.adim choose file butonunu locate edelim
    // 2.adim yuklenecek doyanin dosya yolunu olusturalim
    //   biz masaustundeki text.txt dosyasini yukleyelim
    // 3. adim sendKeys ile dosya yolunu, secme butonuna yollayalim
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim.
     */

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        /*
        bu islemi selenium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir.
         */

        //  1.  adim choose file butonunu locate edelim
        WebElement chooseFileElementi = driver.findElement(By.xpath("//input[@id='file-upload']"));

        //  2.  adim yuklenecek doyanin dosya yolunu olusturalim
        //      biz masaustundeki text.txt dosyasini yukleyelim
        String masaustuTextDosyasiYolu = System.getProperty("user.home") + "\\Desktop\\text.txt";

        //  3.  adim sendKeys ile dosya yolunu, secme butonuna yollayalim
        chooseFileElementi.sendKeys(masaustuTextDosyasiYolu);
        //      Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        //      “File Uploaded!” textinin goruntulendigini test edelim.
        String expectedText = "File Uploaded!";
        String actualText = driver.findElement(By.xpath("//h3")).getText();

        Assert.assertEquals(actualText,expectedText);

    }
}
