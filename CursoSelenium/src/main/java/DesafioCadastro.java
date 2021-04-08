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
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(800, 600));
		driver.get("file:///C:\\Users\\ERIK LIMA\\Desktop\\curso-selenium\\campo-treinamento\\componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	
	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResutadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Wagner"));
		Assert.assertEquals("Sobrenome: Costa",  page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino",  page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());
		
		System.out.println("O teste terminou");
		
	}
	
	@Test
	public void deveValidarNomeObrigatorio() {
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio() {
		page.setNome("Nome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Sexo eh obrigatorio",  dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso() {
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		page.setComidaCarne();
		page.setEsporte("Karate", "O que eh esporte?");
		page.cadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
	
}
