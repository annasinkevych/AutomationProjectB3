package io.loop.test.day9;

import io.loop.pages.LoopPraticeDragDropPractice;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class T4_drag_drop_POM {

    //POM - page object model

    LoopPraticeDragDropPractice loopPraticeDragDropPractice;

    Actions actions;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        loopPraticeDragDropPractice = new LoopPraticeDragDropPractice();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void drag_small_here_test(){
        String expected = "Drag the small circle here.";
        String  actual = loopPraticeDragDropPractice.bigCircle.getText();
        assertEquals(actual, expected, "Actual does not match the expected");
    }

//    @Test
//    public void drag_big_here_test(){
//        String expected = "Drag the small circle here.";
//        String  actual = loopPraticeDragDropPractice.smallCircle.getText();
//        assertEquals(actual, expected, "Actual does not match the expected");
//    }

    @Test
    public void drop_here_test(){
        actions.moveToElement(loopPraticeDragDropPractice.smallCircle)
                .clickAndHold() //click and hold
                .moveByOffset(100,100)//move 100 by x and 100 by y
                .pause(3000)//pasue to be able to capture the text that appears
                .perform();//doo alt the above

        assertEquals(loopPraticeDragDropPractice.bigCircle.getText(), "Drop here.");
    }

    @Test
    public void drop_now_test(){
        actions.moveToElement(loopPraticeDragDropPractice.smallCircle)
                .clickAndHold()
                .moveByOffset(0, -200)
                .pause(3000)
                .perform();

        assertEquals(loopPraticeDragDropPractice.bigCircle.getText(), "Now drop...");
    }

    @Test
    public void drop_anywhere_test(){
        actions.moveToElement(loopPraticeDragDropPractice.smallCircle)
                .clickAndHold()
                .moveByOffset(0, 250)
                .release()
                .perform();

        assertEquals(loopPraticeDragDropPractice.bigCircle.getText(), "Try again!");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
