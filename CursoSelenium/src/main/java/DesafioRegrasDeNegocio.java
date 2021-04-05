import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DesafioRegrasDeNegocio {
	
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
	public void testarCampoNome() {
		
		
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
	}
	
	@Test
	public void testarCampoSobreNome() {
		
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("ERIK");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
	}
	
	@Test
	public void testarRadioButton() {
		
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("ERIK");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("LIMA");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
	}
	
	@Test
	public void testarCheckBox() {
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("ERIK");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("LIMA");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
	}
	
	@Test
	public void testarSelecao() {
		
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("ERIK");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("LIMA");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		
		Select esporte1 = new Select(driver.findElement(By.id("elementosForm:esportes")));
		esporte1.selectByVisibleText("Karate");
		
		Select esporte2 = new Select(driver.findElement(By.id("elementosForm:esportes")));
		esporte2.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
	}
}
