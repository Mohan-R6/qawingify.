package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.basetest;

public class sakshiHome_page {
	
	@FindBy(xpath="//th[@id='amount']")
	private WebElement btnAmount;
	
	@FindBy(xpath="//span[contains(text(),'USD')]")
	private List<WebElement> PricesAfterClickingAmount;
	 	 
	
	List<Double>  originalList = new ArrayList();
 
	public void ClickingOnAmount(WebDriver driver) {
	      this.btnAmount.click();
	       
	}
	
	public void ValuesAfterClickingAmount(WebDriver driver) {
	  for (WebElement p: PricesAfterClickingAmount ) {
	  		originalList.add( Double.parseDouble(p.getText().replace("USD","").replaceAll(" ","").replace(",", "")));
	  }
	  
	  }
	  
	public void ValidatingTheValuesIsSortedOrNot(WebDriver driver) 
	  {
	    
		                                                       
		System.out.println("Values after clicking on the amount header ");
		System.out.println(originalList);
		
		ArrayList<Double> sortedlist=new ArrayList<Double>(originalList);
		Collections.sort(sortedlist);
		System.out.println("                                                    ");
		System.out.println("Values after sorting");
		System.out.println(sortedlist);
		
		if (sortedlist.equals(originalList) ) {
			System.out.println("                                                    ");
		} else {
			System.out.println("\"Failed:After clicking on amount header the values are not sorted(in ascending order)\"");
		}
		
		try
		 {
	  Assert.assertEquals(sortedlist, originalList);
	  System.out.println("validated:After clicking on amount header the values are sorted(in ascending order)");
		 }
		catch (Exception e) {
			
			System.out.println("Failed:After clicking on amount header the values are not sorted(in ascending order)");
		}
          
		 
	}
  
	
	 public sakshiHome_page(WebDriver driver) {
	    	PageFactory.initElements(driver, this);
	    }
}
