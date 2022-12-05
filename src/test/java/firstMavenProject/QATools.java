package firstMavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QATools {
	WebDriver driver=null;
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\q\\Downloads\\Seleniuem Java folder\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver(); //object of chrome driver we stored in web driver interface
		 driver.navigate().to("https://demoqa.com/text-box"); // navigate method is also use to open any url in any browser.
		Thread.sleep(3000); // it will wait for 3 sec
		driver.manage().window().maximize(); // maximize the window or browser
		Thread.sleep(3000);
	}
	@Test
	public void TextBox() throws InterruptedException
	{
		WebElement FirstName=driver.findElement(By.xpath("//input[@id='userName']"));
		FirstName.sendKeys("Vrushali Joshi");
		Thread.sleep(3000);
		WebElement Email=driver.findElement(By.xpath("//input[@id='userEmail']"));
		Email.sendKeys("Vrushali.Joshi@gmail.com");
		Thread.sleep(3000);
		WebElement CurrentAddress=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		CurrentAddress.sendKeys("Pune");
		Thread.sleep(3000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement PermanantAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		PermanantAddress.sendKeys("Pune");
		Thread.sleep(3000);
		WebElement Submit=driver.findElement(By.xpath("//button[@id='submit']"));
		Submit.click();
		Thread.sleep(5000);
	}
	@Test
	public void Assert()
	{
		
		Assert.assertEquals("Vrushali Joshi", "Vrushali Joshi");
		Assert.assertEquals("Vrushali.Joshi@gmail.com", "Vrushali.Joshi@gmail.com");
		Assert.assertEquals("Pune", "Pune");
		Assert.assertEquals("Mumbai", "Pune");
		
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
