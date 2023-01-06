package day12_webTables_Exel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utlities.TestBase;

import java.util.List;

public class C01_webTables extends TestBase {
    /*
    1. “https://demoqa.com/webtables” sayfasina gidin
 2. Headers da bulunan basliklari yazdirin
 3. 3.sutunun basligini yazdirin
 4. Tablodaki tum datalari yazdirin
 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
 6. Tablodaki satir sayisini yazdirin
 7. Tablodaki sutun sayisini yazdirin
 8. Tablodaki 3.kolonu yazdirin
 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
10. Page sayfasinda bir method olusturun,
//Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

     */

    @Test
    public void test01(){
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        WebElement headerelemeneti= driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("Başlık Elemenetleri: "+headerelemeneti.getText());

        //3. 3.sutunun basligini yazdirin
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        System.out.println(basliklarListesi.get(2).getText());

        // 4. Tablodaki tum datalari yazdirin
        WebElement bodyElementi= driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("body elemeneti "+bodyElementi.getText());

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> datalarListesi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        int siraNo=1;
        for (WebElement eachElemenet: datalarListesi) {

            if(!(eachElemenet.getText().equals("") || eachElemenet.getText().equals(" "))){
                System.out.println(siraNo+".- "+ eachElemenet);
                siraNo++;
            }
        }
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElemenetListesi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki Satir Sayisi: "+satirElemenetListesi.size());

        //7. Tablodaki sutun sayisini yazdirin
        //Basta basliklar listesi oluşturmuştuk. onun size bize sutun sayisini verir
        System.out.println("Sütun sayisi: "+basliklarListesi.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunelemenetleri=driver.findElements(By.xpath("((//div[@class='rt-tr-group']))//div[1]/div[3]"));

        for (WebElement eachElement: ucuncuSutunelemenetleri) {
            if(!(eachElement.getText().equals("") || eachElement.getText().equals(" "))){
                System.out.println( eachElement.getText());
            }
        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //     index'i saydiralim, Kierra'yi bulunca , index'in 4 fazlasini yazdiralim
        for (int i = 0; i < datalarListesi.size()  ; i++) {
            if (datalarListesi.get(i).getText().equals("Alden")){
                System.out.println("Istenen kisinin maasi : " + datalarListesi.get(i+4).getText());
            }
        }
        //10. Page sayfasinda bir method olusturun,
        //    Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }
}
