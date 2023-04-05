
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

import javax.swing.text.html.parser.Element;
import java.time.Duration;


public class MainClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ААА\\Documents\\drivers\\chromedriver.exe");
        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        var driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/sampleapp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String buttonText = driver.findElement(By.xpath("//*[text()='Log In']")).getText();
        Assert.assertEquals("Log In", buttonText);


        driver.findElement(By.xpath("//*[@name='UserName']")).sendKeys("Anuar");
        driver.findElement(By.xpath("//*[@name='Password']")).sendKeys("pwd");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.xpath("//*[@id='login'][text()='Log Out']")).click();
    }
}