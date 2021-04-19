package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicarLink("Contas");
		clicarLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicarLink("Constas");
		clicarLink("Listar");
	}
	
	public void acessarTelaInserirMovimentacao() {
		clicarLink("Criar Movimenta��o");
	}
	
	public void acessarTelaResumo() {
		clicarLink("Resumo Mensal");
	}

}
