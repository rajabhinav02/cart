package cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.confirmation;
import com.pages.homepage;
import com.pages.proceedpage;

import resources.Utility;
import resources.baseClass;

public class test_values extends baseClass {
	
	homepage hm;
	proceedpage pp;
	confirmation cm;
	SoftAssert sa;
	String[] items = {"Mushroom","Musk Melon","Onion"};

	@BeforeTest
	public void classsetup() throws IOException, InterruptedException {
		Thread.sleep(5000);
		driver = getSetup();
		driver.get(pro.getProperty("url"));
		hm = new homepage(driver);
		pp = new proceedpage(driver);
		cm = new confirmation(driver);
		sa = new SoftAssert();
	}
	
	@Test (priority=1,groups= {"smoke", "regression"}, enabled=false)
	public void validatevegselection() throws InterruptedException {
		/*ArrayList al = new ArrayList();
		al.add(a);
		al.add(b);
		al.add(c);
		al.add(d);
		
		Object[] items = al.toArray();
		String[] stritems = new String[al.size()];
		
		int i=0;
		
		for (Object obj:items) {
			stritems[i++]=(String) obj;
		}*/
		
		hm.clickaddagain(items);
		Thread.sleep(3000);
		hm.clickCart();
		Thread.sleep(3000);
		pp.clickProceed();
		Thread.sleep(5000);
		ArrayList name=cm.getProductnames();
		Object[]obj= name.toArray();
		Assert.assertEquals(items, obj);
		
		int sum =cm.getPriceselected();
		int total =cm.getFinalTotal();
		System.out.println(total);
		
		Assert.assertEquals(sum, total);
		
		Thread.sleep(5000);
		cm.applypromo("rahulshettyacademy");
		//int total = cm.getFinalTotal();
		//Thread.sleep(15000);
		float distotal = cm.getDiscTotal();
		System.out.println(distotal);
		Assert.assertTrue(total>distotal);
		
		sa.assertAll();
					
		}
	
	
	/*public void validateTotal() {
		int sum =cm.getPriceselected();
		int total =cm.getFinalTotal();
		
		Assert.assertEquals(sum, total);
	}
	
	
	public void validatedis() throws InterruptedException {
		Thread.sleep(5000);
		cm.applypromo("rahulshettyacademy");
		int total = cm.getFinalTotal();
		float distotal = cm.getDiscTotal();
		Assert.assertTrue(total>distotal);
	}*/
	
	@AfterMethod
	public void takess(ITestResult result) throws IOException {
	
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.getScreenshot(result.getName());
		}
	}
	
	@AfterTest
	 public void  teardown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
	
	/*@DataProvider
	public Object[][] inputdata() {
		Object[][] data=new Object[4][1];
		data[0][0]="Mushroom";
		data[1][0]= "Musk Melon";
		data[2][0]= "Onion";
		data[3][0]= "Brinjal";
		return data;
	}*/
	}
	

