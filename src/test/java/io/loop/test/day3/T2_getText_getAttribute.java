package io.loop.test.day3;

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {


    public static void main(String[] args) {


        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.loopcamp.vercel.app/registration_form.html");

        WebElement headerForForm = driver.findElement(By.tagName("h2"));
        String actualHeaderForForm = headerForForm.getText();

        if(actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual header: \"" + actualHeaderForForm+ "\" => TEST PASS");
        }
        else {
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", doesn't match actual header: \"" + actualHeaderForForm + "\" => TEST FAIL");
        }

        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));
        String actualFirstNamePlaceholder = firstNamePlaceholder.getAttribute("placeholder");

        if(actualFirstNamePlaceholder.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_FIRSTNAME)){
            System.out.println("Expected placeholder matches with actual");
            System.out.println("TEST_PASS");
        }else {
            System.out.println("Expected placeholder DOES NOT matche with actual");
            System.out.println("TEST_FAILED");
        }


    }
}
