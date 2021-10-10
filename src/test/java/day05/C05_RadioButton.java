package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C05_RadioButton {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    WebDriver driver;
    @Before
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
    }
    @Test
    public void testFacebook () {
        //https://www.facebook.com adresine gidin.
        //“Create an Account” button’una basin
        //“radio buttons” elementlerini locate edin
        //Secili degilse cinsiyet butonundan size uygun olani secin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@data-testid=\"open-registration-form-button\"]")).click();
        WebElement radioButtonFemale = driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[1]"));
        WebElement radioButtonMale = driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[2]"));
        WebElement radioButtonSpecia = driver.findElement(By.xpath("(//label[@class=\"_58mt\"])[3]"));
        if (!radioButtonMale.isSelected()){
            radioButtonMale.click();
        }
    }
     @After
        public void tearDown () {
            driver.close();
        }
}
