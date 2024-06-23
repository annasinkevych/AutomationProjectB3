package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {


        //create driver object
        WebDriver driver = new ChromeDriver();

        //navigate to google
        driver.get("https://www.google.com");

        //maximize
        driver.manage().window().maximize();

        //locate the search box element using unique ID and name
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));

        //locate the search box element using name
        WebElement searchBoxWithName = driver.findElement(By.name("q"));

        //locate the search box element using link text
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        //click on the link text
//        aboutLink.click();
//        System.out.println(searchBoxWithID.getText().isEmpty());
//        System.out.println(searchBoxWithID.isDisplayed());

        String textToSearch = "Feyruz is smart";
        searchBoxWithID.sendKeys("Nadir is smart");
        Thread.sleep(3000);
        searchBoxWithID.clear();
        Thread.sleep(3000);
        //this simulates input into the search box and use Keys.ENTER to simulate pressing Enter key
        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER);
        //searchBoxWithName.sendKeys(textToSearch + Keys.ENTER);
        //System.out.println(driver.getCurrentUrl());

//        driver.quit();

    }
}
