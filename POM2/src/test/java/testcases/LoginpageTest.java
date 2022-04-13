package testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepages.TestBase;
import pages.Loginpage;

public class LoginpageTest {

	WebDriver driver;
	Loginpage lp;

	@BeforeMethod
	public void setUp() throws IOException {
		driver=TestBase.Initialization();
		lp=new Loginpage(driver);
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	@Test (priority = 1)
	public void verifyTitleOfPage() {	
		Assert.assertEquals(lp.getTitleOfpage(), "JavaByKiran | Log in");		
	}

	@Test (priority = 2)
	public void verifyLogo() {	
		Assert.assertTrue(lp.isLogoVisible());
	}

	@Test (priority = 3)
	public void verifyLogoText() {	
		Assert.assertEquals(lp.getLogoText(), "Java By Kiran");
	}

	@Test (priority = 4)
	public void verifyValidLogin() {	
		lp.enterEmail("kiran@gmail.com");
		lp.enterPassword("123456");
		lp.clickOnLogInBtn();
		Assert.assertEquals(lp.getTitleOfPage(), "JavaByKiran | Dashboard");
	}

	@Test (priority = 5)
	public void verifyLoginWithWrongPass() {	
		lp.enterEmail("kiran@gmail.com");
		lp.enterPassword("12345");
		lp.clickOnLogInBtn();
		Assert.assertEquals(lp.getPasswordEroor(), "Please enter password 123456");
	}

	@Test (priority = 6)
	public void verifyLoginWithWrongEmail() {	
		lp.enterEmail("kirn@gmail.com");
		lp.enterPassword("123456");
		lp.clickOnLogInBtn();
		Assert.assertEquals(lp.getEmailEroor(), "Please enter email as kiran@gmail.com");
	}

	@Test (priority = 7)
	public void verifyLoginWithWrongEmailAndPass() {	
		lp.enterEmail("kirn@gmail.com");
		lp.enterPassword("12345");
		lp.clickOnLogInBtn();
		String expEmailError="Please enter email as kiran@gmail.com";
		String expPasswordError="Please enter password 123456";
		Assert.assertTrue(lp.getEmailEroor().equals(expEmailError) && lp.getPasswordEroor().equals(expPasswordError));
	}


	@Test (priority = 8)
	public void verifyLoginWithBlankDetail() {	
		lp.enterEmail("");
		lp.enterPassword("");
		lp.clickOnLogInBtn();
		String expEmailError="Please enter email.";
		String expPasswordError="Please enter password.";
	    Assert.assertTrue(lp.getEmailEroor().equals(expEmailError) && lp.getPasswordEroor().equals(expPasswordError));
	}


	@Test(priority = 9)
	public void verifyRegisterLink() {	
		Assert.assertTrue(lp.isRegisterLinkEnabled());
	}


	@Test(priority = 10)
	public void verifyRegisterPage() {	
		lp.clickOnRegisterLink();
		Assert.assertEquals(lp.getTitleOfPage(), "JavaByKiran | Registration Page");
	}
	


}
