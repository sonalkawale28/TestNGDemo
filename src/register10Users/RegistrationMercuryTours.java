package register10Users;

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

public class RegistrationMercuryTours 
{
	public WebDriver driver;
	
  @Test(dataProvider = "getdata")
  public void registerWithValidds(String firstname, String lastname, String phone, String email, String adr1, String adr2, String city, String state, String postalcode, String username, String password, String confirmpass) 
  {
	  System.out.println("registerWithValidds under Test");
	  driver.findElement(By.name("firstName")).sendKeys(firstname);
	  driver.findElement(By.name("lastName")).sendKeys(lastname);
	  driver.findElement(By.name("phone")).sendKeys(phone);
	  driver.findElement(By.id("userName")).sendKeys(email);
	  driver.findElement(By.name("address1")).sendKeys(adr1);
	  driver.findElement(By.name("address2")).sendKeys(adr1);
	  driver.findElement(By.name("city")).sendKeys(city);
	  driver.findElement(By.name("state")).sendKeys(state);
	  driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postalcode);
	  driver.findElement(By.xpath("//select[@name='country']/child::option[@value='92']")).click();
	  driver.findElement(By.id("email")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("confirmPassword")).sendKeys(confirmpass);
	  driver.findElement(By.name("register")).click();
	  System.out.println("user has registered successfully");
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  driver.findElement(By.linkText("REGISTER")).click();
	  
	  
	  
  }
  @BeforeMethod
  public void getAllcookies() 
  {
	  System.out.println("getAllcookies under BeforeMethod");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
		  System.out.println(cookie.getDomain());
	  }
	  System.out.println("Name and domain of cookies are displayed");
  }

  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  System.out.println("captureScreenshot under AfterMethod");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("F:\\JAVA.TestNG-workspace\\TestNGdemo\\Screen10shot"));
	  System.out.println("screenshot has captured successfully");
  }


  @DataProvider
  public Object[][] getdata() {
    return new Object[][] {
      new Object[] { "sonal", "kawale", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123456", "sonal1", "pass1", "pass1"},
      new Object[] { "pankaj", "deshmukh", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123457", "sonal2", "pass2", "pass2" },
      new Object[] { "shashwat", "kawale", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123458", "sonal3", "pass3", "pass3" },
      new Object[] { "pranay", "deshmukh", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123459", "sonal4", "pass4", "pass4" },
      new Object[] { "divya", "punjabi", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123410", "sonal5", "pass5", "pass5" },
      new Object[] { "rohit", "shende", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123411", "sonal6", "pass6", "pass6" },
      new Object[] { "pallavi", "jadhao", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123412", "sonal7", "pass7", "pass7" },
      new Object[] { "pooja", "xyz", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123413", "sonal8", "pass8", "pass8" },
      new Object[] { "kajal", "abc", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123459", "sonal9", "pass9", "pass9" },
      new Object[] { "priyanka", "ghj", "1234567890", "sonal123@gmail.com", "sudarshan park", "warje naka", "pune", "Maharashtra", "123410", "sonal10", "pass10", "pass10" },
    };
  }
  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("maximizeBrowser under BeforeClass");
	  driver.manage().window().maximize();
	  System.out.println("Browser has maximize successfully");
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
	  driver.get("http://newtours.demoaut.com/mercuryregister.php");
	  System.out.println("URL of Mercury application has entered");
  }

  @AfterTest
  public void dbConnectionclose() 
  {
	  System.out.println("dbConnectionclose under AfterTest");
  }

  @BeforeSuite
  public void openBrowser() 
  {
	  System.out.println("OpenBrowser under BeforeSuit");
	  System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\Selenium and crome setup\\chromedriver74v.exe");
	  driver=new ChromeDriver();
	  System.out.println("Browser has opened successfully");
  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("closeBrowser under AfterSuit");
	  driver.close();
  }

}
