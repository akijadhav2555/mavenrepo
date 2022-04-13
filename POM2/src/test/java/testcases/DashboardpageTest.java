package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepages.TestBase;
import pages.Dashboardpage;
import pages.Loginpage;
import utility.ExcelUtility;


public class DashboardpageTest{

	WebDriver driver;
	Dashboardpage dp;
	
	@BeforeMethod
	public void setup() throws IOException {
		driver=TestBase.Initialization();
		dp=new Loginpage(driver).navigateToDashboardpage();	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	
	@Test (priority = 1,dataProvider = "languages testdata", dataProviderClass = ExcelUtility.class)
	public void verifylangaugesText(String langName) {
		Assert.assertEquals(dp.getLanguageText(langName), langName);
	}
	
	@Test (priority = 2,dataProvider = "courses testdata", dataProviderClass = ExcelUtility.class)
	public void verifyCoursesText(String langName,String courseName) {		
		Assert.assertEquals(dp.getCourseText(langName, courseName), courseName);
	}
	
	@Test (priority = 3)
	public void verifyUserpageLink()  {
		dp.clickOnUserpageLink();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
		}
		
	@Test(priority = 4)
	public void verifyLogoutLink(){	
		dp.clickOnlogoutLink();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
}
