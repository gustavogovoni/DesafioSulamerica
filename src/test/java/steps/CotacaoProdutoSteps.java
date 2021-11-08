package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import helper.Esperas;
import org.junit.Assert;
import pages.ContatosPage;
import pages.DadosPessoaisPage;
import pages.HomePage;
import utils.ConfiguracaoAmbiente;
import utils.DocumentoUtil;

import static utils.Constantes.AUTORIZACAO_IMPORTANTE_PARA_TE_AJUDAR_ENCONTRAR_SEGURO;

public class CotacaoProdutoSteps extends ConfiguracaoAmbiente {
    HomePage homePage;
    Esperas esperas;
    DadosPessoaisPage dadosPessoaisPage;
    DocumentoUtil documentoUtil;
    ContatosPage contatosPage;

    @Before
    public void inicializa() {
        getDriver();
        homePage = new HomePage();
        esperas = new Esperas();
        dadosPessoaisPage = new DadosPessoaisPage();
        documentoUtil = new DocumentoUtil();
        contatosPage = new ContatosPage();
    }


    @Dado("^que estou no site na opcao de simulacao$")
    public void queEstouNoSiteNaOpcaoDeSimulacao() throws Throwable {
        iniciaUrl("https://contratafacil-segurovida.paas.sulamerica.com.br/?corretor_id=f6931093-e743-4553-88f\n" +
                "6-9d04e3cec067");
        homePage.clicarBotaoQueroSimular();

    }

    @Quando("^preencho os campos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void preenchoOsCampos(String nome, String data, String ocupacao) throws Throwable {
        dadosPessoaisPage.inserirNomeCompleto(nome);
        dadosPessoaisPage.inserirDataNascimento(data);
        dadosPessoaisPage.inserirOcupacao(ocupacao);
    }

    @Quando("^prossigo para os canais de contato$")
    public void prossigoParaOsCanaisDeContato() throws Throwable {
        dadosPessoaisPage.clicarBotaoProximo();
    }

    @Quando("^valido se o \"([^\"]*)\" no cabecalho esteja correto$")
    public void validoSeONoCabecalhoEstejaCorreto(String nome) throws Throwable {
        Assert.assertEquals(documentoUtil.firstWord(nome), contatosPage.obterNome());
    }

    @Quando("^prossigo para encontrar meu seguro$")
    public void prossigoParaEncontrarMeuSeguro() throws Throwable {
        contatosPage.clicarBotaoEncontrarMeuSeguro();
    }

    @Então("^valido se a mensagem de alerta é apresentada ao usuário$")
    public void validoSeAMensagemDeAlertaÉApresentadaAoUsuário() throws Throwable {
        Assert.assertEquals(AUTORIZACAO_IMPORTANTE_PARA_TE_AJUDAR_ENCONTRAR_SEGURO, contatosPage.obterMensagem());
    }

    @After
    public void finaliza(){
        quitDriver();
    }

}
