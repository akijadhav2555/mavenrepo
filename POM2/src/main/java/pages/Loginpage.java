package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basepages.Basepage;
import basepages.TestBase;

public class Loginpage extends Basepage  {
	
	WebDriver driver;

	public Loginpage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}
	
	@FindBy(tagName = "img")
	private WebElement logo;
	
	@FindBy(xpath = "//b[text()='Java By Kiran']")
	private WebElement logoText;

	@FindBy(id = "email")
	private WebElement emailTextbox;
	
	@FindBy(id = "password")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button")
	private WebElement signinButton;

	@FindBy(id = "password_error")
	private WebElement passwordError;

	@FindBy(id = "email_error")
	private WebElement emailError;
	
	@FindBy(partialLinkText = "Register")
	private WebElement registerLink;
	
	
	public void enterEmail(String text) {
		sendKeys(emailTextbox, text);
	}
	
	public void enterPassword(String text){	
        sendKeys(passwordTextbox, text);
	}
	
	public void clickOnLogInBtn() {
		click(signinButton);
	}
	
	public boolean isLogoVisible() {
		return isDisplayed(logo);
	}
	
	public String getLogoText() {
		return getText(logoText);
	}
	
	public String getPasswordEroor() {
		return getText(passwordError);
	}
	
	public String getEmailEroor() {
		return getText(emailError);
	}
	
	public boolean isRegisterLinkEnabled() {
		return isEnabled(registerLink);
	}
	
	public void clickOnRegisterLink() {
		click(registerLink);
	}
	
	public String getTitleOfpage() {
		return getTitleOfPage();
	}
	
	
	public Dashboardpage navigateToDashboardpage() {
		enterEmail(TestBase.validEmail());
		enterPassword(TestBase.validPassword());
		clickOnLogInBtn();
		return new Dashboardpage(driver);	
	}
}
