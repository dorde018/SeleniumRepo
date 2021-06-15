package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class YourAddressesNewPage {
	WebDriver driver;
	WebElement address1Field;
	WebElement cityField;
	WebElement stateNewYork;
	WebElement zipPostCode;
	WebElement phoneNumber;
	WebElement addressTitle;
	
	public YourAddressesNewPage(WebDriver driver) {
		super();
		this.driver = driver;		
	}
	public WebElement getAddress1Field() {
		return driver.findElement(By.id("address1"));
	}
	public void address1fieldInput(String newAddress) {
		getAddress1Field().sendKeys(newAddress);
	}
	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}
	public void cityFieldInput(String newCity) {
		getCityField().sendKeys(newCity);
	}
	public WebElement getZipPostCode() {
		return driver.findElement(By.id("postcode"));
	}
	public void addNewZipPostCode(String newPostCode) {
		getZipPostCode().sendKeys(newPostCode);
	}
	public WebElement getPhoneNumber() {
		return driver.findElement(By.id("phone"));
	}
	public void addNewPhoneNumber(String newPhoneNumber) {
		getPhoneNumber().sendKeys(newPhoneNumber);
	}
	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}
	public void asignNewAddressTitle(String newAddressTitle) {
		getAddressTitle().clear();
		getAddressTitle().sendKeys(newAddressTitle);
	}
	public void chooseNewYorkState() {
		Select state = new Select (driver.findElement(By.id("id_state")));
		state.selectByValue("32");
	}

}
