package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.Basepage;

public class Downloadspage extends Basepage {
	
	WebDriver driver;

	public Downloadspage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;	
	}

	@FindBy(xpath = "//tr")
	private List<WebElement> tableRows;

	@FindBy(xpath = "//th")
	private List<WebElement> headerCol;

	private By downloadCol=By.xpath(".//td");
	
	public String checkOrderOfVendor(String vandorName) {
		String vendor=null;
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().equalsIgnoreCase("vendor")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(downloadCol);
					if(rowsCols.get(j).getText().equalsIgnoreCase(vandorName)) {
						List<WebElement> rowsCol=tableRows.get(i-1).findElements(downloadCol);
						vendor=rowsCol.get(j).getText();
						return vendor;
					}
				}
			}
			
			}
		
		return vendor;
	}
	
	
	public int enabledDownloadLinksCount() {
		int count=0;
		ArrayList<String> operatorName=new ArrayList();
		for(int j=0;j<headerCol.size();j++) {
			if(headerCol.get(j).getText().contains("Official Source")) {
				for(int i=1;i<tableRows.size();i++) {
					List<WebElement> rowsCols=tableRows.get(i).findElements(downloadCol);
					if(rowsCols.get(j).isEnabled()) {
						count++;
					}
				}
			}
			}
		
		return count;
	}
	

}
