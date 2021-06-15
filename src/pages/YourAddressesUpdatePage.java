package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesUpdatePage {
	WebDriver driver;
	WebElement address1field;
	WebElement saveButton;
	
	public YourAddressesUpdatePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getAddress1field() {
		return driver.findElement(By.name("address1"));
	}
	public void address1field(String newAddress) {
		getAddress1field().clear();
		getAddress1field().sendKeys(newAddress);
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	public void saveButtonClick() {
		getSaveButton().click();
	}
	
}
