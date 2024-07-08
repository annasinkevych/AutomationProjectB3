package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

import java.util.Set;

public class BrowserUtils {

    /**
     * validate that driver switched to expected url and title
     * iterating windows and getting window handles and asserting the title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     *
     */



    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){

        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();


        //get all window handles , switch one by one and eeach time check if the urk matches expeceted url to stop
        Set<String> windowHandles = driver.getWindowHandles();
        for(String each: windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }

        //after stopping on expected url validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * Method which will switch to the window that I provide title to
     * @param driver
     * @param targetTitle
     * @author anna
     */


    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();

        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }

        //if cannot find the title we are looking for it switches to the window which is origin - in this case it's amazon as it's the first one that is open
        driver.switchTo().window(origin);
    }
}
