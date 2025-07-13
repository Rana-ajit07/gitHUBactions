package com.thetesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ctossbrowser {
    private WebDriver driver;


    @Test(dataProvider ="getBrowserData")
    public void getTitle(String browser)
    {
        initializeDriver(browser);
        driver.get("https://www.geeksforgeeks.org/");
        Assert.assertTrue(driver.getTitle().contains("Geeks"),"Does not contain Geeks");

    }

    public void initializeDriver(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver= new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver= new EdgeDriver();

        }
        else
            throw new IllegalArgumentException("Unsupported Browser: "+ browser);
    }


    @DataProvider
    public Object[][] getBrowserData() {
        return new Object[][]{
                {"chrome"},
                {"edge"}
        };
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
