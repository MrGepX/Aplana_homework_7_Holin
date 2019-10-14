package com.holin.Initalization;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class InitializationClass {
    private static WebDriver driver;
    private static Wait<WebDriver> wait;
    private static InitalizationProperty initPropertyController;
    public static String currentBrowser;

    public static WebDriver getDriver() {
        return driver;
    }

    public static Wait<WebDriver> getWait() {
        return wait;
    }

    @Before
    public static void init() {
        initPropertyController = InitalizationProperty.getInstance();
        currentBrowser = System.getProperty("browserName", "сhrome");
        System.out.println(currentBrowser);
        switch (currentBrowser) {
            case "chrome" : System.setProperty(
                    initPropertyController.getInitProperty("chromeDriverName"),
                    initPropertyController.getInitProperty("chromeDriverPath"));
                    driver = new ChromeDriver();
                    break;
            case "firefox" : System.setProperty(
                    initPropertyController.getInitProperty("firefoxDriverName"),
                    initPropertyController.getInitProperty("firefoxDriverPath"));
                    driver = new FirefoxDriver();
                    break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(InitalizationProperty.getInitProperty("waitTimeout")),
                TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(
                Integer.parseInt(InitalizationProperty.getInitProperty("pageLoadTimeOut")),
                TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10, 2000);
    }


}
