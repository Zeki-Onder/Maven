package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeNotasyonu {

    //amazon sayfasına gidip 3 farkli test methodu hazirlayın
    //her method'da farkli aramalar yapalim

    static WebDriver driver;
    WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));


    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test1(){
        searchbox.clear();
        searchbox.sendKeys("nutella"+ Keys.ENTER);
    }

    @Test
    public void test2(){
        searchbox.clear();
        searchbox.sendKeys("bycicle"+ Keys.ENTER);
    }

    @Test
    public void test3(){
        searchbox.clear();
        searchbox.sendKeys("java"+ Keys.ENTER);
    }

    @AfterClass
    public static void tearDown (){
        driver.close();
    }

}
