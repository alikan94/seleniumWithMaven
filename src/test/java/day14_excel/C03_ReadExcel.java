package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    //input olarak verilen
    //satirNo, sutunNo, degerlerini parametre olarak alip
    // O cell'deki datayi String olarak bana donduren bir method olusturun.


    @Test
    public void test01() throws IOException {

        int satirNo = 4;
        int sutunNo = 4;


        // donen Stringin cezayir oldugunu test edin
        String actualData = exceldenVeriyiGetir(satirNo, sutunNo);
        String expectedData = "Cezayir";

        Assert.assertEquals(actualData,expectedData);
    }

    public static String exceldenVeriyiGetir(int satirNo, int sutunNo) throws IOException {
        satirNo -= 1;
        sutunNo -= 1;
        String istenenData = "";

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData = workbook.getSheet("Sayfa1").getRow(satirNo).getCell(sutunNo).toString();

        return istenenData;
    }
}
