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
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(800, 600));
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		System.out.println(driver.getTitle());
		
	}
	
}
