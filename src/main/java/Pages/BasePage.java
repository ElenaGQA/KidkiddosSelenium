package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }


    protected void clickElementByXpath(String xpath) {
//        findElementByXpath(xpath).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", button);
        button = wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
//        findElementByXpath(xpath).sendKeys(text);
        WebElement el = webDriver.findElement(By.xpath(xpath));
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    protected boolean elementExistsByXpath(String xpath) {
        try {
//            findElementByXpath(xpath); in  this case the wait for the element to be found will be 5 sec as set in driver;
            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch(Exception err) {
            return false;
        }
    }

    protected boolean isTextVisibleByXpath(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element.getText().contains(text);
    }

    protected WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected String getCurrentPageUrl(){
       return webDriver.getCurrentUrl();
    }


    public void takeScreenshots(String name) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshots/" + name + ".jpeg"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
