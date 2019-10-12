package com.holin.pages;

import com.holin.Initalization.InitializationClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;


public class BasePage {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;
    public WebElement element;
    public static int currentPrice;

    public BasePage () {
        driver = InitializationClass.getDriver();
        wait = InitializationClass.getWait();
        PageFactory.initElements(driver,this);
    }

    public WebElement waitForElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForChanges (WebElement element, String waitingString) {
        wait.until(new Function<WebDriver, Object>() {
            @Override
            public Boolean apply (WebDriver webDriver) {
                return !element.getText().replaceAll("\\s+","").equals(waitingString);
            }
        });
    }
}
