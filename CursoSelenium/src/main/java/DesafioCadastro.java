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
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(800, 600));
		driver.get("file:///C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\campo-treinamento\\componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	
	@Test
	public void deveRealizarCadastroComSucesso() {
		dsl.escreve("elementosForm:nome", "Wagner");
		dsl.escreve("elementosForm:sobrenome", "Costa");
		dsl.clicarRadioButton("elementosForm:sexo:0");
		dsl.clicarRadioButton("elementosForm:comidaFavorita:2");
		dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.clicarBotao("elementosForm:cadastrar");
		
		Assert.assertTrue(dsl.obterTexto("resultado").startsWith("Cadastrado!"));
		Assert.assertTrue(dsl.obterTexto("descNome").endsWith("Wagner"));
		Assert.assertEquals("Sobrenome: Costa",  dsl.obterTexto("descSobrenome"));
		Assert.assertEquals("Sexo: Masculino",  dsl.obterTexto("descSexo"));
		Assert.assertEquals("Comida: Pizza", dsl.obterTexto("descComida"));
		Assert.assertEquals("Escolaridade: mestrado", dsl.obterTexto("descEscolaridade"));
		Assert.assertEquals("Esportes: Natacao", dsl.obterTexto("descEsportes"));
		
		System.out.println("O teste terminou");
		
	}
	
}
