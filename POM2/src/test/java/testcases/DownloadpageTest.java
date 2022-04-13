package testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepages.TestBase;
import pages.Downloadspage;
import pages.Loginpage;


public class DownloadpageTest extends TestBase {
	
	WebDriver driver;	
	Downloadspage dwp;
	
	@BeforeMethod
	public void setup() throws IOException {
		driver=Initialization();
		dwp=new Loginpage(driver).navigateToDashboardpage().navigateToDownloadpage();	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void VerifyOrderOfVendor() {
	String actual=dwp.checkOrderOfVendor("Selenium Server Source Jar");
	Assert.assertEquals(actual, "Selenium Server Standalon Jar");	
	}
	
	@Test(priority=2)
	public void VerifyCountOfEnableDownloadLinks() {
	Assert.assertEquals(dwp.enabledDownloadLinksCount(), 7);
	}

}
