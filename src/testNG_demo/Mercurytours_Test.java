package testNG_demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Mercurytours_Test 
{
	public WebDriver driver;
  @Test
  public void loginWithValidds() 
  {
	  System.out.println("In loginWithValidds under Test annotation");
	  driver.findElement(By.name("userName")).sendKeys("sonal");
	  driver.findElement(By.name("password")).sendKeys("sonal123");
	  driver.findElement(By.name("login")).click();
	  System.out.println("User has login into Mercury tours application successfully");
	  driver.findElement(By.linkText("SIGN-ON")).click();
	  
	  
  }
  @BeforeMethod
  public void getAllCookies() 
  {
	  System.out.println("In getAllCookies under BeforeMethod annotation");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie  cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
	  System.out.println("All cookies are deleted successfully");
  }

  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  System.out.println("In captureScreenshot under AfterMethod annotation");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src,new File("F:\\JAVA.TestNG-workspace\\TestNGdemo\\Screenstot"));
	  System.out.println("Screenstot is captured successfully");
  }

  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("In maximizeBrowser under BeforeClass annotation");
	  driver.manage().window().maximize();
	  System.out.println("Chrome browser is maximized successfully");
  }

  @AfterClass
  public void deleteAllCookies() 
  {
	System.out.println("deleteAllCookies under AfterClass annotation"); 
	driver.manage().deleteAllCookies();
	System.out.println("All cookies are deleted");
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("In enterApplicationURL under BeforeTest annotation");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  System.out.println("Application url has entered successfully");
	  
  }

  @AfterTest
  public void dbConnectionClosed() 
  {
	  System.out.println("dbConnectionClosed under AfterTest annotation");
  }

  @BeforeSuite
  public void openBrowser() 
  {
	System.out.println("In openBrowser under BeforeSuite annotation");
	System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Selenium and crome setup\\chromedriver74v.exe");
	driver=new ChromeDriver();
	System.out.println("Chrome browser is opened successfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("closeBrowser under AfterSuite annotation");
	  driver.close();
  }

}
