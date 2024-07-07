package io.loop.test.base;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;


    @BeforeMethod
    protected void setUp(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    protected void tearDown(){
        driver.close();//kills the driver
    }
}
