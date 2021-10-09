package cart;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.confirmation;

import resources.Utility;
import resources.baseClass;

public class test_confirmation extends baseClass {

	confirmation cm;
	@BeforeClass
	public void object() {
		cm = new confirmation(driver);
	}
	
	@Test
	public void test_submission() throws InterruptedException {
		Thread.sleep(5000);
		cm.applypromo("RahulShettyAcademy");
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void getss(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			Utility.getScreenshot(result.getName());
		}
	}
}
