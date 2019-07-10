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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_DmoTest {
  @Test
 public void f() 
  {
	  System.out.println("f under Test annotation");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("In beforeMethod under BeforeMethod annotation");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("In afterMethod under AfterMethod annotation");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("In beforeClass under BeforeClass annotation");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("In afterClass under AfterClass annotation");
  }

  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("In beforeTest under BeforeTest annotation");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("In afterTest under AfterTest annotation");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("In beforeSuit under BeforeSuit annotation");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("In afterSuit under AfterSuit annotation");
  }

}
