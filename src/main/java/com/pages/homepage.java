package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.baseClass;

public class homepage  {
	
	WebDriver driver;	
	Logger log = LogManager.getLogger(homepage.class.getName());
	
	public homepage(WebDriver driver) {
		this.driver=driver;
	}

	By input = By.cssSelector("input[type='Search']");
	By search = By.cssSelector("button[type='submit']");
	By add = By.xpath("//button[text()='ADD TO CART']");
	By price = By.xpath("parent::div/parent::div//p");
	By cart = By.xpath("//img[@alt='Cart']");
	By namesloc = By.xpath("//h4[@class='product-name']");
	By priceloc = By.xpath("//p[@class='product-price']");
	
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> in = new ArrayList<String>();
	ArrayList<String> pl = new ArrayList<String>();
	
	
	public void sendSearch(String data) {
		driver.findElement(input).sendKeys(data);
		log.info("Data sent to search");		
	}
	
	public void clickSearch() {
		driver.findElement(search).click();
		log.info("Search button clicked");
	}
	
	public ArrayList<String> clickAdd() {
		
		List<WebElement> buttons = driver.findElements(add);
		
		for (WebElement button:buttons) {
			button.click();
			log.info("button clicked");
			String pr = button.findElement(price).getText();
			log.info("Price returned");
			al.add(pr);
			
		}
		return al;
	}
	
	public void clickCart() {
		driver.findElement(cart).click();
	}
	
	
	
	public ArrayList<String> clickaddagain(String[]items) {
		
		List<WebElement> itemnames = driver.findElements(namesloc);
		List<WebElement> addbuttons = driver.findElements(add);
		List<WebElement> pricelists = driver.findElements(priceloc);
		for (WebElement item:itemnames) {
			String itemname = item.getText();
			String[] itemwithoutquan = itemname.split("-");
			String finalname = itemwithoutquan[0].trim();
			in.add(finalname);
		}
		
		log.info("got the final names of the page");
		
		for (int i=0; i<items.length; i++) {
			if(in.contains(items[i])) {
				int j=in.indexOf(items[i]);
				
				addbuttons.get(j).click();
				pl.add(pricelists.get(j).getText());
			}
		}
		log.info("price returned and selected element clicked");
		return pl;
		
	}
}

	
		
	