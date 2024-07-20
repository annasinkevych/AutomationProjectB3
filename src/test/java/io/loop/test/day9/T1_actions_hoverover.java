package io.loop.test.day9;


import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T1_actions_hoverover {

    @Test
    public void google_action_hoverover() throws InterruptedException{
        /*This line of code uses the Driver class to get a WebDriver instance and opens the URL specified in the configuration file under the key "google.url".*/
                Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input"));
        WebElement feelingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));

        /*
        This line initializes the Actions class, which is used to perform complex user interactions such as mouse movements, key press/release, and drag-and-drop.
         */
        Actions actions = new Actions(Driver.getDriver());

        Thread.sleep(3000);

        /*
        Moves the mouse to the search box, waits for 3 seconds, then moves the mouse to the "I'm Feeling Lucky" button, waiting 3 seconds before each action.
         */

        /*
        Moves the mouse cursor to the googleSearch input box and performs the action.
         */
        actions.moveToElement(googleSearch).perform();

        Thread.sleep(3000);

        /*
        actions.moveToElement(feelingLucky).perform();: Moves the mouse cursor to the "I'm Feeling Lucky" button and performs the action.
         */
        actions.moveToElement(feelingLucky).perform();
    }
}
