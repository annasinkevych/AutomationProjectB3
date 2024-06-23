package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {


        //create a webDriver
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        //maximize
        driver.manage().window().maximize();

        //go to docuport
        driver.get("https://beta.docuport.app");

        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT);

        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();

        //locate the error message by className
        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));


        //getText() method returns the text of the element between open and closing tags
        String actualErrorMessage = errorMessage.getText();
        //System.out.println(message);

        //verify error message
        if(actualErrorMessage.equals(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD))
        {
            System.out.println("Expected error message " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + " MATCHES actual error message" + actualErrorMessage + "=> TEST PASS");
        }
        else
        {
            System.out.println("Expected error message " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + " DOESNOT MATCH actual error message" + actualErrorMessage + "=> TEST FAIL");
        }


//        driver.quit();
    }
}
