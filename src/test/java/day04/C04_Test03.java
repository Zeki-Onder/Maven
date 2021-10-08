package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_Test03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class=\"shopping_cart_link\"]")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement CartElement = driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]"));
        if (CartElement.isDisplayed()){
            System.out.println("urun basari ile eklenmistir test PASS");
        }else {
            System.out.println("ürün eklenememistir. Test FAİLED");
        }
        //9. Sayfayi kapatin
        driver.close();
    }
}
