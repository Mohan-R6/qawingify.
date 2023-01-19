package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class basetest {
	public static final String userDir=System.getProperty("user.dir");
	public static final String chromeKey="webdriver.chrome.driver";
	public static final String geckoKey="webdriver.gecko.driver";
	public static final String chromeValue=userDir+"\\drivers\\chromedriver.exe";
	public static final String geckoValue=userDir+"\\drivers\\geckodriver.exe";
	 
	
	public WebDriver driver;
	public static Properties  p; 
	public static actionutil util;
	 
	@BeforeClass
	public void setpath()
	{
		try {
			FileInputStream f = new FileInputStream(userDir+"\\data\\acti.properties");
			  p = new Properties();
			p.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//sets the path for chromedriver.exc
		System.setProperty(chromeKey, chromeValue);
		//sets the path for geckodriver.exc
		System.setProperty(geckoKey, geckoValue);
	}

	@Parameters("BrowserName")
	@BeforeMethod
	 public void launchBrowser(String bn){
		//launches the chrome browser
		if(bn.equals("chrome"))
	    driver=new ChromeDriver();
		//launches the firefox browser
		else if(bn.equals("firefox"))
	    driver=new FirefoxDriver();
		//launches the edge browser
		else if(bn.equals("edge"))
		driver=new EdgeDriver();
		util=new actionutil(driver);
		//defines implicitly wait for 30 sec//
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//maximises the window//
		driver.manage().window().maximize();
		//fetches the webpage and waits untill its loaded
		driver.get(p.getProperty("url"));
		 
}
	@AfterMethod
	public void closeBrowser() {
		 
		//closes the browser
		 driver.close();
}
	@AfterSuite
	public void killDriver() {
		try {
			Runtime.getRuntime().exec("taskkill /IM chromedriver.exe /F");
			Runtime.getRuntime().exec("taskkill /IM geckodriver.exe /F");
			Runtime.getRuntime().exec("taskkill /IM edgedriver.exe /F");
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	}
}
