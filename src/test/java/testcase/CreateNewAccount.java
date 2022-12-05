package testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BaseTest;
import Pages.LoginPage;

public class CreateNewAccount extends BaseTest {
	
	public CreateNewAccount() throws IOException {
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
    @Test
	public void CreateNewButton() throws InterruptedException
	{
		lp.ClickCreateNewAccount();
		Thread.sleep(3000);
	}
    @AfterMethod
    public void tearDown()
    {
    	tearDown1();
    }
	

}
