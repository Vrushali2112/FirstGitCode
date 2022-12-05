package testcase;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;


public class LoginTestCase extends BaseTest {
	public LoginTestCase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public LoginPage lp;
	@BeforeMethod
    public void setUp() throws InterruptedException
    {
    	driver=SetUpBrowser();
    	lp=new LoginPage(driver);
    }
  
@Test(dataProvider="getData")
	public void LoginCheck(String user,String pass) throws InterruptedException
	{
		//create object of page class login 
		lp.setUserName(user);
		Thread.sleep(3000);
		lp.setPassword(pass);
		Thread.sleep(3000);
		lp.ClickLogin();
	}
	@AfterMethod
	public void tearDown()
	{
		tearDown1();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		Object[][] testData = ExcelRead();
		return testData;
	}
	
	
	

}
