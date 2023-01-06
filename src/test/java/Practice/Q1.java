package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
     /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin.
     */
     static WebDriver driver;

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    //  BeforeClass ile driver'i olusturun ve class icinde static yapin
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //http://www.google.com adresine gidin
    @Before
    public void beforeTest(){
        driver.get("http://www.google.com");
    }

    //arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    @Test
    public void test01(){
        driver.findElement(By.className("gLFyf")).sendKeys("The Lord of the Rings"+ Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());

    }
    @Test
    public void test02(){
        driver.findElement(By.className("gLFyf")).sendKeys("Brave Heart"+ Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());

    }
    @Test
    public void test03(){
        driver.findElement(By.className("gLFyf")).sendKeys("Harry Potter"+ Keys.ENTER);
        System.out.println(driver.findElement(By.id("result-stats")).getText());

    }

}
