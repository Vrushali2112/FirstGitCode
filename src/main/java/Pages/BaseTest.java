package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseTest {
	
	public WebDriver driver;
	public LoginPage lp;
	Properties pro;
	
	
	public BaseTest() throws IOException {
		File file=new File("C:\\Users\\q\\eclipse-workspace\\com.Insta\\testdata.properties");
		//There is a File at that location
		FileInputStream Fis=new FileInputStream(file);
		// we want read data from that file
		  pro=new Properties(); // Key value pair
		// we want to use property file key value
		pro.load(Fis); // Link between property file and file input stream
		
	}
	public WebDriver SetUpBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",pro.getProperty("ChromeDrivePath"));
		 driver=new ChromeDriver(); //object of chrome driver we stored in web driver interface
		//driver.get("https://www.facebook.com/"); //get method is use to open any url in any browser.
		driver.navigate().to(pro.getProperty("URL")); // navigate method is also use to open any url in any browser.
		Thread.sleep(3000); // it will wait for 3 sec
		driver.manage().window().maximize(); // maximize the window or browser
	    return driver;
	}
	public void tearDown1()
	{
		driver.close();
	}
	public Object[][] ExcelRead() throws IOException
		{  
			//Specify the path of Excel
			File src=new File(pro.getProperty("Excelpath"));
			// Load the data in background
			FileInputStream fis=new FileInputStream(src);
			//Load workBook
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			// Load sheet
			XSSFSheet sh=wb.getSheet(pro.getProperty("SheetName"));
			int LastRow=sh.getLastRowNum();  //  4
		    System.out.println("LastRow"+LastRow);
		    int LastCol=sh.getRow(0).getLastCellNum();  //2
		    System.out.println("LastCol"+LastCol);
		    Object[][] data=new Object[LastRow][LastCol];  
		    for (int i = 1; i <= LastRow; i++) {  //i is controlling the row  0-5
				
		    	XSSFRow row = sh.getRow(i); //1---->2
		    	for (int j = 0; j < LastCol; j++) {  //j is controlling the column  0-1
					//i=2  j=0
		    //		System.out.print(row.getCell(j).getStringCellValue()+"|");
				// data[0][0]=nikhil;
		    	// data[0][1]=Pass1;	
		    		// data[1][0]=Avish;
		    		// data[1][1]=Pass2;
		     data[i-1][j]=	row.getCell(j).getStringCellValue();   	
		    	}
			}
			return data;  //dataprovider
		}
			
			public void captureScreenShot()
			{
				File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String location=pro.getProperty("screenShotPath")+System.currentTimeMillis()+".png";
				try
				{
					FileUtils.copyFile(srcfile, new File(location));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

}
