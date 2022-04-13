package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.Basepage;

public class Operatorpage extends Basepage{
	
	WebDriver driver;

	public Operatorpage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}

	@FindBy(xpath = "//tr")
	private List<WebElement> tableRows;

	@FindBy(xpath = "//th")
	private List<WebElement> headerCol;

	private By operatorCol=By.xpath(".//td");
	
	private By wayToConnectOperator=By.xpath(".//span");
	
	public int noOfOperators() {
		return tableRows.size()-1;
	}
	
	public ArrayList<String> findOperatorsForTechnicalSupport() {
		ArrayList<String> operatorName=new ArrayList<String>();
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("For")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(operatorCol);
					if(rowsCols.get(j).getText().contains("Technical")) {
						operatorName.add(rowsCols.get(1).getText());
					}
				}
			}
			if(operatorName.size()>0) {
				break;
			}
		}
		return operatorName;
	}
	
	public ArrayList<String> findOperatorsAvailableOnWhatapp_Phone_Sms_Email() {
		ArrayList<String> operatorName=new ArrayList<String>();
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("Prefered Way to Connect")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(operatorCol);
					List<WebElement> waysToConnect=rowsCols.get(j).findElements(wayToConnectOperator);
					if(waysToConnect.size()==4) {
						operatorName.add(rowsCols.get(1).getText());
					}
				}
			}
			if(operatorName.size()>0) {
				break;
			}
		}
		return operatorName;
	}
	
	public ArrayList<String> findOperatorsAvailableOnDaysOrTime(String DaysOrTime) {
		ArrayList<String> operatorName=new ArrayList<String>();
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("Timings")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(operatorCol);
					if(rowsCols.get(j).getText().contains(DaysOrTime)) {
						operatorName.add(rowsCols.get(1).getText());
					}
				}
			}
			if(operatorName.size()>0) {
				break;
			}
		}
		return operatorName;
	}
	
	
}
