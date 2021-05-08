package com.crm.vtiger.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import objectRepositoryUtils.HomePage;
import objectRepositoryUtils.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");	
	}
	public WebDriver driver;
	public static WebDriver sdriver;
	public WebDriverUtility wdu=new WebDriverUtility();
	public JavaUtility ju=new JavaUtility();
	public FileUtility fu=new FileUtility();
	public ExcelUtility eu=new ExcelUtility();		
	
	
	
	
	@BeforeSuite(groups= {"smoke_test","regrassion_test"})
	public void configBS() {
		//connection with database
	}
	
	@BeforeTest(groups= {"smoke_test","regrassion_test"})
	public void configBT() {
		//launch browser in parallel execution
	}
	
	//@Parameters("browser")
//	@BeforeClass(groups= {"smoke_test","regrassion_test"})
//	public void configBC(String browser) {	
//		if(browser.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(browser.equalsIgnoreCase("firefox")){
//			driver=new FirefoxDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}
//		wdu.waitUtilPageLoad(driver);
//		driver.manage().window().maximize();
//	}
	
	@BeforeClass(groups= {"smoke_test","regrassion_test"})
	public void configBC() {			
		driver=new ChromeDriver();		
		wdu.waitUtilPageLoad(driver);
		driver.manage().window().maximize();
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smoke_test","regrassion_test"})
	public void setUp() throws Throwable {
		driver.get(fu.getDataFromProperty("url"));
		LoginPage lpgn=new LoginPage(driver);
		lpgn.setLogin(fu.getDataFromProperty("username"), fu.getDataFromProperty("password"));		
	}
	
	@AfterMethod(groups= {"smoke_test","regrassion_test"})
	public void testDown() throws Throwable {		
		HomePage hp=new HomePage(driver);		
		hp.logout();		
	}
	
	@AfterClass(groups= {"smoke_test","regrassion_test"})
	public void ConfigAC() {
		driver.close();
	}
	
	@AfterTest(groups= {"smoke_test","regrassion_test"})
	public void ConfigAT() {
	}
	
	@AfterSuite(groups= {"smoke_test","regrassion_test"})
	public void configAS() {
	}
}
