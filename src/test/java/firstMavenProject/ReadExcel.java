package firstMavenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.testng.annotations.Test;

public class ReadExcel {
	
	@Test
	public void readDataFromExcel() throws IOException
	{  
		//Specify the path of Excel
		File src=new File("E:\\JavaSeleniumBtch Data\\Excel practise data\\Book1.xlsx");
		// Load the data in background
		FileInputStream fis=new FileInputStream(src);
		//Load workBook
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		// Load sheet
		XSSFSheet sh=wb.getSheet("MST");
		// Fetch the Sheet name 
		System.out.println(sh.getSheetName());
		// Row and column fetch
		String s=sh.getRow(1).getCell(1).getStringCellValue();
		System.out.println("Data coming from the Excel is: "+s);
		System.out.println(sh.getLastRowNum()); //5
		System.out.println(sh.getPhysicalNumberOfRows()); //6
		System.out.println(sh.getRow(1).getLastCellNum()); //2
		System.out.println(sh.getRow(1).getPhysicalNumberOfCells()); //2
		
	}

}
