package com.holin.steps;

import com.holin.Initalization.InitializationClass;
import com.holin.pages.BasePage;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class FirstPage extends BasePage {

    @When("Пользователь выбирает меню с параметром String \"(.+)\"")
    @Step("Пользователь выбирает меню с параметром String {name}")
    public void clickOnKitRow(String name) {
        element = InitializationClass.getDriver().findElement(By.xpath("//span [contains(text(), '" + name + "')]"));
        element.click();
    }

    @When("Пользователь выбирает меню с параметром String \"(.+)\"")
    @Step ("Выбираем подпункт по указанному тексту {text}")
    public void clickOnSubMenu(String text) {
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//ul [@class= 'lg-menu__sub-list']//a [contains(text(), '" + text + "')]"))));
        element = InitializationClass.getDriver().findElement(By.xpath("//ul [@class= 'lg-menu__sub-list']//a [contains(text(), '" + text + "')]"));
        element.click();
    }
}
