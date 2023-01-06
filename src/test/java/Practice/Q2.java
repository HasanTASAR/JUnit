package Practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utlities.TestBase;

public class Q2 extends TestBase {
    //  http://www.bestbuy.com 'a gidin,
    //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    //  Ayrica Relative Locator kullanarak;
    //  logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
    //  Ayrica Relative Locator kullanarak;
    //  mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

    @Before
    public void beforeTest(){
        driver.get("http://www.bestbuy.com");
    }

    @Test
    public void testTitle(){
        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String expectedTitle="Best";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void testRelative(){
        //  Ayrica Relative Locator kullanarak;
        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement helloTitle= driver.findElement(By.xpath("//*[text()='Hello!']"));
        WebElement bestBuyLogo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloTitle));
        Assert.assertTrue(bestBuyLogo.isDisplayed());

    }
    @Test
    public void testMexicoLink(){
        //  Ayrica Relative Locator kullanarak;
        //  mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin
        WebElement usFlag = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoFlag = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));
        Assert.assertTrue(mexicoFlag.isDisplayed());
    }
}
