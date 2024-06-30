package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_alerts extends TestBase {

    /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
     */

    @Test
    public void informationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();
        Assert.assertEquals(actual, expected, "Actual does not match the expected");
    }

    @Test
    public void confirmationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJsConfirm.click();

        driver.switchTo().alert().accept(); //will click ok and accept the message
        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConfirmationAlert.getText();
        Assert.assertEquals(actual, expected, "Actual does not match the expected");

        clickForJsConfirm.click();
        driver.switchTo().alert().dismiss();
        expected = "You clicked: Cancel";
        actual  = successMessageForConfirmationAlert.getText();
        Assert.assertEquals(actual, expected, "Actual does not match the expected");
    }

    @Test
    public void promptAlert(){

        //Navigate to the web page:
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

        //Locate and click the JS Prompt button:
        //These lines locate the button with the text "Click for JS Prompt" using XPath and simulate a click on it.
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();

        //Define the text to be entered into the prompt:
        String text = "Loopcamp";

        //One way to run this test
//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();

        //another way to run the test using Alert
        //Handle the JavaScript prompt (second way): switches to the alert, enters the text, and then accepts the alert, but using an Alert object.
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        //Verify the success message: These lines locate the element that displays the result of the prompt input, get its text, and verify that it matches the expected result using an assertion.
        WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessagePromptAlert.getText();
        String expected = "You entered: " + text;
        Assert.assertEquals(actual, expected, "Actual does not match the expected");


        //Handle the JavaScript prompt again and dismiss: These lines click the JS Prompt button again, enter the text, and then dismiss the alert. It then verifies that the result message shows "You entered: null", which is expected if the alert is dismissed without entering any value.
        clickJSPrompt.click();
        alert = driver.switchTo().alert(); // Reassign alert object
        alert.sendKeys(text);
        alert.dismiss();
        actual = successMessagePromptAlert.getText();
        expected = "You entered: " + null;
        Assert.assertEquals(actual, expected, "Does not match");
    }

}
