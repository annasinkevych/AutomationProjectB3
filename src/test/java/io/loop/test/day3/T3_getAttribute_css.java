package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class T3_getAttribute_css {
    /*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"



     */

    /*
    TODO:
            locate:
                    username
                    password
                    login
                        with css
                    login to docuport
                    locate home icon of docuport after login or any other element after login
                    validate that you logged in
     */

    public static void main(String[] args) {


        /*
        We use CSS Selector to locate an element by placeholder because Selenium doesn't have that capability
        built in
         */

        //got to url
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");

        //identify the logo with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        String docuport = logo.getAttribute("alt");

        System.out.println("docuport + " + docuport);//docuport + Docuport

        if(DocuportConstants.LOGO_DOCUPORT.equals(docuport)){
            System.out.println("Expected matches actual docuport = \"" + docuport + "\"=>TEST PASS");
        }
        else
            System.out.println("Expected DOES NOT MATCH actual docuport = \"" + docuport + "\"=>TEST FAIL");



    }
}
