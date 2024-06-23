package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T00_xpath_getText {

    public static void main(String[] args) throws InterruptedException {
        /*
        1. open Chrome
        2. go to docuport
        3. click forgot password
        4. validate url contains reset password
        5. validate - Enter the email address associated with your account
        6. enter forgotpasswordgr1@gmail.com
        7. validate send button is displayed
        8. validate cancel button is displayed
        9. click send button
        10. validate - We've sent you an email with a link to reset password. Please check your email
         */

        //1. open Chrome
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. go to docuport
        driver.get("https://beta.docuport.app");

        // 3. click forgot password

        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));

        forgotPassword.click();


        //4.validate url contains reset password
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);

        if(actualURL.contains(DocuportConstants.RESET_PASSWORD))
        {
            System.out.println("The Actual URL: "+actualURL + " contains expected URL: " + DocuportConstants.RESET_PASSWORD +  " => TEST PASS");
        }
        else{
            System.out.println("Actual URL doesn't match the expected one --> "+ DocuportConstants.RESET_PASSWORD +  " => TEST FAIL");
        }

        //5. validate - Enter the email address associated with your account
        WebElement validateMessage = driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));

        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("TEST PASS");
        }
        else
        {
            System.out.println("TEST FAIL");
        }

        //6. enter forgotpasswordgr1@gmail.com
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));

        //sendkeys() is a method in Selenium that allows QAs to type content automatically into an editable field while executing any tests for forms. These fields are web elements that can be identified using locators like element id, name, class name, etc.
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        //7. validate send button is displayed
        //8. validate cancel button is displayed

        if(cancelButton.isDisplayed()){
            System.out.println("Test pass - cancel is displayed");
        } else {
            System.out.println("Test fail - cancel is not displayed");
        }

        if(sendButton.isDisplayed()){
            System.out.println("Test pass - send is displayed");
        } else {
            System.out.println("Test fail - send is not displayed");
        }

        //9. click send button
        sendButton.click();

        //10. validate - We've sent you an email with a link to reset password. Please check your email

        Thread.sleep(10000);
        WebElement message = driver.findElement(By.xpath("//span[@class='body-1')]"));
        Thread.sleep(5000);
        String actualMessage = message.getText();

        System.out.println(actualMessage);

        try{
            System.out.println(message.getText());
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore");
        }

        //closes the google chrome
        driver.close(); //Process finished with exit code 0

        driver.quit();//kills the webdriver



    }
}
