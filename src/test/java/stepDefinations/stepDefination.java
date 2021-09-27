package stepDefinations;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Searchpage;
import pageObject.homepage;
import reusable.base;
import pageObject.SigninPage;

public class stepDefination extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	public homepage hp;
	public String curlb;
	public WebDriver driver;
	@Given("driver is initialized")
	public void driver_is_initialized() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver = runner.runnerFile.before();
	    
	}
	@Given("the url {string} is entered")
	public void the_url_is_entered(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(string);
		Thread.sleep(2000);
	}
	 @When("^searched for \"([^\"]*)\"$")
	    public void searched_for_something(String strArg1) throws InterruptedException {
		 homepage hp = new homepage(driver);
			hp.searchOperation(strArg1);
			
		}

	 @Then("^search page is loaded and the \"([^\"]*)\" result is verfied$")
	    public void search_page_is_loaded_and_the_something_result_is_verfied(String strArg1) {
		 Searchpage sp = new Searchpage(driver);
		 assertEquals(sp.searchVerification(),strArg1 );
			log.info("search page is correct");
	    }
	 @And("^quit$")
	    public void quit(){
	        driver.close();
	    }

	    @Then("^list options are counted and verified to 10$")
	    public void list_options_are_counted_and_verified_to_10() throws InterruptedException{

			homepage hp = new homepage(driver);
			assertEquals(hp.sale(), 10);
			log.info("all the list elements are available");
	    }
	    @Then("^hovered to lists and the \"([^\"]*)\" option is visible$")
	    public void hovered_to_lists_and_the_something_option_is_visible(String strArg1) throws InterruptedException, IOException  {
	    	homepage hp = new homepage(driver);
			//System.out.println(hp.hover());
			assertEquals(hp.hover().contains(strArg1),true);
			log.info("list contents are opening");
	    }
	    @Then("^verify the title \"([^\"]*)\"$")
	    public void verify_the_title_something(String strArg1)  {
	    	String title = driver.getTitle();
			//System.out.println(title);
			assertEquals(title.contains(strArg1),true);
			log.info("title is correct");
	    }

	    @Then("^verify whether the \"([^\"]*)\" is present in categories list$")
	    public void verify_whether_the_something_is_present_in_categories_list(String strArg1) {
	    	homepage hp = new homepage(driver);
			//System.out.println(hp.studytable());
			assertEquals(1,hp.studytable() );
			log.info("study table is present in the categories list");
	    }
	    @Then("^\"([^\"]*)\" is given as the input mail id$")
	    public void something_is_given_as_the_input_mail_id(String strArg1) throws InterruptedException  {
	    	homepage hp = new homepage(driver);
	    	SigninPage sp = new SigninPage(driver);
			hp.clickwishlist();
			Thread.sleep(1000);
			sp.mail(strArg1);
	    }
	    @And("^later the invalid messsage \"([^\"]*)\" is prompted$")
	    public void later_the_invalid_messsage_something_is_prompted(String strArg1) {
	    	SigninPage sp = new SigninPage(driver);
	    	assertEquals(sp.validLabel(),strArg1);
	    }
	    @And("^signup page is opened$")
	    public void signup_page_is_opened() throws InterruptedException  {
	    	homepage hp = new homepage(driver);
			
			hp.clickwishlist();
			Thread.sleep(1000);
	    }

	    @Then("^\"([^\"]*)\" as mail and \"([^\"]*)\" as password it should signup$")
	    public void something_as_mail_and_something_as_password_it_should_signup(String strArg1, String strArg2) throws InterruptedException  {
	    	SigninPage sp = new SigninPage(driver);
	    	sp.mail2(strArg1,strArg2);
			log.info("account created");
	    }
	    @Then("^got to subscription step and enter the \"([^\"]*)\" as mail id and subscribe$")
	    public void got_to_subscription_step_and_enter_the_something_as_mail_id_and_subscribe(String strArg1) throws InterruptedException  {
	    	homepage hp = new homepage(driver);
			hp.smail(strArg1);
			log.info("subscribed");
	    }
	    @Then("^go to socoial media section and verify if all the socoal media websites are present$")
	    public void go_to_socoial_media_section_and_verify_if_all_the_socoal_media_websites_are_present()  {
	    	homepage hp = new homepage(driver);
			assertEquals(hp.socialmedia(),7);
			log.info("all the social media apps are present");
	    }
	    @Then("^verify this \"([^\"]*)\" is contained in the address$")
	    public void verify_this_something_is_contained_in_the_address(String strArg1)  {
	    	homepage hp = new homepage(driver);
			//System.out.println(hp.address());
			assertEquals(hp.address().contains(strArg1),true);
	    }
	    



	

}
