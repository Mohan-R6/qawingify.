package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.basetest;

public class sakshiLogin_page {

	@FindBy(xpath="//input[@id='username']")
	private WebElement tbUsename;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement tbPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement cheRem;
	
	@FindBy(xpath="//button[@id='log-in']")
	private WebElement btnLogin;
	
	
	public void login(String un,String pw) {
		this.tbUsename.sendKeys(un);
		this.tbPassword.sendKeys(pw);
		this.cheRem.click();
		this.btnLogin.click();
		
		basetest.util.ValidateTitle("Demo App");
	
		 
	}
	
    public sakshiLogin_page(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
	
}
