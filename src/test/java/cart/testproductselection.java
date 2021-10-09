package cart;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.homepage;

import resources.Utility;
import resources.baseClass;

public class testproductselection extends baseClass {
	
	homepage hm;
	String[] items= {"Cauliflower", "Brocolli", "Brinjal"};
	
	@BeforeSuite
	public void Setup() throws IOException {
		driver = getSetup();
		hm = new homepage(driver);
	}
	
	@Test
	public void test_add() {
		hm.clickaddagain(items);
		hm.clickCart();
	}
	
	
	
	@AfterMethod
	public void getssfail(ITestResult result) throws IOException {
		if (ITestResult.FAILURE== result.getStatus()) {
			Utility.getScreenshot(result.getName());
		}
	}
	
	@AfterSuite
	public void teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
