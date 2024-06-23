package io.loop.test.day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class T1_testNG_intro {

//IN ORDER TO WORK WITH TESTNG WE NEED TO ADD THE LIBRARY, LOAD THE DEPENDENCIES TO THE POM.XML

    //INSTEAD OF MAIN METHOD WE USE @TEST NG ANNOTATION

    @Test
    public void test3(){
        System.out.println("Test 3 is running");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("Test 2 is running");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test 1 is running");
        String actual = "Feyruz";
        String expected = "Nadir";
        //shows message passed to 3rd parameter only if test fails
        Assert.assertEquals(actual, expected, "Message from actual it will only show if test fails ");
    }

    @Test
    public void btest(){
        System.out.println("Test b is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }

}
