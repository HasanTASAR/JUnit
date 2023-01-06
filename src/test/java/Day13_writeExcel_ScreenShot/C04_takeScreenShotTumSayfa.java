package Day13_writeExcel_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import utlities.ReusableMethods;
import utlities.TestBase;

public class C04_takeScreenShotTumSayfa extends TestBase {

    @Test
    public void test01(){

        // wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");

        // anasayfaya gittiginizi test edin
        String expectedUrl="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaSSCek(driver);
    }
}
