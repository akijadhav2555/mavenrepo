package basepages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	static WebDriver driver;

	static Properties ps;

	public static String getProperty(String Key) throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Propertiesfile\\config.properties");
		ps=new Properties();
		ps.load(fis);		
		return ps.getProperty(Key);	
	}

	public static WebDriver Initialization() {
		String browserName = null;
		try {
			browserName = getProperty("Browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();

		try {
			driver.get(getProperty("URL"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return driver;
	}

	public static String validEmail(){
		String email=null;
		try {
			return getProperty("Email");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return email;
	}

	public static String validPassword()  {
		String password=null;
		try {
			return getProperty("Password");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return password;
	}

}
