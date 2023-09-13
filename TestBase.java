package com.CRM.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.QA.Utile.TestUtilClass;
import com.CRM.QA.Utile.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
    @SuppressWarnings("deprecation")
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListner;
	
	public TestBase() throws Exception{
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\balar\\eclipse-workspace\\CRMdataAnalysis\\src\\main\\java\\com\\CRM\\QA\\config\\config.Properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void initilization() throws Exception {
		String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")) {
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
	      WebDriverManager.chromedriver().setup();
	       driver=new ChromeDriver(opt);
	       
	       
		}else if(BrowserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		e_driver= new EventFiringWebDriver(driver);
		eventListner=new WebEventListner();
		e_driver.register(eventListner);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilClass.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
}
