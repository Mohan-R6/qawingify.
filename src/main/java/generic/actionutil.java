package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class actionutil {

	 WebDriver driver;
	 public actionutil(WebDriver driver)
	 {
	 	 this.driver=driver;
	 }
	 
	//method to retrive data from excel
	public static String getdata(String path,String sn,int r,int c) 
	{  
		try {
			FileInputStream f1 = new FileInputStream(path);
			Workbook	book = WorkbookFactory.create(f1);
			String d = book.getSheet(sn).getRow(r).getCell(c).getStringCellValue();
			return d;
			
		 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	public void ValidateTitle(String expectedTile) 
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs(expectedTile));
			System.out.println("pass:Homepage titile is matching");
			System.out.println("___________________________");
			System.out.println("                           ");
		}
		catch(Exception e){
			System.out.println("fail:titile is not matching");
			Assert.fail();
		}
	}
	 
	 
	}

