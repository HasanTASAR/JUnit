package utlities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }

    }
    public static void tumSayfaSSCek(WebDriver driver){
        //1- TakeScreenchot objesi oluştur
        TakesScreenshot tss=(TakesScreenshot) driver;

        //2-resmi son olarak kaydedeceğimiz dosyayı oluştur
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih=ldt.format(dtf);
        String dosyaYolu="target/ekranResimler/tumEkranSS"+tarih+".jpeg";

        File tumSayfaSS= new File(dosyaYolu);

        //3-tss objesi kullanarak ekran görüntüsü alıp geçici dosyaya kaydedlim
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        //4- geçici dosyayı ana dosyaya kaydet
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void elementSSCek(WebElement element){
        // 1- screenshot alacagimiz elementi locate et
        // 2- kaydedecegimiz dosyayi olustur
        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String tarih= ldt.format(dtf);
        String dosyaYolu="target/ekranResimleri/istenenElementSS"+tarih+".jpeg";

        File elementSS= new File(dosyaYolu);
        // 3- gecici dosyayi olusturup, element uzerinden screenshot yapalim

        File gecici= element.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, hedef dosyaya kopyala

        try {
            FileUtils.copyFile(gecici,elementSS);
        } catch (IOException e) {

        }
    }
}
