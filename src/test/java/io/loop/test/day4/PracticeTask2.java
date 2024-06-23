package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    task 2
    =============
    1. login to docuport application
    2. logout from docuport application
    3. Validate successful login
    4. Validate successful logout
 */
public class PracticeTask2 {

    public static void main(String[] args) throws InterruptedException {

        //create a WebDriver object
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        //maximize
        driver.manage().window().maximize();

        //navigate to Docuport
        driver.get("https://beta.docuport.app/");

        //login to Docuport Application

        //locate the username  login box and enter username
        WebElement usernameBoxXpath = driver.findElement(By.xpath("//*[@id='input-14']"));
        usernameBoxXpath.sendKeys(DocuportConstants.USERNAME_CLIENT);

        //enter  password
        WebElement passwordBoxXpath = driver.findElement(By.xpath("//*[@id='input-15']"));
        passwordBoxXpath.sendKeys(DocuportConstants.PASSWORD_CLIENT + Keys.ENTER);


        Thread.sleep(3000);

        WebElement chooseAccPopUp = driver.findElement(By.xpath("//h3[@class='text-h6']"));
        if (chooseAccPopUp.isDisplayed())
            System.out.println("LOGIN SUCCESSFUL => TEXT PASS");
        else
            System.out.println("LOGIN UNSUCCESSFUL => TEXT FAILED");

        //find continue button and  click it
        WebElement continueButtonXpath = driver.findElement(By.xpath("//span[.=' Continue ']"));
        continueButtonXpath.click();


        //locate batchNum element
        WebElement batchNum = driver.findElement(By.xpath("//span[.='Batch1 Group3']"));
        batchNum.click();

        //locate logout button element
        WebElement logoutButtonXpath = driver.findElement(By.xpath("//span[.='Log out']"));
        Thread.sleep(3000);
        logoutButtonXpath.click();


        Thread.sleep(3000);
        //Validate successful logout by locating Login element using xpath syntax parent to child
        WebElement loginElementXpath = driver.findElement(By.xpath("//div[@class='login-layout__form']/h1"));

        if (loginElementXpath.isDisplayed())
            System.out.println("LOG OUT SUCCESSFUL => TEST PASS");
        else
            System.out.println("LOG OUT UNSUCCESSFUL => TEST FAILED");

    }

}
