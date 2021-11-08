package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static utils.ConfiguracaoAmbiente.getDriver;

public class Esperas {

    private static Wait<WebDriver> getWait(){
        ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
        return new WebDriverWait(getDriver(),45)
                .withTimeout(Duration.ofSeconds(45))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
    }

    public void esperaElementoClicavel(By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void esperaElementoVisivel(By locator){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void esperaFixa(long segundos){

        try {
            long milisegundos = TimeUnit.SECONDS.toMillis(segundos);
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            throw new RuntimeException("Erro ao realizar espera",e);
        }
    }












}
