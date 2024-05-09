package utils;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static pages.BasePage.wait;

public class BrowserUtils {


    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void navigateTo_URL(String url) {
        DriverManager.getDriver().get(url);
    }

    public static void click(WebElement element) {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void enterText(WebElement element, String keyword) {
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keyword);
    }

    public static void switchToNewWindow(String windowHandle){
        Set<String> windowHandleList=DriverManager.getDriver().getWindowHandles();

        for (String each:windowHandleList){
            if(each!=windowHandle){
                DriverManager.getDriver().switchTo().window(each);
            }
        }
    }
    public static void jsScrollClick(WebElement webElement) {  //kaydir ve tikla
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
        }
    }
}
