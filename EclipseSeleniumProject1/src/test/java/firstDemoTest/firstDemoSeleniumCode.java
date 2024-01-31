package firstDemoTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstDemoSeleniumCode 
{
	private static WebDriver driver;
 	

 @BeforeClass
 public static void openBrowser()
 {
	 WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	} 

 @Test
 public void valid_UserCredential()
 {

	 System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
     driver.get("https://demoqa.com/text-box");	
//     driver.findElement(By.xpath(".//*[@id='account']/a")).click();
//     driver.findElement(By.id("log")).sendKeys("testuser_3");
//     driver.findElement(By.id("pwd")).sendKeys("Test@123");
//     driver.findElement(By.id("login")).click();
   
     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
 }

 @AfterClass
 public static void closeBrowser(){
	 driver.quit();
 }
}
