package io.loop.homework.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateEstimatedArrivalDrD {
    /*
    1. go to https://www.etsy.com/
    2. search for rings
    3. validate that Estimated Arrival shows any time
    3. click Estimated Arrival dropdown
    4. click Select custom date
    5. choose July 30 from dropdown
    6. validate Estimated Arrival shows July 30
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // Add the argument for incognito mode
        options.addArguments("--incognito");

        // Initialize ChromeDriver with the ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void validateEstimatedArrivalDropDown() {

        //locate the search box
        WebElement searchBoxCssSelector = driver.findElement(By.cssSelector("input[id='global-enhancements-search-query']"));

        //type in search query: rings
        String textToSearch = "rings";
        searchBoxCssSelector.sendKeys(textToSearch + Keys.ENTER);


        //Locate Estimate Arrival Element
        WebElement etaXpath = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']/span/span"));
        System.out.println(etaXpath.getText());


    }
}
