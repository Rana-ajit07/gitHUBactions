package com.thetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userName = By.xpath("//input[@id='username']");
    By passWord = By.id("password");
    By submit = By.xpath("//button[@type='submit']");
    By result = By.id("success");

    private void enterUsername(String name)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(userName));
        driver.findElement(userName).sendKeys(name);
    }
    private void enterPassword(String password)
    {
        driver.findElement(passWord).sendKeys(password);
    }
    private void clickAction()
    {
        driver.findElement(submit).click();

    }
    public void Login(String name, String password)
    {
        enterUsername(name);
        enterPassword(password);
        clickAction();
    }
    public String msg()
    {
        return driver.findElement(result).getText();
    }
    public Boolean success()
    {
        return driver.findElement(result).isDisplayed();
    }
}
