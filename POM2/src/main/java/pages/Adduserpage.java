package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.Basepage;

public class Adduserpage extends Basepage {
	
	WebDriver driver;
	public Adduserpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="mobile")
	private WebElement mobile;
		
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="course")
	private WebElement course;
	
	@FindBy(name="gender")
	private List<WebElement> genders;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement stateDropdown;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@placeholder='FriendMobile']")
	private WebElement friendMobile;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void enterMobile(String mobileNo) {
		mobile.sendKeys(mobileNo);
	}
	
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void enterCourse(String courseName) {
		course.sendKeys(courseName);
	}
	
	public void selectGender(String Option) {
		selectRadiobutton(genders, Option);
	}
	
	public void selectState(String Option) {
		selectFromDropdown(stateDropdown, Option);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void enterFriendMobileno(String friendMobileno) {
		friendMobile.sendKeys(friendMobileno);
	}
	
	public void clickOnSubmit() {
		submitForm(submitBtn);
	}
	
}
