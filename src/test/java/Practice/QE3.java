package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QE3 {
    WebDriver driver;


    @Test

    public void homep() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        WebElement home2 = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(home2.isDisplayed());
        WebElement click = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        click.click();

        WebElement name= driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("DenvpeT");

        WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        email.sendKeys("genpdpveme@gtkl");

        WebElement button=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        button.click();

        WebElement radio= driver.findElement(By.id("id_gender1"));
        radio.click();

        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("1234");

        WebElement day=driver.findElement(By.id("days"));
        Select select=new Select(day);
        select.selectByValue("6");

        WebElement mo=driver.findElement(By.id("months"));
        Select select1=new Select(mo);
        select1.selectByVisibleText("January");

        WebElement ye=driver.findElement(By.id("years"));
        Select select2=new Select(ye);
        select2.selectByValue("2020");

        WebElement click2=driver.findElement(By.id("newsletter"));
        click2.click();

        WebElement click3=driver.findElement(By.id("optin"));
        click3.click();

        WebElement firstname=driver.findElement(By.id("first_name"));
        firstname.sendKeys("Turek");

        WebElement lastname= driver.findElement(By.id("last_name"));
        lastname.sendKeys("Ogre");

        WebElement com=driver.findElement(By.id("company"));
        com.sendKeys("Amazon");

        WebElement adress=driver.findElement(By.id("address1"));
        adress.sendKeys("İstanbul Sisli");

        WebElement adress2=driver.findElement(By.id("address2"));
        adress2.sendKeys("İstanbul Sisli");

        WebElement ulke=driver.findElement(By.id("country"));
        Select select3=new Select(ulke);
        select3.selectByValue("Canada");

        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("Istanbul Sisli");

        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("Istanbul");

        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("343434");

        WebElement number= driver.findElement(By.id("mobile_number"));
        number.sendKeys("5555555555555");

        WebElement button2=driver.findElement(By.xpath("//button[text()='Create Account']"));
        button2.click();

        WebElement displayed=driver.findElement(By.xpath("//b[text()='Account Created!']"));
        displayed.isDisplayed();

        WebElement click4=driver.findElement(By.xpath("//a[text()='Continue']"));
        click4.click();
        Thread.sleep(5000);

        WebElement click5=driver.findElement(By.xpath("//a[text()=' Delete Account']"));
        click5.click();

        WebElement displayed3=driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        displayed3.isDisplayed();

        WebElement click6=driver.findElement(By.xpath("//a[text()='Continue']"));
        click6.click();

        WebElement home3 = driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(home3.isDisplayed());
    }
}