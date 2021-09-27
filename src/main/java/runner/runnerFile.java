package runner;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusable.base;
import utilities.datafromexcel;
import pageObject.Searchpage;
import pageObject.SigninPage;
import pageObject.homepage;

public class runnerFile extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public static WebDriver driver;
	
    @BeforeTest
    public static WebDriver  before() throws IOException, InterruptedException {
    	driver = initializedriver();
		log.info("driver intialized");
		driver.manage().window().maximize();
		return driver;
		
    }
	@Test(priority=10)
	public void search() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		hp.searchOperation(prop.getProperty("item"));
		Searchpage sp = new Searchpage(driver);
		ArrayList<String> all = datafromexcel.listgetter("t1");
		String d = all.get(0);
		//System.out.println(all);
		assertEquals(sp.searchVerification(),"'"+d );
		log.info("search page is correct");
		driver.close();
	}
	@Test(priority=1)
	public void lists() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		assertEquals(hp.sale(), 10);
		log.info("all the list elements are available");
		driver.close();
	}
	@Test(priority=2)
	public void hovering() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		//System.out.println(hp.hover());
		assertEquals(hp.hover().contains(datafromexcel.listgetter("t3").get(0)),true);
		log.info("list contents are opening");
		driver.close();
}
	@Test(priority=3)
	public void titleVerification() throws IOException, InterruptedException {
		
		String title = driver.getTitle();
		//System.out.println(title);
		assertEquals(title.contains(datafromexcel.listgetter("t4").get(0)),true);
		log.info("title is correct");
		driver.close();
	}
	@Test(priority=4)
	public void studytableVerification() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		//System.out.println(hp.studytable());
		assertEquals(1,hp.studytable() );
		log.info("study table is present in the categories list");
		driver.close();
		
}
	@Test(priority=5)
	public void email() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		SigninPage sp = new SigninPage(driver);
		hp.clickwishlist();
		Thread.sleep(1000);
		sp.mail(datafromexcel.listgetter("t6").get(0));
		assertEquals(sp.validLabel(),"Please enter a valid email address.");
		driver.close();
	}
	@Test(priority=6)
	public void correctEmail() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		SigninPage sp = new SigninPage(driver);
		hp.clickwishlist();
		Thread.sleep(1000);
		sp.mail2(datafromexcel.listgetter("t7").get(0),datafromexcel.listgetter("t7b").get(0));
		log.info("account created");
		
}
	@Test(priority=7)
	public void Subscription() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		hp.smail(datafromexcel.listgetter("t8").get(0));
		log.info("subscribed");
		driver.close();
		}
	@Test(priority=8)
	public void socialmedia() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		assertEquals(hp.socialmedia(),7);
		log.info("all the social media apps are present");
		driver.close();
		
}
	@Test(priority=9)
	public void address() throws IOException, InterruptedException {
		
		homepage hp = new homepage(driver);
		//System.out.println(hp.address());
		assertEquals(hp.address().contains(prop.getProperty("add")),true);
		driver.close();
	}
}
		
		
		
		
		
		
	


