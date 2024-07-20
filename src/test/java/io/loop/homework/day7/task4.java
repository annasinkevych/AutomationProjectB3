package io.loop.homework.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class task4 extends TestBase {

    /*
    task4
    =============
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
    3. test type
    4. test amount
    5. test date
    6. test street
    7. test city
    8. test state
    9. test zip
    10. test card
    11. test card number
    12. test exp
    */

    @Test
    public void tableTest() {
        //go to https://loopcamp.vercel.app/web-tables.html
        driver.get("https://loopcamp.vercel.app/web-tables.html");

        //validate pizza type
        validateField(driver, "Alexandra Gray", "pizza type", "Thin Crust");

        //validate amount
        validateField(driver, "Alexandra Gray", "amount", "2");

        //validate date
        validateField(driver, "John Doe", "Date", "01/08/2021");

        //validate street
        validateField(driver, "Stewart Dawidson", "street", "19, Victor Ave");

        //validate city
        validateField(driver, "Stewart Dawidson", "city", "Cate Island");

        //validate state
        validateField(driver, "John Doe", "state", "Canada");

        //validate zip
        validateField(driver, "John Doe", "zip", "76743");

        //validate card
        validateField(driver, "John Doe", "card", "MasterCard");

        //validate card number
        validateField(driver, "Bart Fisher", "card number", "444222333666");

        //validate exp
        validateField(driver, "Alexandra Gray", "exp", "02/24");


    }

    public void validateField(WebDriver driver, String name, String field, String expectedValue) {
        String actual = TableFieldFinder.returnField(driver, name, field);
        assertion(actual, expectedValue, field);
    }

    public void assertion(String actual, String expected, String field) {
        String message = "Actual " + field + ": " + actual + " DOES NOT MATCH EXPECTED " + field + ": " + expected;
        assertEquals(actual, expected, message);
    }
}
