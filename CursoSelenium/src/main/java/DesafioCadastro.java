import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class DesafioCadastro {
	
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
	public void cadastrarUsuario() {
	
		driver.manage().window().maximize();
		driver.get("file:///C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\campo-treinamento\\componentes.html");
		WebElement campoNome = driver.findElement(By.id("elementosForm:nome"));
		campoNome.sendKeys("ERIK TESTE CAMPO NOME");
		WebElement campoSobrenome = driver.findElement(By.id("elementosForm:sobrenome"));
		campoSobrenome.sendKeys("ERIK TESTE CAMPO SOBRENOME");
		WebElement radioButton = driver.findElement(By.id("elementosForm:sexo:0"));
		radioButton.click();
		WebElement checkBox = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		checkBox.click();
		Select dropDown1 = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
		dropDown1.selectByVisibleText("Superior");
		Select dropDown2 = new Select(driver.findElement(By.id("elementosForm:esportes")));
		dropDown2.selectByVisibleText("Karate");
		WebElement botaoCadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
		botaoCadastrar.click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("ERIK TESTE CAMPO NOME"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("ERIK TESTE CAMPO SOBRENOME"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Pizza"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Karate"));
		Assert.assertTrue(driver.findElement(By.id("descSugestoes")).getText().endsWith(""));
		
		System.out.println(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		System.out.println("O teste terminou");
		
	}
	
}
