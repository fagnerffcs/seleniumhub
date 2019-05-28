package br.com.fagnerffcs.seleniumhub.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class LoginPage {

    private static final String HOME_PAGE = "https://pje.trf5.jus.br/pje/login.seam";
    private static final String SELENIUM_HUB = "http://localhost:4444/wd/hub";
    private static final String FILE_PATH = "C:\\Users\\fhigh\\Desktop\\chromedriver.exe";

    private WebDriver driver;

    @GetMapping(value = "/loginRemoteDriverFirefox")
    public boolean loginRemoteFirefox() throws MalformedURLException {
        URL seleniumHubUrl = new URL(SELENIUM_HUB);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.WIN10);
        this.driver = new RemoteWebDriver(seleniumHubUrl, capabilities);
        boolean retorno = login(this.driver);
        this.driver.quit();
        return retorno;
    }

    @GetMapping(value = "/loginLocalDriverChrome")
    public boolean loginLocalChrome() throws MalformedURLException {
        boolean retorno = false;
        try {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", FILE_PATH);
            this.driver = new ChromeDriver(options);
            retorno = login(this.driver);
        }catch(Exception e) {

        } finally {
            this.driver.quit();
        }
        return retorno;
    }

    public boolean login(WebDriver driver) throws MalformedURLException {
        driver.get(HOME_PAGE);
        WebElement txtNomeParte = driver.findElement(By.id("mpModoOperacaoHeader"));
        return txtNomeParte.isDisplayed();
    }

}
