package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import reusable.base;
import uistore.HomepageUistore;


public class homepage extends base {
 public WebDriver driver;
 
public homepage(WebDriver driver2) {
	// TODO Auto-generated constructor stub
	this.driver = driver2;
}
HomepageUistore hu = new HomepageUistore();

public void searchOperation(String s) throws InterruptedException {
	WebElement se =driver.findElement(hu.search);
	se.click();
	se.sendKeys(s);
	Thread.sleep(1000);
	se.sendKeys(Keys.ENTER);
	Thread.sleep(1000);
}
public int sale() throws InterruptedException {
	List<WebElement> sa =driver.findElements(hu.list);
	return sa.size();
	
}
public String hover() throws InterruptedException {
	 Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(hu.living)).click().build().perform();
	Thread.sleep(1000);
	return driver.findElement(hu.display).getText();

}
public int studytable() {
	return driver.findElements(hu.study).size();
}
public void clickwishlist() {
	driver.findElement(hu.wishlist).click();
}
public void smail(String m) throws InterruptedException {
	WebElement sm =  driver.findElement(hu.smail);
	sm.click();
	sm.sendKeys(m);
	Thread.sleep(1000);
	driver.findElement(hu.subscribe).click();
}
public int socialmedia() {
	return driver.findElements(hu.socialmedia).size();
}
public String address() {
	String add = driver.findElement(hu.address).getText();
	return add;
}




 
 
 
}
;