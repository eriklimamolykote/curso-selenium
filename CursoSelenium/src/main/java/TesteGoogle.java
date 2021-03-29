import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
}
