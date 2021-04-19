package br.ce.wcaquino.tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MovimentacaoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void testCamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data de Movimenta��o � obrigat�rio", erros.get(0));
		// Assert.assertTrue(erros.contains("Data de Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data de Movimenta��o � obrigat�rio", "Data de pagamento � obrigat�rio",
				"Descri��o � obrigat�rio", "Interessado � obrigat�rio", 
				"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6,  erros.size());
	}
	
	@Test
	public void testInserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		List<String> erros = movPage.obterErros();
		// Assert.assertEquals("Data de Movimenta��o � obrigat�rio", erros.get(0));
		// Assert.assertTrue(erros.contains("Data de Movimenta��o � obrigat�rio"));
		Assert.assertTrue(
				erros.contains("Data de Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1,  erros.size());
	}

}
