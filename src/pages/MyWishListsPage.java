package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import tests.ExcelReader;

public class MyWishListsPage {
	WebDriver driver;
	ExcelReader excelReader;
	WebElement nameField;
	WebElement saveButton;
	WebElement nameOfTheBaseWishListText;
	WebElement deleteFirstWishListButton;
	
	public MyWishListsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getNameField() {
		return driver.findElement(By.id("name"));
	}
	public void insertNameOfNewWishList(String newWishListName) {
		getNameField().clear();
		getNameField().sendKeys(newWishListName);	
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	public void saveButtonClick() {
		getSaveButton().click();
	}
	public WebElement getNameOfTheBaseWishListText() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[1]/a"));
	}
	public String nameOfTheBaseWishListText() {
		return getNameOfTheBaseWishListText().getText();
	}
	public WebElement getDeleteBaseWishListButton() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a/i"));
	}
	public void deleteBaseWishListButtonClick() {
		getDeleteBaseWishListButton().click();
	}
	public List<WebElement> getWishListsList(){
		return driver.findElements(By.className("align_center"));	
	}
	public boolean baseWishListIsDisplayed() {
		boolean present;
	try {
		getNameOfTheBaseWishListText().getText();
		present = false;
	} catch (Exception e) {
		present = true;
	}
	return present;
	}
	
}	
