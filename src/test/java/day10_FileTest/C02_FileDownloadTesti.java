package day10_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utlities.ReusableMethods;
import utlities.TestBase;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01() {

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        ReusableMethods.bekle(5);

        //3. Facebookd.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.jpeg']")).click();
        ReusableMethods.bekle(5);


        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.jpeg";

        ReusableMethods.bekle(5);

        // Bir dosyanin bilgisayarimizda var oldugunu (exist) test etmek icin
        // Java'daki Files class'indan yardim alacagiz

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test02(){
        // Masaustunde Merhabajava.docx dosyasi oldugunu test edin
        // dinamik dosya yolu olusturalim
        String dosyaYolu= System.getProperty("user.home")+ "\\Desktop\\mrhbJAVA.docx";
        // Assert edelim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }


}

