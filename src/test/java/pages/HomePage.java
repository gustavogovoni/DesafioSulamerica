package pages;

import org.openqa.selenium.By;
import utils.SeleniumFunctions;

public class HomePage{

    SeleniumFunctions seleniumFunctions = new SeleniumFunctions();
    private By btnQueroSimular = By.xpath("//div[@class='MuiBox-root jss22']/button");


    public void clicarBotaoQueroSimular(){
        seleniumFunctions.clicarBotao(btnQueroSimular);
    }

}
