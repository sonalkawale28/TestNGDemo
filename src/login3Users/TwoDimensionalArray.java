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

public class TwoDimensionalArray
{
	public WebDriver driver;
  @Test(dataProvider = "getdata")
  public void loginwithValidds(String username, String password)
  {
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@name='login']")).click();
	  System.out.println("user able to login successfully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @BeforeMethod
  public void getAllcookies()
  {
	  System.out.println("getAllcookies under BeforeMethod");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
  }

  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("F:\\JAVA.TestNG-workspace\\TestNGdemo\\Screenstot"));
	  System.out.println("Screenshot has captured");
  }


  @DataProvider
  public Object[][] getdata() 
  {
	  Object[][] data=new Object[3][2];
    
      data[0][0]="Suvidyap1";
      data[0][1]="P@ssword1";
      data[1][0]="Suvidyap2";
      data[1][1]="P@ssword2";
      data[2][0]="Suvidyap3";
      data[2][1]="P@ssword3";
      
      return data;
  }
  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("maximizeBrowser under BeforeClass");
	  driver.manage().window().maximize();
	  System.out.println("Browser has maximized ");
  }

  @AfterClass
  public void deleteAllcookies()
  {
	  System.out.println("deleteAllcookies under AfterClass");
	  driver.manage().deleteAllCookies();
	  System.out.println("All cookies are deleted");
  }

  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("enterApplicationURL under BeforeTest");
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  System.out.println("URL of mercury application is entered");
  }

  @AfterTest
  public void dbconnectionclose() 
  {
	  System.out.println("dbconnectionclose under AfterTest");
	  
  }

  @BeforeSuite
  public void openBrowser() 
  {
	  System.out.println("openBrowser under BeforeSuite");
	  System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Selenium and crome setup\\chromedriver74v.exe");
	  driver=new ChromeDriver();
	  System.out.println("Browser open successfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("closeBrowser under AfterSuit");
	  driver.close();
  }

}
