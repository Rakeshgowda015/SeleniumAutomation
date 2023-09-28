package com.dbiz.libs;

import org.openqa.selenium.By;

public class ObjectLocators {

	public static By getBySelector(String propKey) {
	    // get the value from selenium.properties and split the type and value
	    String[] split = propKey.split(";");
	    
	    // Check if there are at least two elements in the split array
	    if (split.length != 2) {
	        throw new IllegalArgumentException("Invalid element locator parameter - " + propKey);
	    }

	    String type = split[0].toLowerCase(); // Convert type to lowercase for case-insensitive comparison
	    String value = split[1].trim(); // Trim any leading/trailing spaces from the value

	    // generate the By selector based on the type
	    switch (type) {
	        case "id":
	            return By.id(value);
	        case "css":
	            return By.cssSelector(value);
	        case "tagname":
	            return By.tagName(value);
	        case "classname":
	        case "class":
	            return By.className(value);
	        case "name":
	            return By.name(value);
	        case "xpath":
	            return By.xpath(value);
	        case "link":
	            return By.linkText(value);
	        default:
	            throw new IllegalArgumentException("Invalid element locator type - " + type);
	    }
	}

}
