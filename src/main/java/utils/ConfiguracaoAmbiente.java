package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ConfiguracaoAmbiente {

    protected static WebDriver driver;
    private String path = System.getProperty("user.dir");

    protected ConfiguracaoAmbiente() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "."+File.separator+"drivers"+File.separator+"chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public static void iniciaUrl(String url) {
        getDriver().get(url);

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    String rootOrigem = null;
    String rootDestino = null;
    LocalDateTime agora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");

    public void screenShot(String fileName) throws IOException {

        rootOrigem = this.path + "\\screenshot\\";
        rootDestino = rootOrigem + fileName + "_" + agora.format(formato) + ".jpg";
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo,new File(rootDestino));
        System.out.println("Caminho do print: " + rootOrigem);
    }

}
