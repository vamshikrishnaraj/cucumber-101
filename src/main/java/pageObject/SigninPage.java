package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusable.base;
import uistore.HomepageUistore;
import uistore.SearchpageUistore;
import uistore.SigninpageUistore;


public class SigninPage extends base {
 public WebDriver driver;
 
public SigninPage(WebDriver driver2) {
	// TODO Auto-generated constructor stub
	this.driver = driver2;
}

SigninpageUistore si = new SigninpageUistore();


public void mail(String s) throws InterruptedException {
	WebElement mailslot =driver.findElement(si.mailid);
	//System.out.println("here");
	mailslot.sendKeys(s);
	Thread.sleep(1000);
	mailslot.sendKeys(Keys.ENTER);
	Thread.sleep(1000);
}
public String validLabel() {
	return driver.findElement(si.validlabel).getText();
}
public void mail2(String s1, String s2) throws InterruptedException {
	WebElement mailslot =driver.findElement(si.mailid);
	WebElement passslot =driver.findElement(si.password);
	//System.out.println("here");
	mailslot.sendKeys(s1);
	Thread.sleep(1000);
	//mailslot.sendKeys(Keys.ENTER);
	Thread.sleep(1000);
	passslot.click();
	passslot.sendKeys(s2);
	System.out.println(s2);
	Thread.sleep(1000);
	passslot.click();
	
	
}




 
 
 
}
;