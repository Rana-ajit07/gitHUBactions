package com.thetesting;

import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static java.awt.SystemColor.text;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginTest extends BaseTest{


    @Test
    public void PositiveLogin()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login("user","user");
        System.out.println(loginPage.success());
       Assert.assertTrue(loginPage.success());

    }

    @Test
    public void visibilityTest()
    {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        LoadingPage loadingPage = new LoadingPage(driver);
        Assert.assertEquals(loadingPage.AwardVisibility(),"award");
        Assert.assertEquals(loadingPage.LandscapeVisibility(),"landscape");
    }

    @Test
    public void shadowDom()
    {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        WebElement content = driver.findElement(By.id("content"));
        SearchContext root = content.getShadowRoot();

            WebElement text1 = root.findElement(By.cssSelector("p"));
            String writenText = text1.getText();
            System.out.println(writenText);

       // WebElement text = root.findElement(By.cssSelector("p"));

    }
    @Test
    public void screenShot() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("screenshot.png");
        Files.move(screenshot.toPath(),destination,REPLACE_EXISTING);
        Assert.assertTrue(Files.exists(destination),"Screenshot does not exist");

    }
    @Test
    public void elementscreenshot() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.manage().window().maximize();
        WebElement reference = driver.findElement(By.xpath("//*[text()='Chapter 3. WebDriver Fundamentals']"));
        WebElement target = driver.findElement(with(By.cssSelector(".card")).near(reference));
        File screenshot = target.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("Elementscreenshot.png");
        Files.move(screenshot.toPath(),destination,REPLACE_EXISTING);
        Assert.assertTrue(Files.exists(destination),"Screenshot does not exist");
    }
    @Test
    public void screen2() throws IOException {
        driver.get("https://courses.thetestingacademy.com/login");
        driver.manage().window().maximize();
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File target = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("newScreenshot.png");
        Files.move(target.toPath(),destination,REPLACE_EXISTING);
    }
    @Test
    public void screen02() throws IOException {
        driver.get("https://courses.thetestingacademy.com/login");
        driver.manage().window().maximize();
        WebElement t1 = driver.findElement(By.id("header5"));
        String target = t1.getScreenshotAs(OutputType.BASE64);
        System.out.println("data:image/png;base64,"+target);

    }
}
