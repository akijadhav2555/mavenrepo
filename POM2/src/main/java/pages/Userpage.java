package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.Basepage;

public class Userpage extends Basepage {

	WebDriver driver;

	public Userpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}

	@FindBy(xpath = "//tr")
	private List<WebElement> tableRows;

	@FindBy(xpath = "//th")
	private List<WebElement> headerCol;

	private By userCol=By.xpath(".//td");

	@FindBy(xpath="//span[text()='Delete']")
	private List<WebElement> deleteUserBtns;

	@FindBy(xpath="//a//button[text()='Add User']")
	private WebElement addUserBtn;

	public int noOfUsers() {
		return tableRows.size()-1;
	}

	public ArrayList<String> findUserWithWrongEmailTexts() {
		ArrayList<String> users=new ArrayList<String>();
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("Email")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(userCol);
					if(	rowsCols.get(j).getText().endsWith("@gmail.com"));
				
					else {
						users.add(rowsCols.get(1).getText());
					}

				}
			}

		}
		return users;
	}

	public ArrayList<String> findUsersOfGender(String gender) {
		ArrayList<String> userNames=new ArrayList<String>();
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("Gender")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(userCol);
					if(rowsCols.get(j).getText().contains(gender)) {
						userNames.add(rowsCols.get(1).getText());
					}
				}
			}
			if(userNames.size()>0) {
				break;
			}
		}
		return userNames;
	}


	public boolean checkdeleteUserBtn(String userName) throws InterruptedException {	

		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("Action")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(userCol);
					if(rowsCols.get(1).getText().equals(userName)) {
						deleteUserBtns.get(i-1).click();
						Alert alert=driver.switchTo().alert();
						if(alert.getText().equals("You can not delete Default User"))
						{
							alert.accept();
							boolean value=rowsCols.get(1).isDisplayed();

							if(value) {
								return false;
							}
							else
								return true;					
						}

						else
						{
							alert.accept();
							alert.accept();
							boolean value=rowsCols.get(1).isDisplayed();
							if(value) {
								return false;
							}
							else
								return true;	
						}

					}
				}
			}
		}
       return false;
	}
	
	public Adduserpage navigateToAdduserpage() {		
		click(addUserBtn);
		return new Adduserpage(driver);
	}
}
