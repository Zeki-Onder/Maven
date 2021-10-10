package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_Test03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);
        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        Thread.sleep(2000);
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        Thread.sleep(2000);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstElement = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        firstElement.click();
        Thread.sleep(2000);
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        Thread.sleep(2000);
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class=\"shopping_cart_link\"]")).click();
        Thread.sleep(2000);
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        WebElement cartElement = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        Thread.sleep(2000);
        if (cartElement.equals(firstElement)){
            System.out.println("Test PASS!");
        } else {
            System.out.println("Test FAILED!");
        }
        //9. Sayfayi kapatin

    }
}
