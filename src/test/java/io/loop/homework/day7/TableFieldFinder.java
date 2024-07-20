package io.loop.homework.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TableFieldFinder {

    public static String returnField(WebDriver driver,String name,  String fieldName){
        String field = "";
        int index = 0;

        Map<String, Integer> fieldNames = Map.of(
                "pizza type", 1,
                "amount", 2,
                "date", 3,
                "street", 4,
                "city", 5,
                "state", 6,
                "zip", 7,
                "card", 8,
                "card number", 9,
                "exp", 10
        );

        try {
            boolean found = false;
            for (Map.Entry<String, Integer> fields : fieldNames.entrySet()) {
                if (fieldName.equalsIgnoreCase(fields.getKey())) {
                    index = fields.getValue();
                    field = driver.findElement(By.xpath("//td[2]//td[2][.='" + name + "']/following-sibling::td[" + index + "]")).getText();
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new NoSuchFieldException("Field name not found: " + fieldName);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return field;
    }
}
