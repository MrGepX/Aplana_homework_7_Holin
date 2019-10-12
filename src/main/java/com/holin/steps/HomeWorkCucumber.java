package com.holin.steps;

import com.holin.Initalization.InitalizationProperty;
import com.holin.Initalization.InitializationClass;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class HomeWorkCucumber {
    WebDriver driver;
    Wait<WebDriver> wait;
    FirstPage firstPage;


    @When("Пользователь загружает главную страницу")
    public void Homework() {
        InitializationClass.init(); //TODO Разобраться, почему инициализация не срабатывает
        WebDriver driver = InitializationClass.getDriver();
        Wait<WebDriver> wait = InitializationClass.getWait();
        driver.navigate().to(InitalizationProperty.getInitProperty("mainPageURL"));
    }


}
