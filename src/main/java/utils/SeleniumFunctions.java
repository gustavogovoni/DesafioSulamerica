package utils;

import helper.Esperas;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SeleniumFunctions extends ConfiguracaoAmbiente {

    Esperas esperas = new Esperas();

    public void clicarBotao(By locator) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        getDriver().findElement(locator).click();
    }

    public void clicarSubmit(By locator) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        getDriver().findElement(locator).submit();
    }


    public void clicarBotaoActions(By locator) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        Actions act = new Actions(getDriver());
        act.moveToElement(getDriver().findElement(locator)).click().perform();
    }


    public void clicarBotaoJS(By locator) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        JavascriptExecutor executor =  (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click()",locator);

    }

    public void scrollObj(By locator) {
        try {
            WebElement elemento = getDriver().findElement(locator);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(elemento).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String obterTexto(By locator) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        return getDriver().findElement(locator).getText();
    }

    public void escreverTexto(By locator, String texto) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        getDriver().findElement(locator).sendKeys(texto);
    }

    public void selecionarCombo(By locator, String option) {
        esperas.esperaElementoVisivel(locator);
        esperas.esperaElementoClicavel(locator);
        WebElement element = getDriver().findElement(locator);
        Select combo = new Select(element);
        combo.selectByVisibleText(option);

    }

    public void clicarSetaPraBaixo() throws AWTException {
        Robot robot = new Robot();
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_DOWN);

    }

    public void clicarEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public void clicarTab() throws AWTException {
        Robot robot = new Robot();
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
    }


}
