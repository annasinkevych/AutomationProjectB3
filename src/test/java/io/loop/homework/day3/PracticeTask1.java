package io.loop.homework.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeTask1 {

    /*
    1- Open a chrome browser
    2- Go to: https://google.com
    3- Click to Gmail from top right.
    4- Verify title contains:
    Expected: Gmail
    5- Go back to Google by using the .back();
    6- Verify title equals:
    Expected: Google
     */

    /*
    Task 2
    ================
    1. Open Chrome browser
    2. Go to https://www.etsy.com
    3. Search for “wooden spoon”
    4. Verify title:
    Expected: “Wooden spoon | Etsy”
     */
    public static void main(String[] args) {
        //1- open a chrome browser
        WebDriver driver = new ChromeDriver();
        //maximise the window
        driver.manage().window().maximize();

        //2- navigate to the web page
        driver.get("https://www.google.com/");

        //3- Click to Gmail from top right
        WebElement gmailElement = driver.findElement(By.linkText("Gmail"));

        gmailElement.click();

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle);
        // 4- Verify title contains: Expected: Gmail
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("=>TEST PASS: actual title: " + actualTitle + " CONTAINS expected title: " + expectedTitle);
        } else {
            System.out.println("=>TEST FAIL: actual title: " + actualTitle + " DOES NOT contain expected title: " + expectedTitle);
        }

        //5- Go back to Google by using the .back();
        driver.navigate().back();

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        //6- Verify title equals: Expected: Google
        if (actualGoogleTitle.equals(expectedGoogleTitle)) {
            System.out.println("=>TEST PASS: actual title: " + actualGoogleTitle + " MATCHES expected title: " + expectedGoogleTitle);
        } else {
            System.out.println("=>TEST FAIL: actual title: " + actualGoogleTitle + " DOES NOT MATCH expected title: " + expectedGoogleTitle);
        }


    }
}
