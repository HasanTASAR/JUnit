package Day13_writeExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utlities.TestBase;

public class C06_JSExecutor extends TestBase {

    @Test
    public void test01(){

        driver.get("https://amazon.com");

        WebElement sellLink= driver.findElement(By.xpath("//a[text()='Sell']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()",sellLink);


    }

}
