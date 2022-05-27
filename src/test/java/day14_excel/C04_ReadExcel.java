package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

        // ingilizce baskentleri yazdiralim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        // ingilizce baskentleri yazdiralim

        int sonSatirNo = workbook.getSheet("Sayfa1").getLastRowNum()+1;
        System.out.println(sonSatirNo);
        String satirdakiData = "";

        for (int i = 1; i <= sonSatirNo; i++) {
            satirdakiData = C03_ReadExcel.exceldenVeriyiGetir(i, 2);
            System.out.println(satirdakiData);
        }


    }
}
