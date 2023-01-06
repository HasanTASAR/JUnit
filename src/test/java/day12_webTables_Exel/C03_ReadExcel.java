package day12_webTables_Exel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.STPrintErrorImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {
    /*
    1. - 1.satirdaki 2.hucreye gidelim ve yazdiralim
    2.- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    3.- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
    4.- Satir sayisini bulalim
    5.- Fiziki olarak kullanilan satir sayisini bulun
    6.- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */
    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/day12_webTables_Exel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //1. - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString());

        //2.- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenen=workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenen);

        //3.- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString());

        //4.- Satir sayisini bulalim
        System.out.println("Satir sayısı :"+(workbook.getSheet("Sayfa1").getLastRowNum()+1));

        //5.- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("2. sayfa son satır indexi :"+workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println("2. sayfa fiziki kullanılan satır sayısı :"+ workbook.getSheet("Sayfa2").getActiveCell());

        //6.- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ulkelerMap=new TreeMap<>();
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();
        String key="";
        String value="";

        for (int i = 0; i < sonSatirIndexi; i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);

        workbook.close();
        fis.close();

    }
}
