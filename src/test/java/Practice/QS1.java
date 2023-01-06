package Practice;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utlities.ReusableMethods;
import utlities.TestBase;

import javax.swing.*;
import java.util.List;

public class QS1 extends TestBase {


    @Test
    public void testTrendyol() {

        // amazon anasayfaya gidin
        // Gift Cards linkini tiklayin
        // Gift Cards sayfasina gittigini test edin

        // amazon anasayfaya gidin

        driver.get("https://www.trendyol.com");
        ReusableMethods.bekle(3);

        driver.findElement(By.className("vQI670rJ")).sendKeys("yılbaşı hediyeleri"+ Keys.ENTER);
        ReusableMethods.bekle(3);


        driver.findElement(By.xpath("(//img[@class=\"full-image editimg\"])[2]")).click();
        ReusableMethods.bekle(3);

        /*
        //driver.findElement(By.xpath("//div[@class=\"prc-box-dscntd\"]")).getText();


        List<WebElement> fiyatListesi = driver.findElements(By.className("prc-box-dscntd"));
        for (WebElement each : fiyatListesi) {
            System.out.println(each.getText().replace("TL", "").replace(".", "").replace(",", "."));
        }

         */

    }
}
