package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test01() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        // sayfa 2ye gidip;
        // satir sayısının 30, kullanilan satir sayisinin 23 oldugunu test edin

        int sonSatirIndex = workbook
                .getSheet("Sayfa2")
                .getLastRowNum();
        int expectedSatirSayisi = 30;

        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex);

        int kullanilanSatirSayisi = workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi = 23;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanilanSatirSayisi);

    }
}
