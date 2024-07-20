package io.loop.homework.day7;

import com.google.common.util.concurrent.FakeTimeLimiter;
import io.loop.test.base.TestBase;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import io.loop.test.utilities.PageElementUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static io.loop.test.utilities.PageElementUtils.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ExtraTask {

    /*
    extra task
     =============

     automate till payment
     https://app.docuport.app/company-formation/resident

     */


    @Test
    public void automateTillPayment() throws InterruptedException {


        //returns an instance of WebDriver implemented as a singleton pattern
        Driver.getDriver().get(ConfigurationReader.getProperties("docuport.registration.form"));

        //validate LLC Registration is displayed
        WebElement llcReg = Driver.getDriver().findElement(By.xpath("//h1[.=' LLC Registration '] "));
        assertTrue(llcReg.isDisplayed());

        //click on radio buttons
        clickOnButton("Corporation",1);
        clickOnButton("Washington D.C.",1);

        //enter text into text boxes
        enterTextIntoTextFields("Legal Company Name  *", "Doggy Daycare",1);
        enterTextIntoTextFields("DBA (Doing Business As)", "Chelse Labr Corp",1);
        enterTextIntoTextFields("First name *", "Anna",1);
        enterTextIntoTextFields("Last name *", "Nicol",1);
        enterTextIntoTextFields("Email address *", "DoggyDaycare@gmail.com",1);
        enterTextIntoTextFields("Phone number *", "305-564-23-54",1);
        enterTextIntoTextFields("Fax", "305-564-23-58",1);
        sendKeysToDropDownContainer("Industry *", "Pet Services");
        clickOnButton("Next",1);
        Thread.sleep(1000);

        //validate we are on the 2nd page
        progressBarValidation(" Registered Agent and Business Address ");

        //click on radio button on page 2 of the form
        clickOnButton("Individual",1);

        //enter text into text boxes on page 2
        enterTextIntoTextFields("First name *", "Anna",2);
        enterTextIntoTextFields("Last name *", "Nicol",2);
        enterTextIntoTextFields("Address line 1 *", "7601 Est Treasure Dr",0);
        enterTextIntoTextFields("City *", "Miami Beach",0);
        sendKeysToDropDownContainer("Jurisdiction *" ,"Washington D.C.");
        enterTextIntoTextFields("Zip code *", "31141",0);
        enterTextIntoTextFields("Email address", "DoggyDaycare@gmail.com",0);
        enterTextIntoTextFields("Phone number *", "305-564-23-54",2);

        //click on radio button on page 2 of the form
        clickOnButton("Use Registered Agent Address",1);

        clickOnButton("Next",2);

        //validate we are on the 3rd page
        progressBarValidation(" Management Structure ");

        clickOnButton("Manager managed", 1);
        sendKeysToDropDownContainer("Title *","President");
        enterTextIntoTextFields("First name *", "Anna",3);
        enterTextIntoTextFields("Last name *", "Nicol",3);
        enterTextIntoTextFields("Share Ownership (%) *", "51",0);
        enterTextIntoTextFields("SSN of an Organizing Member *", "786546788",0);
        enterTextIntoTextFields("First name *", "Anna",4);
        enterTextIntoTextFields("Last name *", "Nicol",4);
        clickOnButton(" Go to payment ", 1);





    }


}
