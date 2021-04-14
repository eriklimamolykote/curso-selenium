package br.ce.wcaquino.test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;

public class TesteCampoTreinamento {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		// driver.quit();
	}

	@Test
	public void testeTextField() {
		dsl.escrever("elementosForm:nome", "Teste de escrita");
		WebElement textoTextField = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		textoTextField.sendKeys("Teste textField");
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
		
		dsl.escrever("elementosForm:sugestoes", "teste\\n\naas\\djdlks\\nUltima linha");
		WebElement textoTextArea = DriverFactory.getDriver().findElement(By.id("elementosForm:sugestoes"));
		textoTextArea.sendKeys("Teste textArea");
		Assert.assertEquals("teste\\n\\naas\\djdlks\\nUltima linha", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		
		DriverFactory.getDriver().findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(DriverFactory.getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected());
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
	}
	
	@Test
	public void deveInteragirComComboBox() {
		
		dsl.selecionarCombo("elementosForm:escolaridade",  "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		
		WebElement comboBox = DriverFactory.getDriver().findElement(By.id("elementosForm:escolaridade"));
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
		
		dsl.selecionarCombo("elementosForm:esportes",  "Natação");
		dsl.selecionarCombo("elementosForm:esportes",  "Corrida");
		dsl.selecionarCombo("elementosForm:esportes",  "O que eh esporte?");
		
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions =  combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2,  allSelectedOptions.size());
	}
	
	@Test
	public void deveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		
		WebElement botao1 = DriverFactory.getDriver().findElement(By.id("buttonSimple"));
		botao1.click();
		
		Assert.assertEquals("Obrigado!", botao1.getAttribute("value"));
	}
	
	@Test
	public void deveInteragirComLinks() {
		
		dsl.clicarLink("Voltar");
		
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		
		System.out.println(DriverFactory.getDriver().findElement(By.tagName("body")).getText());
		
		// Assert.assertTrue(driver.findElement(By.tagName("body"))
		// .getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				dsl.obterTexto(By.className("facilAchar")));
		
	}
	
	@Test public void testJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		// js.executeScript("alert('Testando js via selenium')");
		js.executeScript("document.getElement(By.id('elementosForm:nome').value = 'Escrito via js'");
		js.executeScript("document.getElement(By.id('elementosForm:sobrenome').type = 'radio'");
		
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaoTabela("Escolaridade",  "Mestrado", "Radio", "elementosForm:tableUsuarios");
	}
	
}