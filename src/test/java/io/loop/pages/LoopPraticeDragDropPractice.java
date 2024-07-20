package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPraticeDragDropPractice {
    //POM is a design pattern in Selenium that creates an object repository for web UI elements. It helps to reduce code duplication and improve test maintenance.

    public LoopPraticeDragDropPractice(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@id='draggable']")
    public WebElement smallCircle;

    @FindBy (id = "droptarget")
    public WebElement bigCircle;

}
