package cart;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.proceedpage;

import resources.Utility;
import resources.baseClass;

public class testProceed extends baseClass {

	proceedpage pp;
	
	@BeforeClass
	public void object() {
		pp = new proceedpage(driver);
	}
	
	@Test
	public void testProccedbutton() throws InterruptedException {
		Thread.sleep(3000);
		pp.clickProceed();
	}
	
	public void getss(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			Utility.getScreenshot(result.getName());
		}
	}
	
}
