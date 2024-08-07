package io.loop.test.base;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static WebDriver driver;


    @BeforeMethod
    protected void setUp(){
        driver = WebDriverUtil.getDriver(ConfigurationReader.getProperties("browser"));
        driver.manage().window().maximize();
    }


    @AfterMethod
    protected void tearDown(){
//        driver.close();//closes the current window  the driver
        driver.quit();//kills the driver iself
    }
}

