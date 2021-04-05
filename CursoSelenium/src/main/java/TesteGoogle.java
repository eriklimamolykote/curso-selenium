import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver.manage().window().setSize(new Dimension(800, 600));
		driver.get("http://www.google.com");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void teste() {
		
		Assert.assertEquals("Google", driver.getTitle());
		System.out.println(driver.getTitle());
		
	}
	
}
