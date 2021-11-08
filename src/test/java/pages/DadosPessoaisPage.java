package pages;

import helper.Esperas;
import org.openqa.selenium.By;
import utils.SeleniumFunctions;

import java.awt.*;

public class DadosPessoaisPage {

    SeleniumFunctions seleniumFunctions = new SeleniumFunctions();
    Esperas esperas = new Esperas();

    private By txtNome = By.id("id-name");
    private By dateNascimento = By.name("birthday");
    private By txtOcupacao = By.id("professionalActivityId");
    private By btnProximo = By.cssSelector("button[class='MuiButtonBase-root MuiButton-root jss106 MuiButton-contained MuiButton-containedPrimary']");

    private By slcOcupacao(String ocupacao){
        return By.xpath(String.format("//li[.='%1$s']",ocupacao));
    }

    public void inserirNomeCompleto(String nome){
        seleniumFunctions.escreverTexto(txtNome,nome);
    }

    public void inserirDataNascimento(String nascimento){
        seleniumFunctions.escreverTexto(dateNascimento,nascimento);
    }

    public void inserirOcupacao(String ocupacao) throws AWTException {
        seleniumFunctions.escreverTexto(txtOcupacao,ocupacao);
        esperas.esperaElementoVisivel(slcOcupacao(ocupacao));
        seleniumFunctions.clicarBotao(slcOcupacao(ocupacao));
    }

    public void clicarBotaoProximo(){
        seleniumFunctions.clicarBotao(btnProximo);
    }





}
