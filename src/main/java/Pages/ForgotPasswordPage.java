package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	@FindBy(xpath="//input[@id='identify_email']")
	WebElement FindYourAccount;
	@FindBy(xpath="//button[@id='did_submit']")
	WebElement searchButton;
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath="//div[text()='No Search Results']")
	WebElement searchResult;
	WebDriver driver;
public ForgotPasswordPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
public String ForgotPasswordPageCheck() throws InterruptedException
{
	Thread.sleep(3000);
	FindYourAccount.sendKeys("test");
	Thread.sleep(3000);
	searchButton.click();
	Thread.sleep(3000);
	String searchText=searchResult.getText();
	Thread.sleep(3000);
	return searchText;
	
}
}

