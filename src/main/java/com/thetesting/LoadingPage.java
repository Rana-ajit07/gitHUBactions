package com.thetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingPage extends BasePage{
    public LoadingPage(WebDriver driver) {
        super(driver);
    }

    private final By award = By.id("award");
    private final By Landscape = By.id("landscape");

    public String AwardVisibility()
    {
       return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(award)).getDomAttribute("alt");

    }

    public String LandscapeVisibility()
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(Landscape)).getDomAttribute("alt");

    }
}
