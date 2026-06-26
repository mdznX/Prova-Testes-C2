package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {

    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void iniciarTestes() {

        driver.get("file:///36129382024.2m/sistema/produtos.html");

        produtoPage = new ProdutoPO(driver);
    }

    // TC006 - Código vazio
    @Test
    public void TC006_naoDeveCadastrarComCodigoVazio() {

        produtoPage.executarAcaoDeCadastrarProduto(
                "",
                "Notebook",
                "10",
                "5000",
                "2026-06-26"
        );

        String msg = produtoPage.obterMensagem();

        assertEquals(
                "Todos os campos são obrigatórios para o cadastro!",
                msg
        );
    }

    // TC007 - Nome vazio
    @Test
    public void TC007_naoDeveCadastrarComNomeVazio() {

        produtoPage.executarAcaoDeCadastrarProduto(
                "001",
                "",
                "10",
                "5000",
                "2026-06-26"
        );

        String msg = produtoPage.obterMensagem();

        assertEquals(
                "Todos os campos são obrigatórios para o cadastro!",
                msg
        );
    }

    // TC010 - Cadastro válido
    @Test
    public void TC010_deveCadastrarProdutoComSucesso() {

        produtoPage.executarAcaoDeCadastrarProduto(
                "001",
                "Notebook Gamer",
                "10",
                "5000",
                "2026-06-26"
        );

        // valida se entrou na tabela HTML
        String tabela = driver.findElement(By.tagName("tbody")).getText();

        assertTrue(tabela.contains("001"));
        assertTrue(tabela.contains("Notebook Gamer"));
        assertTrue(tabela.contains("10"));
        assertTrue(tabela.contains("5000"));
        assertTrue(tabela.contains("2026-06-26"));
    }
}