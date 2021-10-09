package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass {
	public static WebDriver driver;
	public static Properties pro;
	
	public WebDriver getSetup() throws IOException {
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
	pro = new Properties();
	pro.load(fis);
	
	if (System.getProperty("browser").contains("chrome")) {
		
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		if (System.getProperty("browser").contains("headless")) {
			options.addArguments("headless");
		}
		
		driver = new ChromeDriver(options);
		driver.get(pro.getProperty("url"));
	}else if (pro.get("browser").equals("firefox")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(pro.getProperty("url"));
	}	
	return driver;
}
}
