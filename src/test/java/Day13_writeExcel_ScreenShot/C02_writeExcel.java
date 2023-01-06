package Day13_writeExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_writeExcel {
    @Test
    public void test01() throws IOException {
        // Excel dosyasindan kopyaladigimiz workbook objesi uzerinde degisiklik yapabiliriz
        // Bunun icin oncelikle excel'in kopyasi olan workbook'u olusturalim

        String dosyaYolu="src/test/java/day12_webTables_Exel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");


        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        workbook.close();
        fis.close();
        fos.close();


    }

}
