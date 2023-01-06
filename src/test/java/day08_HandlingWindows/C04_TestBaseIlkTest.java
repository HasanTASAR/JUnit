package day08_HandlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utlities.ReusableMethods;
import utlities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.trendyol.com");
        ReusableMethods.bekle(3);
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="trendyol";


        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
}
