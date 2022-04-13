package testcases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepages.TestBase;
import pages.Loginpage;
import pages.Userpage;


public class UserpageTest extends TestBase {
	
	WebDriver driver;	
	Userpage up;
	
	@BeforeMethod
	public void setup() throws IOException {
		driver=Initialization();
		up=new Loginpage(driver).navigateToDashboardpage().navigateToUserpage();	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void VerifyUsersWithWrongEmailText() {
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Sagar");
		Assert.assertEquals(up.findUserWithWrongEmailTexts(), expectedNames);		
	}
	
	@Test(priority=2)
	public void VerifyUserCount() {
		Assert.assertEquals(up.noOfUsers(), 4);	
	}
	
	@Test(priority=3)
	public void VerifyUserWithMaleGender() {
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Kiran");
		expectedNames.add("Sagar");
		Assert.assertEquals(up.findUsersOfGender("Male"), expectedNames);
	}
	
	@Test(priority=4)
	public void VerifyUserWithFemaleGender() {
		ArrayList<String> actualNames=up.findUsersOfGender("Female");
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Monica");
		expectedNames.add("Kimaya");
		Assert.assertEquals(actualNames, expectedNames);
	}
	
	@Test(priority=5)
	public void VerifyDefaultUserDeleteFunctionality() throws InterruptedException {
	Assert.assertEquals(up.checkdeleteUserBtn("Kiran"),false);
	}
	

	@Test(priority=6)
	public void VerifytempUserDeleteFunctionality() throws InterruptedException {
	Assert.assertEquals(up.checkdeleteUserBtn("Sagar"),true);
	}
	
	
	

}
