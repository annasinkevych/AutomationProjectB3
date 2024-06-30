package io.loop.homework.day5;

import com.sun.source.tree.AssertTree;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidateDropdown {
    /*

    1. go to http://the-internet.herokuapp.com/dropdown
    2. validate "Please select an option" is selected by default
    3. Choose option 1 and validate that it is selected
    4. Choose option 2 and validate that it is selected
    5. Validate dropdown name is "Dropdown List

     */

    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void dropDownTest(){

        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());

        //locate and create dropdown object
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //assign actual with the text from the located default dropdown option text
        actual = dropdown.getFirstSelectedOption().getText();

        //validate "Please select an option" is selected by default
        Assert.assertEquals(actual, expected, "Actual " + actual + " does not match expected " + expected + "=> TEST FAILED");

        //select option 1
        dropdown.selectByValue("1");

        //validate "option 1" is selected
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");

        //select option 2
        dropdown.selectByVisibleText("Option 2");

        //validate "option 1" is selected
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2");

        //Validate dropdown name is "Dropdown List
        WebElement dropDownXPath = driver.findElement(By.xpath("//div[@class='example']/h3"));

        if(dropDownXPath.getText().equals("Dropdown List")){
            System.out.println("Actual dropdown text: " + dropDownXPath.getText() + " matches expected: \"Dropdown List\" => TEST PASSED");
        }
        else
        {
            System.out.println("Actual dropdown text: " + dropDownXPath.getText() + " DOES NOT match expected: \"Dropdown List\" => TEST FAILED");
        }
    }



}
