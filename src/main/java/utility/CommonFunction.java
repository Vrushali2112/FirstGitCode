package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonFunction {
	
	public void drpdown(WebElement bm,String Visible)
	{
		Select month=new Select(bm); //select tag we used Select class
		month.deselectByVisibleText(Visible); //Method we used sbvt inside Select class
	}

}
