package br.ce.wcaquino.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class TesteFrames {
	
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver.manage().window().setSize(new Dimension(800, 600));
		driver.get("file:///C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\campo-treinamento\\componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveInteragirComFrames() {
		
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
		
		System.out.println("O teste terminou");
		
	}
}
