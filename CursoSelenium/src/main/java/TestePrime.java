import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;
import junit.framework.Assert;

public class TestePrime {
	
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
	public void deveInteragirComRadioPrime() {
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt86:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));
	}
}