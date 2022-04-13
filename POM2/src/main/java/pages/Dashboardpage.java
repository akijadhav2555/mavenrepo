package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.Basepage;

import org.openqa.selenium.WebElement;

public class Dashboardpage extends Basepage {


	WebDriver driver;

	public Dashboardpage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}

	@FindBy(xpath="//h3")
	private List<WebElement> languages;

	@FindBy(xpath="//h3//following-sibling::p")
	private List<WebElement> courses;

	@FindBy(xpath="//a//span[text()='Users']")
	private WebElement userpageLink;
	
	@FindBy(xpath="//a//span[text()='Operators']")
	private WebElement operatorpageLink;

	@FindBy(xpath="//a//span[text()='Downloads']")
	private WebElement downloadpageLink;

	
	@FindBy(linkText="LOGOUT")
	private WebElement logoutLink;

	
	public String getLanguageText(String langName) { 
		String lantext=null;
		for(WebElement language:languages) {
		if(language.getText().equals(langName)) {
		lantext= getText(language);
		break;
		}
	}
		return lantext;
	}
	

	public String getCourseText(String langName,String courseName) { 
		String coursetext=null;
		for(int i=0;i<languages.size();i++) {
			for(int j=i;i<courses.size();j++) {
			if(languages.get(i).getText().equals(langName)&&courses.get(j).getText().equals(courseName)) {
				coursetext =getText(courses.get(j));
				break;
			}
			else
				break;		
		}
			if(coursetext!=null)
				break;
	}
		return coursetext;
	}
	
	public void clickOnUserpageLink() { 
        click(userpageLink);
	}
	
	public void clickOnlogoutLink() { 
		click(logoutLink);
	}
	
	public void clickOnOperatorpageLink() { 
		click(operatorpageLink);
	}
	
	public void clickOnDownloadpageLink() { 
		click(downloadpageLink);
	}
	
	public Userpage navigateToUserpage() {
	    clickOnUserpageLink();
		return new Userpage(driver);	
	}
	
	public Operatorpage navigateToOperatorpage() {
	    clickOnOperatorpageLink();
		return new Operatorpage(driver);	
	}
	

	public Downloadspage navigateToDownloadpage() {
		clickOnDownloadpageLink();
		return new Downloadspage(driver);	
	}

}

