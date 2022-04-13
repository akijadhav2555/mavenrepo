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
import pages.Operatorpage;


public class OperatorpageTest  extends TestBase {


	WebDriver driver;	
	Operatorpage op;
	
	@BeforeMethod
	public void setup() throws IOException{
		driver=Initialization();
		op=new Loginpage(driver).navigateToDashboardpage().navigateToOperatorpage();	
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void VerifyOperatorsCount() {
		Assert.assertEquals(op.noOfOperators(), 5);	
	}
	
	
	@Test(priority=2)
	public void VerifyOperatorForTechnicalHelp() {
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Kiran");
		expectedNames.add("Neelam");
		expectedNames.add("Darshit");
		ArrayList<String> actualNames=op.findOperatorsForTechnicalSupport();
		Assert.assertEquals(actualNames, expectedNames);
	}
	
	@Test(priority=3)
	public void verfifyOperatorsAvailableOnWhatapp_Phone_Sms_Email() {
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Neelam");
		expectedNames.add("Seema");
		expectedNames.add("Varsha");
		ArrayList<String> actualNames=op.findOperatorsAvailableOnWhatapp_Phone_Sms_Email();
		Assert.assertEquals(actualNames, expectedNames);
	}
	
	@Test(priority=4)
	public void verfifyOperatorsWorkingDays() {
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Neelam");
		expectedNames.add("Seema");
		ArrayList<String> actualNames=op.findOperatorsAvailableOnDaysOrTime("Monday-Saturday");
		Assert.assertEquals(actualNames, expectedNames);
	
	}
	
	@Test(priority=5)
	public void verfifyOperatorsWorkingTime() {
		ArrayList<String> expectedNames=new ArrayList<String>();
		expectedNames.add("Neelam");
		expectedNames.add("Seema");
		expectedNames.add("Varsha");
		ArrayList<String> actualNames=op.findOperatorsAvailableOnDaysOrTime("09:00 AM to 06:00");
		Assert.assertEquals(actualNames, expectedNames);
	
	}	
}
