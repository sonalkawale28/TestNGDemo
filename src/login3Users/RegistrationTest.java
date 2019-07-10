package login3Users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.grid.internal.exception.NewSessionException;
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

public class RegistrationTest {
	public WebDriver driver;
	
  @Test(dataProvider = "getdata")
  public void loginwithValidds(String username, String password) 
  {
	System.out.println("loginwithValidds under Test"); 
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@name='login']")).click();
	System.out.println("user has login successfully");
	driver.findElement(By.linkText("SIGN-ON")).click();
  }
  @BeforeMethod
  public void getAllcookies()
  {
	  System.out.println("getAllcookies under BeforeMthod");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
	  
  }

  @AfterMethod
  public void captureScreenShot() throws IOException 
  {
	  System.out.println("captureScreenShot under AfterMethod");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("F:\\JAVA.TestNG-workspace\\TestNGdemo\\Screenstot"));
	  System.out.println("screenshot has captured successfully");
  }


  @DataProvider
  public Object[][] getdata() {
    return new Object[][] {
      new Object[] { "S1", "P1" },
      new Object[] { "S2", "P2" },
      new Object[] { "S2", "P3" },
    };
  }
  @BeforeClass
  public void maximizeBrowser()
  {
	 System.out.println("maximizeBrowser under BeforeClass");
	 driver.manage().window().maximize();
	 System.out.println("Window has maximize successfully");
  }

  @AfterClass
  public void deleteAllcookies() 
  {
	System.out.println("deleteAllcookies under AfterClass");
	driver.manage().deleteAllCookies();
	System.out.println("All cookies has been deleted");
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("enterApplicationURL under BeforeTest");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  System.out.println("url entered successfully");
  }

  @AfterTest
  public void dbConnectionclosed() 
  {
	  System.out.println("db connection under AfterTest");
  }

  @BeforeSuite
  public void openBrowser()
  {
	  System.out.println("openBrowser under BeforeSuite");
	  System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Selenium and crome setup\\chromedriver74v.exe");
	  driver=new ChromeDriver();
	  System.out.println("chrome Browser opened successfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("closeBrowser under AfterSuite");
	  driver.close();
  }

}
