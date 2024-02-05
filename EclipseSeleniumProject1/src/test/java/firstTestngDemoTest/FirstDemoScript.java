package firstTestngDemoTest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstDemoScript 
{
	private static WebDriver driver;
	
	@Test
	public void login() throws InterruptedException 
	{
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     
		WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		Boolean flag=false;
		String expectedTitle = "DEMOQA";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			flag=true;
		}
		SoftAssert sa=new SoftAssert();
		if(flag)
		{
			sa.assertEquals(actualTitle, expectedTitle);
			System.out.println("Assertion passed");
		}
		else 
		{
			sa.assertEquals(actualTitle, expectedTitle);
			System.out.println("Assertion failed");
		}
//		if(flag)
//		{
//			Assert.assertEquals(expectedTitle, actualTitle);
//			System.out.println("Assertion passed");
//		}
//		else 
//		{
//			Assert.assertEquals(expectedTitle, actualTitle);
//			System.out.println("Assertion failed");
//		}
		
		Thread.sleep(2000);
	     WebElement scrollDown=driver.findElement(By.xpath("//*[@id=\"app\"]//div[@class='accordion']/div[3]/span"));
	     JavascriptExecutor js=(JavascriptExecutor) driver;
	     js.executeScript("arguments[0].scrollIntoView();", scrollDown);
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id=\"app\"]//div[@class='accordion']/div[3]/span")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id=\"app\"]//div[@class='accordion']/div[3]//ul//li[1]")).click();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//*[@id='windowButton']")).click();
	     String pWindow=driver.getWindowHandle();
	     System.out.println("Parent window id is "+pWindow);
	   Set<String>windows=driver.getWindowHandles();
	   for(String window:windows)
	   {
		   if(!window.equals(pWindow))
		   {
			   driver.switchTo().window(window);
			   driver.manage().window().maximize();
			   String title=driver.getTitle();
			   System.out.println("title of new window tab is "+title.toString());
			   Thread.sleep(1000);
			   String text=driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
			   System.out.println("Present Text on new window tab is--"+text);
		   }
		   
	   }
	     System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	     driver.close();
	   sa.assertAll();
	 
//		String actualUrl = "https://live.browserstack.com/dashboard";
//		String expectedUrl = driver.getCurrentUrl();
//		Assert.assertEquals(expectedUrl, actualUrl);
	}

}
