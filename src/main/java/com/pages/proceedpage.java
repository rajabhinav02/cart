package com.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sun.tools.sjavac.Log;

import resources.baseClass;

public class proceedpage  {
	
	WebDriver driver;
	Logger log = LogManager.getLogger(proceedpage.class.getName());
	
	public proceedpage(WebDriver driver) {
		this.driver= driver;
	}
	
	By proceedbutton = By.xpath("//button[contains(text(),'PROCEED')]");
	
	public void clickProceed() {
		driver.findElement(proceedbutton).click();
		log.info("Clicked on proceed to checkout");
	}

}
