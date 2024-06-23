package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class T1_Find_Elements {

    public static void main(String[] args) {
        /*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.nba.com");

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println(nbaLinks.size());
        List<WebElement> nbaLinksXpath = driver.findElements(By.xpath("//a"));
        System.out.println(nbaLinksXpath.size());

        for(WebElement nbaLink : nbaLinks) {
            if(!nbaLink.getText().equals("")){
                System.out.println("nbaLinks.text()" + nbaLink.getText());
                System.out.println(nbaLink.getAttribute("href"));
            }
        }

        for(int i = 0; i<nbaLinks.size(); i++){
            if(!nbaLinks.get(i).getText().equals("")){
                System.out.println("nbaLinks.text()" + nbaLinks.get(i).getText());
            }
        }

        driver.quit();
    }
}
