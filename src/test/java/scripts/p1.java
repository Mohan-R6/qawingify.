package scripts;

import org.testng.annotations.Test;

import generic.basetest;
import pages.intitalisepages;

public class p1 extends basetest {
	 @Test
	 public void sakshiHomePageCheckingSortedValues() {
     
	/*creates the object of intialisepages */
	 intitalisepages ob=new intitalisepages(driver);
	 
	 /*login into the application*/
	 ob.sakshiLogin.login(p.getProperty("username"),p.getProperty("password"));	
	  
	 /*clicks on the amount header*/
	//ob.sakshiHome.ClickingOnAmount(driver);
	 
	 /*fetches the values in the amount column after clicking on amount header*/
	 ob.sakshiHome.ValuesAfterClickingAmount(driver);
	 
	 /*validates the values are sorted */
	 ob.sakshiHome.ValidatingTheValuesIsSortedOrNot(driver);
	
}
}