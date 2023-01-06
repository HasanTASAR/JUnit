package day10_FileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utlities.ReusableMethods;
import utlities.TestBase;

public class C03_FileUploadTesti extends TestBase {
    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");


        WebElement chooseFileButonu= driver.findElement(By.xpath("//*[@id='file-upload']"));

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\mrhbJAVA.docx";
        chooseFileButonu.sendKeys(dosyaYolu);

        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        WebElement fileUploadedElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());
        ReusableMethods.bekle(5);





        //2.chooseFile butonuna basalim
       // 3.Yuklemek istediginiz dosyayi secelim.
       // 4.Upload butonuna basalim.
       // 5.“File Uploaded!” textinin goruntulendigini test edelim.
    }
}
