import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(800, 600));
		driver.get("file:///C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\campo-treinamento\\componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		driver = new FirefoxDriver();
		WebElement textoTextField = driver.findElement(By.id("elementosForm:nome"));
		textoTextField.sendKeys("Teste textField");
		// Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement textoTextArea = driver.findElement(By.id("elementosForm:sugestoes"));
		textoTextArea.sendKeys("Teste textArea");
		// Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement radioButton = driver.findElement(By.id("elementosForm:sexo:0"));
		radioButton.click();
		radioButton.isSelected();
		Assert.assertTrue(radioButton.isSelected());
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement checkBox = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		checkBox.click();
		checkBox.isSelected();
		Assert.assertTrue(checkBox.isSelected());
	}
	
	@Test
	public void deveInteragirComComboBox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement comboBox = driver.findElement(By.id("elementosForm:escolaridade"));
		Select opcaoGraduacao = new Select(comboBox);
		// opcaoGraduacao.selectByIndex(2);
		// opcaoGraduacao.selectByValue("superior");
		opcaoGraduacao.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", opcaoGraduacao.getFirstSelectedOption().getText());
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement comboBox = driver.findElement(By.id("elementosForm:escolaridade"));
		Select opcaoGraduacao = new Select(comboBox);
		List<WebElement> options = opcaoGraduacao.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for (WebElement option: options ) {
			if (option.getText().equals("Opcao qualquer")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement comboMult = driver.findElement(By.id("elementosForm:esportes"));
		Select opcaoEsporte = new Select(comboMult);
		opcaoEsporte.selectByVisibleText("Natacao");
		opcaoEsporte.selectByVisibleText("Corrida");
		opcaoEsporte.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions =  opcaoEsporte.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		opcaoEsporte.deselectByVisibleText("Corrida");
		allSelectedOptions = opcaoEsporte.getAllSelectedOptions();
		Assert.assertEquals(2,  allSelectedOptions.size());
	}
	
	@Test
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		WebElement botao1 = driver.findElement(By.id("buttonSimple"));
		botao1.click();
		
		Assert.assertEquals("Obrigado!", botao1.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\campo-treinamento\\componentes.html");
		
		System.out.println(driver.findElement(By.tagName("body")).getText());
		
		// Assert.assertTrue(driver.findElement(By.tagName("body"))
		// .getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", 
				driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				driver.findElement(By.className("facilAchar")).getText());
		
	}
	
}