package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T0_Radio_Button {

    public static void main(String[] args) {


        //Implicit wait checks 20 times every 10 seconds if elements exists

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");

        //selenium 3
        //driver.manage().timeouts().implicitWait(10,TimeUnit.Seconds)

        //selenium4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        //isSelected()
        System.out.println("red.isSelected() BEFORE CLICKING = " + red.isSelected());
        red.click();
        System.out.println("green.isSelected() AFTER CLICKING = " + green.isSelected());
        green.click();

        //isEnabled
        System.out.println("red.isEnabled() = " + red.isEnabled());//red.isEnabled() = true
        System.out.println("green.isEnabled() = " + green.isEnabled());//green.isEnabled() = false


    }
}
