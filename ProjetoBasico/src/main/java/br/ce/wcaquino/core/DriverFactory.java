package br.ce.wcaquino.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {}
	
	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX: 
				System.setProperty("webdriver.geckodriver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
				driver = new FirefoxDriver(); 
				break;
			case CHROME:
				System.setProperty("webdriver.chromedriver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\chromedriver.exe");
				driver = new ChromeDriver(); 
				break;
			}
			driver.manage().window().setSize(new Dimension(800, 600));
		}
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		
	}
	
}
