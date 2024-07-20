package io.loop.test.day10;

import io.loop.pages.LoopPracticeDynamicLoading7;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class T2_Explicit_Wait {


    /*
       1. go https://loopcamp.vercel.app/dynamic_loading/7.html
       2. Wait until title is “Dynamic title”
       3. Assert: Message “Done!” is displayed.
       4. Assert: Image is displayed.
     */

    LoopPracticeDynamicLoading7 loopPracticeDynamicLoading7;
    WebDriverWait wait;

    @BeforeMethod
    public void setUpMethod(){
        loopPracticeDynamicLoading7 = new LoopPracticeDynamicLoading7();
        Driver.getDriver().get(ConfigurationReader.getProperties("loop.practice"));
    }

    @Test
    public void explicit_wait_test(){
        loopPracticeDynamicLoading7.dynamicLoading.click();
        loopPracticeDynamicLoading7.dynamicLoading7.click();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        assertTrue(loopPracticeDynamicLoading7.doneMessage.isDisplayed(), "Element is not displayed");
        assertTrue(loopPracticeDynamicLoading7.image.isDisplayed(), "Element is not displayed");
    }




}

