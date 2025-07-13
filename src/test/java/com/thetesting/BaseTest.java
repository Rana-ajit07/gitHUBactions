package com.thetesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void Setup()
    {
        driver= new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
