package io.loop.homework.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeTask1 {
/*
    task 1
    =============
    1. go to https://loopcamp.vercel.app/forgot-password.html
    2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
    3. use css
    4. verify those elements are displayed
 */
    public static void main(String[] args) {

        //create a WebDriver object
        WebDriver driver =  WebDriverUtil.getDriver("chrome");

        //maximize
        driver.manage().window().maximize();

        // 1. go to https://loopcamp.vercel.app/forgot-password.html
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        //2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP using xpath

        WebElement forgotPasswordXPath = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        WebElement emailXpath = driver.findElement(By.xpath("//label[@for='email']"));
        //or from parent to child
        // driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/label"));
        //or without searching for tagName
        // driver.findElement(By.xpath("//*[@for='email']"));

        WebElement emailInputXpath = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/input"));
        //or driver.findElement(By.xpath("//*[@id='email']"));

        WebElement retrievePWXpath = driver.findElement(By.xpath("//button[@id='form_submit']/i"));
        //or
        //without specifying the tagName
        //driver.findElement(By.xpath("//*[@class='icon-2x icon-signin']"));
        //or by text()
        //driver.findElement(By.xpath("//i[.='Retrieve password']"));

        WebElement powerByTxtXpath = driver.findElement(By.xpath("//*[@style='text-align: center;']"));
        //or by specifying the TagName
        //driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        //2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP using css

        //identify the forgot password with css
        WebElement forgotPWwithCSS = driver.findElement(By.cssSelector("div[class='example']>h2"));

        WebElement emailWithCss = driver.findElement(By.cssSelector("label[for='email']"));
        //or
        //driver.findElement(By.cssSelector("div[class='large-6 small-12 columns']>label"));


        WebElement emailInputWithCss = driver.findElement(By.cssSelector("input[id='email']"));

        WebElement retrievePwWithCss = driver.findElement(By.cssSelector("button[id='form_submit']>i"));

        WebElement powerByTxtCss = driver.findElement(By.cssSelector("div[style='text-align: center;']"));


        //4. verify those elements are displayed

        if(forgotPWwithCSS.isDisplayed())
            System.out.println(forgotPWwithCSS.getText() + " IS DISPLAYED =>TEST PASSED");
        else
            System.out.println(forgotPWwithCSS.getText() + " IS NOT DISPLAYED =>TEST FAILED");

        if(emailWithCss.isDisplayed())
            System.out.println(emailWithCss.getText() + " IS DISPLAYED =>TEST PASSED");
        else
            System.out.println(emailWithCss.getText() + " IS NOT DISPLAYED =>TEST FAILED");

        if(emailInputWithCss.isDisplayed())
            System.out.println("Email Input IS DISPLAYED =>TEST PASSED");
        else
            System.out.println("Email Input IS NOT DISPLAYED =>TEST FAILED");

        if(retrievePwWithCss.isDisplayed())
            System.out.println(retrievePwWithCss.getText() + " IS DISPLAYED =>TEST PASSED");
        else
            System.out.println(retrievePwWithCss.getText() + " IS NOT DISPLAYED =>TEST FAILED");

        if(powerByTxtCss.isDisplayed())
            System.out.println(powerByTxtCss.getText() + " IS DISPLAYED =>TEST PASSED");
        else
            System.out.println(powerByTxtCss.getText() + " IS NOT DISPLAYED =>TEST FAILED");
    }
}
