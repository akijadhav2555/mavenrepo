package testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepages.TestBase;
import pages.Adduserpage;
import pages.Loginpage;

public class AdduserpageTest extends TestBase {
	
	WebDriver driver;	
	Adduserpage ap;
	
	@BeforeMethod
	public void setup() throws IOException {	    
		driver=Initialization();
		ap=new Loginpage(driver).navigateToDashboardpage().navigateToUserpage().navigateToAdduserpage();		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void verifyAddUserFunctionality() {
		
		ap.enterUserName("tss");
		ap.enterMobile("1245789");
		ap.enterEmail("tss9478@gmail.com");
		ap.enterCourse("Java");
		ap.selectGender("Male");
		ap.selectState("Maharashtra");
		ap.enterPassword("125@trd");
		ap.enterFriendMobileno("467751152");
		ap.clickOnSubmit();
		ap.handleSimpleAlert();
	}

}
