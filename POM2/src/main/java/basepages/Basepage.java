package basepages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Basepage {
	
	WebDriver driver;

	public Basepage(WebDriver driver){
		this.driver=driver;	
	}
	
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void sendKeys(WebElement textBox,String text){	
		textBox.sendKeys(text);	
	}
	
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getTitleOfPage() {
		return driver.getTitle();
	}
	
	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public void selectFromDropdown(WebElement dropdown,String option) {  //to select option in dropdown
		Select select=new Select(dropdown);
		select.selectByValue(option);				
	}
	
	public void selectRadiobutton(List<WebElement> radioButtons, String option) {  //toselect radio button

		for(WebElement radioButton:radioButtons) {
			if(radioButton.getAttribute("value").equalsIgnoreCase(option)){
				radioButton.click();
				break;
			}
		}				
	}
	
	public void handleSimpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void handleConfirmationAlert(String option) {
		Alert alert = driver.switchTo().alert();
		if(option.equalsIgnoreCase("ok")) {
		alert.accept();
		alert.accept();
		}
		if(option.equalsIgnoreCase("cancel")) {
			alert.dismiss();
		}
	}
	
	public void submitForm(WebElement submitBtn) {
		submitBtn.submit();
	}
	
	public void handlePromptAlert(String msg) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(msg);
		alert.accept();
	}
}
