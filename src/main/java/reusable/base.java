package reusable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

	public static Properties prop;
	public static WebDriver initializedriver() throws IOException {
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\urbanladder\\config.properties");
		prop.load(fis);
		WebDriver driver=null;
		String browsername = prop.getProperty("browser");
		//System.out.println(browsername);
		if(browsername.equalsIgnoreCase(prop.getProperty("browser"))) {
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			 driver = new ChromeDriver();
		}
		//similarly do for the firefox and the Internet explorer
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
