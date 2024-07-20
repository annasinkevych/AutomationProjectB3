package io.loop.homework.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

public class task2 extends TestBase {

    /*
     task2
=============

    1. login as an advisor
    2. go to users
    3. validate that full name for alex.de.souza@gmail.com is Alex De Souza - we did in class
    4. validate that user name for alex.de.souza@gmail.com is alexdesouze
    5. validate that phone number for alex.de.souza@gmail.com is +994512060042
    6. validate that role for alex.de.souza@gmail.com is client
    7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
     */

    String userEmail = "alex.de.souza@gmail.com";
    String expectedFullName = "Alex De Souza";
    String expectedUserName = "alexdesouze";
    String expectedPhoneNumber = "+994512060042";
    String expectedRole = "Client";
    String expectedAdvisor = "Batch1 Group1";

    @Test
    public void loginAdvisor() throws InterruptedException {

        //1. login as an advisor
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        // 2. go to users
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userButton = driver.findElement(By.xpath("//span[contains(.,'Users')]"));
        userButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //3. validate that full name for alex.de.souza@gmail.com is Alex De Souza - we did in class
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver,userEmail, "full name" );
        assertion(actualFullName, expectedFullName, "Full name");

        //4. validate that user name for alex.de.souza@gmail.com is alexdesouze
        String actualUserName = DocuportWebTableUtils.returnAnyField(driver, userEmail, "username");
        assertion(actualUserName, expectedUserName, "username");

        //5. validate that phone number for alex.de.souza@gmail.com is +994512060042
        String actualPhoneNumber = DocuportWebTableUtils.returnAnyField(driver, userEmail, "phone number");
        assertion(actualPhoneNumber, expectedPhoneNumber, "phone number");

        //6. validate that role for alex.de.souza@gmail.com is client
        String actualRole = DocuportWebTableUtils.returnAnyField(driver, userEmail, "role");
        assertion(actualRole, expectedRole, "role");

        //7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
        String actualAdvisor = DocuportWebTableUtils.returnAnyField(driver, userEmail, "advisor");
        assertion(actualAdvisor, expectedAdvisor, "advisor");
    }

    public void assertion(String actual, String expected, String field) {
        String message = "Actual " +field + ": " + actual + " DOES NOT MATCH EXPECTED " + field + ": " + expected;
        assertEquals(actual, expected, message);
    }
}
