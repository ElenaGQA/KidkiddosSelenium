package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver webDriver;
    WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver){
        this. webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    }
}
