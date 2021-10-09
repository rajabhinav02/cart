package cart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class practicevegcart {

	@Test
	public void get() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver92\\chromedriver_win32 (5)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ArrayList al = new ArrayList();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String[] itemstoselect = {"Brocolli", "Cucumber", "Beetroot", "Beans"};
		
		List<WebElement> allitems = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List<WebElement>addbuttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
		
		for (WebElement item:allitems) {
			String name = item.getText();
			String[] namewithoutquantity = name.split("-");
			String perfectname = namewithoutquantity[0].trim();
			al.add(perfectname);
		}
		
		for (int i=0; i<itemstoselect.length; i++) {
				if (al.contains(itemstoselect[i])) {
					
					int j=al.indexOf(itemstoselect[i]);
					
					addbuttons.get(j).click();
					Thread.sleep(5000);
				}
					
				}
		
		
		
	}
	
}
