package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T0_forget_password {

    /*
    verify forget password
    identify reset password heading using CSS and go from parent to child

     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        //go to url
        driver.get("https://beta.docuport.app");

        //forget password link
        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgetPasswordLink.click();

        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']> h1"));
        //forgetPasswordHeading: Reset password
        System.out.println("forgetPasswordHeading: " + forgetPasswordHeading.getText());


    }
}
