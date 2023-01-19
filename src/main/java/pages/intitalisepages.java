package pages;

import org.openqa.selenium.WebDriver;

public class intitalisepages {

	public sakshiLogin_page sakshiLogin;
	public sakshiHome_page sakshiHome;
	public intitalisepages(WebDriver driver) {
		
		this.sakshiLogin=new sakshiLogin_page(driver);
		this.sakshiHome=new sakshiHome_page(driver);
	}
}
