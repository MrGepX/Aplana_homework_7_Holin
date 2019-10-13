package com.holin.pages;

import com.holin.Initalization.InitializationClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BasePage {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;
    public WebElement element;
    public static String currentPrice;

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
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                return !element.getText().equals(waitingString);
            }
        });
    }

    public int formatString(String string) {
        return Integer.parseInt(string.replaceAll("[^0-9]", ""));
    }

    public double formatPercentString(String string) {
        return Double.parseDouble(string.replaceAll("[^0-9,]", "").replaceAll(",","."));
    }
}
