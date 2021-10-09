package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class confirmation {

	WebDriver driver;
	
	Logger log = LogManager.getLogger(confirmation.class.getName());
	
	public confirmation(WebDriver driver) {
		this.driver=driver;
	}
	
	By productnamesloc = By.xpath("//p[@class='product-name']");
	By totalindpriceloc = By.xpath("//tr/td[5]/p");
	By promocode= By.cssSelector("[class='promoCode']");
	By applybtn = By.cssSelector("[class='promoBtn']");
	By totallast = By.cssSelector("[class='totAmt']");
	By totafterdis = By.cssSelector("[class='discountAmt']");
	
	
	public ArrayList<String> getProductnames() {
		ArrayList<String> kl = new ArrayList<String>();
		
		List<WebElement> selitems = driver.findElements(productnamesloc);
		
		for(WebElement selitem:selitems) {
			String[]itemsspace=selitem.getText().split("-");
			String finallist = itemsspace[0].trim();
			kl.add(finallist);
			
		}return kl;
	}
	
	public int getPriceselected() {
		List<WebElement> prices = driver.findElements(totalindpriceloc);
		
		int sum = 0;
		for (WebElement price:prices) {
			String priceselect = price.getText();
			int priceselected = Integer.parseInt(priceselect);
			sum = sum+ priceselected;
			
		} return sum;
	}
	
	public void applypromo(String code) {
		driver.findElement(promocode).sendKeys(code);
		driver.findElement(applybtn).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.textToBe(applybtn, "Apply"));
		//wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(applybtn), "Apply"));
		wait.until(ExpectedConditions.textToBe(applybtn, "Apply"));
	}
	
	public int getFinalTotal() {
		String finaltotal = driver.findElement(totallast).getText();
		System.out.println(finaltotal);
		int fintot = Integer.parseInt(finaltotal);
		return fintot;
	}
	
	public float getDiscTotal() {
		String disTotal = driver.findElement(totafterdis).getText();
		float distot = Float.parseFloat(disTotal);
		return distot;
	}
}
