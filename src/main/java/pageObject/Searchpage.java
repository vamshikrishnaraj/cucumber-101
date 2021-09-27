package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusable.base;
import uistore.HomepageUistore;
import uistore.SearchpageUistore;


public class Searchpage extends base {
 public WebDriver driver;
 
public Searchpage(WebDriver driver2) {
	// TODO Auto-generated constructor stub
	this.driver = driver2;
}

SearchpageUistore su = new SearchpageUistore();


public String searchVerification() {
	return driver.findElement(su.pagename).getText();
}




 
 
 
}
;