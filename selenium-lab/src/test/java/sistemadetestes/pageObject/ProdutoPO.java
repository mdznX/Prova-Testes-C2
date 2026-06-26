package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{

	@FindBy(id = "btn-adicionar")
	public WebElement buttonAdicionar;

	@FindBy(id = "codigo")
	public WebElement inputCodigo;

	@FindBy(id = "nome")
	public WebElement inputNome;

	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;

	@FindBy(id = "valor")
	public WebElement inputValor;

	@FindBy(id = "data")
	public WebElement inputData;

	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;

	@FindBy(css = "div.alert>span")
	public WebElement spanMensagem;

	/**
	 * Construtor padrão para criação de uma nova instância da página de produtos
	 * @param driver Driver da página de produtos
	 */
	public ProdutoPO(WebDriver driver) {
		super(driver);
	}

	public String obterMensagem() {
		return this.spanMensagem.getText();
	}

	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}

	public String obterTituloPagina() {
		return driver.getTitle();
	}

	/**
	 * Método que tenta executar a ação de cadastrar um produto
	 * @param codigo Código do produto
	 * @param nome Nome do produto
	 * @param quantidade Quantidade do produto
	 * @param valor Valor do produto
	 * @param data Data de cadastro
	 */
	public void executarAcaoDeCadastrarProduto(String codigo, String nome, String quantidade, String valor, String data) {

		buttonAdicionar.click();

		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);

		buttonSalvar.click();
	}

	public String obterTituloDaPagina() {
		return driver.getTitle();
	}

}