package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    task 3
    =============
    1. navigate to docuport application
    2. validate placeholders for user name and password
    3. without sending username and password click login button
    4. validate username and password error messages

 */
public class PracticeTask3 {
    public static void main(String[] args) {
        //create a WebDriver object
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        //maximize
        driver.manage().window().maximize();

        //1. navigate to docuport application
        driver.get("https://beta.docuport.app/");

        //2. validate placeholders for username and password
        WebElement usernamePlaceholderXpath = driver.findElement(By.xpath("//label[.='Username or email']"));
        String actualUsernamePlaceholder = usernamePlaceholderXpath.getText();
        if(actualUsernamePlaceholder.equals(DocuportConstants.USERNAME_PLACEHOLDER)) {
            System.out.println("Actual placeholder: " + actualUsernamePlaceholder + " MATCHES EXPECTED: " + DocuportConstants.USERNAME_PLACEHOLDER + " => TEST PASSED");
        }
        else{
            System.out.println("Actual placeholder: " + actualUsernamePlaceholder + " DOESNOT MATCH EXPECTED: " + DocuportConstants.USERNAME_PLACEHOLDER + " => TEST FAILED");
        }

        //Locate login button
        WebElement loginButtonXpath = driver.findElement(By.xpath("//button[@type='submit']"));
        //3. without sending username and password click login button
        loginButtonXpath.click();

        //4. validate username and password error messages
        WebElement usernameErrorMessageXpath = driver.findElement(By.xpath("//div[.='Please enter your username or email address']"));
        String actualUsernameErrorMessage = usernameErrorMessageXpath.getText();
        WebElement passwordErrorMessageXpath = driver.findElement(By.xpath("//div[.='Please enter your password']"));
        String actualPasswordErrorMessage = passwordErrorMessageXpath.getText();
        if(actualUsernameErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_USERNAME)) {
            System.out.println("Error Message for Empty Username: " + actualUsernameErrorMessage + " MATCHES EXPECTED: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_USERNAME + " => TEST PASSED");
        }
        else
            System.out.println("=> TEST FAILED");

        if(actualPasswordErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
            System.out.println("Error Message for Empty Password: " + actualPasswordErrorMessage + " MATCHES EXPECTED: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + " => TEST PASSED");
        }
        else
        {
            System.out.println("Error Message for Empty Password: " + actualPasswordErrorMessage + " DOES NOT MATCH EXPECTED: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + " => TEST FAILED");
        }

        driver.quit();
    }
}
