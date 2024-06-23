package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_testNG_with_selenium {

    WebDriver driver;
    String expected;
    String actual;

    //set up chrome and create driver
    //go to google.com
    //Assert; title is "Google"

    @BeforeMethod
    public void setUp(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void googleTitle(){
        driver.get("https://google.com");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Actual title: " + actual + " DOES NOT MATCH Expected: " + expected);
    }

    @Test
    public void docuportTitle(){
        driver.get("https://beta.docuport.app");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected, "Actual title : " + actual + " DOES NOT MATCH Expected: " + expected);
        //or
        Assert.assertTrue(actual.contains(expected), "Actual title : " + actual + " DOES NOT MATCH Expected: " + expected);
    }
}
