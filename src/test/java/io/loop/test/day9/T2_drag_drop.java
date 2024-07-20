package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class T2_drag_drop {

    /*
    1- Open a chrome browser
    2- Go to: https://demo.guru99.com/test/drag_drop.html
    3- Drag “BANK” and drop into Account area under Debit Side
    4- Drag “5000” and drop into Amount area under Debit Side
    5- Drag “SALES” and drop into Account area under Credit Side
    6- Drag “5000” and drop into Amount area under Credit Side
    7- Validate “Perfect!” text displayed.
     */

    @Test
    public void dragDrop() {
        Driver.getDriver().get(ConfigurationReader.getProperties("guru.drag"));

        WebElement bank = Driver.getDriver().findElement(By.xpath("//a[text()=' BANK ']"));

        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));

        //This line performs the drag-and-drop action:
        //
        //dragAndDrop(source, target): Drags the source element (bank) and drops it onto the target element (debitAccount).
        //.perform(): Executes the action.

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(bank, debitAccount).perform();

        WebElement fiveK = Driver.getDriver().findElement(By.xpath("//a[text()=' 5000 ']"));

        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));
        actions.dragAndDrop(fiveK, debitAmount).perform();

        WebElement sales = Driver.getDriver().findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement creditAccount = Driver.getDriver().findElement(By.xpath("//ol[@id='loan']/li"));
        actions.dragAndDrop(sales, creditAccount).perform();

        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        actions.dragAndDrop(fiveK, creditAmount).perform();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//a[text()='Perfect!']"));

        String expected = "Perfect!";
        String actual = successMessage.getText();

        assertEquals(actual, expected, "Actual does not match expected");


    }
}
