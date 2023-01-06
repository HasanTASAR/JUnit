package day11_seleniumwaits_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utlities.ReusableMethods;
import utlities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {
    @Test
    public void test01() {
        // 1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10, satirlarListesi.size());

        //5.Tum satirlari yazdirin
        for (WebElement eachRow : satirlarListesi
        ) {

            System.out.println(eachRow.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> ucuncuSatirSutunListesi = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13, ucuncuSatirSutunListesi.size());


        //7. 5.sutunu yazdirin
        List<WebElement> besinciSutunElementleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachElement : besinciSutunElementleri) {
            System.out.println(eachElement.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun
        WebElement istenenDataelementi = getElement(3, 5);
        System.out.println(istenenDataelementi.getText());

        ReusableMethods.bekle(5);
    }

    private WebElement getElement(int satir, int sutun) {
        String dinamikXpath="//tbody/tr["+satir+"]/td["+sutun+"]";
        WebElement istenenelement=driver.findElement(By.xpath(dinamikXpath));
        return istenenelement;
    }
}