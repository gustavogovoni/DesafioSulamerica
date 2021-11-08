package pages;

import org.openqa.selenium.By;
import utils.DocumentoUtil;
import utils.SeleniumFunctions;

public class ContatosPage {

    SeleniumFunctions seleniumFunctions = new SeleniumFunctions();

    private By txtFrase = By.cssSelector("p[class='MuiTypography-root jss97 MuiTypography-subtitle1 jss98 MuiTypography-paragraph']");
    private By btnEncontrarSeguro = By.xpath("//button[@type='submit']");
    private By txtAlerta = By.xpath("//p[contains(text(),'Autorizo')]/../../../div/p");

    public String obterNome(){
         String frase = seleniumFunctions.obterTexto(txtFrase);
         String palavra=  DocumentoUtil.firstWord(frase);
        return DocumentoUtil.removerPontuacao(palavra);
    }

    public void clicarBotaoEncontrarMeuSeguro(){
        seleniumFunctions.clicarSubmit(btnEncontrarSeguro);
    }

    public String obterMensagem(){
        return seleniumFunctions.obterTexto(txtAlerta);
    }



}
