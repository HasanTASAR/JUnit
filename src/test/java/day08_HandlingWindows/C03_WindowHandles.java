package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {
    // https://the-internet.herokuapp.com/iframe adresine gidin
// elemental selenium linkini tiklayin
// yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
// ilk sayfaya geri donup sayfadaki yazinin
// "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        Set<String> ikisayfaninWHD=driver.getWindowHandles();
        String ikinciWHD="";

        for (String eachWHD: ikisayfaninWHD) {
            if(!eachWHD.equals(ikinciWHD)){
                ikinciWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciWHD);
        String actual=driver.findElement(By.tagName("h1")).getText();
        String expected="Elemental Selenium";

        Assert.assertEquals(actual,expected);



    }
}
