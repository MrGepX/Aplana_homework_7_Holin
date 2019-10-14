package com.holin.steps;

import com.holin.pages.BasePage;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FormPage extends BasePage {
        @FindBy(xpath = "//span [@data-test-id='monthlyPayment']")
        WebElement monthPay;

        @FindBy(xpath = "//input [@id='estateCost']")
        WebElement costOfEstate;

        @FindBy (xpath = "//input [@id='initialFee']")
        WebElement initialFee;

        @FindBy (xpath = "//input [@id='creditTerm']")
        WebElement timeOfPain;

        @FindBy (xpath = "//div [text() = 'Есть зарплатная карта Сбербанка']/following-sibling::div")
        WebElement isCardinUseCheck;

        @FindBy (xpath = "//div [text() = 'Есть возможность подтвердить доход справкой']")
        WebElement confirmWayCheck;

        @FindBy(xpath = "//h2[contains(text(),'Рассчитайте ипотеку')]")
        private WebElement formTitle;

        @FindBy (xpath = "//span [contains (@data-test-id, 'amountOfCredit')]")
        WebElement sumOfCredit;

        @FindBy (xpath = "//span [contains (@data-test-id, 'monthlyPayment')]")
        WebElement monthPayout;

        @FindBy (xpath = "//span [contains (@data-test-id, 'requiredIncome')]")
        WebElement minimumIncome;

        @FindBy (xpath = "//span [contains (@data-test-id, 'rate')]")
        WebElement rate;

        public void getCurrentPay () {
                currentPrice = monthPay.getText();
        }

        @When("Пользователь заполняет поле стоимости недвижимости с параметром int \"(.*)\"")
        @Step("Пользователь заполняет поле стоимости недвижимости {cost}")
        public void fillCostOfEstate(int cost) {
            driver.switchTo().frame(0);
            waitForElement(costOfEstate);
            getCurrentPay();
            costOfEstate.clear();
            costOfEstate.sendKeys(String.valueOf(cost));
            waitForChanges(monthPay, currentPrice);
            driver.switchTo().defaultContent();
        }

        @When("Пользователь заполняет поле первоначального взноса с параметром int \"(.*)\"")
        @Step("Пользователь заполняет поле первоначального взноса {cost}")
        public void fillInitialFee(int cost) {
            driver.switchTo().frame(0);
            waitForElement(initialFee);
            getCurrentPay();
            initialFee.clear();
            initialFee.sendKeys(String.valueOf(cost));
            waitForChanges(monthPay, currentPrice);
            driver.switchTo().defaultContent();
        }


        @When("Пользователь устанавливает срок кредита с параметром int \"(.*)\"")
        @Step ("Пользователь устанавливает срок кредита с параметром int {cost}")
        public void fillTimeOfPain(int cost) {
            driver.switchTo().frame(0);
            waitForElement(timeOfPain);
            getCurrentPay();
            timeOfPain.clear();
            timeOfPain.sendKeys(String.valueOf(cost));
            waitForChanges(monthPay, currentPrice);
            driver.switchTo().defaultContent();
        }

        @When("Пользователь снимает галочку о зарплатной карте")
        @Step ("Пользователь снимает галочку о зарплатной карте")
        public void turnCardUsing() {
            driver.switchTo().frame(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", costOfEstate);
            waitForElement(isCardinUseCheck);
            wait.until(ExpectedConditions.elementToBeClickable(isCardinUseCheck));
            getCurrentPay();
            isCardinUseCheck.click();
            waitForChanges(monthPay, currentPrice);
            driver.switchTo().defaultContent();
        }

        @When("Пользователь проверяет галочку о возможности подтверждения справкой")
        @Step ("Пользователь проверяет галочку о возможности подтверждения справкой")
        public void confirmWayCheck() {
            driver.switchTo().frame(0);
            waitForElement(confirmWayCheck);
            driver.switchTo().defaultContent();
        }

        @When("Пользователь устанавливает галочку о молодой семье")
        @Step("Пользователь устанавливает галочку о молодой семье")
        public void setYoungFamily() {
            driver.switchTo().frame(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", costOfEstate);
            WebElement youngFamilyCheck = driver.findElement(By.xpath("//div [text() = 'Молодая семья']/following-sibling::div//label"));
            wait.until(ExpectedConditions.elementToBeClickable(youngFamilyCheck));
            youngFamilyCheck.click();
            waitForChanges(monthPay, currentPrice);
            driver.switchTo().defaultContent();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", formTitle);
        }

        @When("Проверка значения поля Сумма кредита int \"(.*)\"")
        @Step("Проверка значения поля Сумма кредита - {sum}")
        public void checkDataCreditSumCheck(int sum) {
            driver.switchTo().frame(0);
            waitForElement(sumOfCredit);
            Assert.assertEquals(formatString(sumOfCredit.getText()), sum);
            driver.switchTo().defaultContent();
        }


        @When("Проверка значения поля Ежемесячного платежа int \"(.*)\"")
        @Step("Проверка значения поля Ежемесячного платежа - {sum}")
        public void checkDataMonthPayCheck(int sum) {
            driver.switchTo().frame(0);
            Assert.assertTrue(formatString(monthPayout.getText()) == sum);
            driver.switchTo().defaultContent();
        }

        @When("Проверка значения поля Необходимый доход int \"(.*)\"")
        @Step("Проверка значения поля Необходимый доход - {sum}")
        @Attachment (type = "image/png", value = "Screenshot")
        public void minimumIncomeCheck(int sum) {
            driver.switchTo().frame(0);
            Assert.assertTrue(formatString(minimumIncome.getText()) == sum);
            driver.switchTo().defaultContent();
        }

        @When("Проверка значения поля Процент double \"(.*)\"")
        @Step("Проверка значения поля Процент - {sum}")
        public void minimumIncomeCheck(double sum) {
            driver.switchTo().frame(0);
            Assert.assertTrue(formatPercentString(rate.getText()) == sum);
            driver.switchTo().defaultContent();
        }
}

