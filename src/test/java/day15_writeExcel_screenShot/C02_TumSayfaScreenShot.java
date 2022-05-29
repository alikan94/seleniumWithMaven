package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_TumSayfaScreenShot extends TestBase {

    @Test
    public void tumSayfaScreenShotTest() throws IOException {

        // amazon sayfasina gidip tum sayfanin sssini cekelim
        driver.get("https://www.amazon.com/");

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File tumSayfaSS = new File("target/screenShots/" + tarih + ".jpeg");

        File temp = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,tumSayfaSS);



    }
}
