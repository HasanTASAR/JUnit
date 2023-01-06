package day12_webTables_Exel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        //dosya yolu oluşturalım
        String dosyaYolu="src/test/java/day12_webTables_Exel/ulkeler.xlsx";


        FileInputStream fis= new FileInputStream(dosyaYolu) ;


        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet=workbook.getSheet("Sayfa1");

        workbook.close();
        fis.close();






    }
}
