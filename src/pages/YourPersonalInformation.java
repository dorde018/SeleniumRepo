package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class YourPersonalInformation {
	WebDriver driver;
	WebElement socialTitleMrField;
	WebElement socialTitleMrsField;
	WebElement firstName;
	WebElement lastName;
	WebElement eMail;
	WebElement currentPassword;
	WebElement newPassword;
	WebElement confirmationPassword;
	WebElement receiveSpecialOffersCheckBox;
	WebElement saveButton;
	WebElement textInTheGreenFieldAfterEditingPersonaInformation;
	
	public YourPersonalInformation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getSocialTitleMrField() {
		return driver.findElement(By.id("id_gender1"));
	}
	public void markMrSocialTitle() {
		getSocialTitleMrField().click();
	}
	public WebElement getSocialTitleMrsField() {
		return driver.findElement(By.id("id_gender2"));
	}
	public void markMrsSocialTitle() {
		getSocialTitleMrsField().click();
	}	
	public WebElement getFirstName() {
		return driver.findElement(By.id("firstname"));
	}
	public void insertFirstName(String firstName) {
		getFirstName().clear();
		getFirstName().sendKeys(firstName);
	}
	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}
	public void insertLastName(String lastName) {
		getLastName().clear();
		getLastName().sendKeys(lastName);
	}
	public WebElement geteMail() {
		return driver.findElement(By.id("email"));
	}
	public void insertEmail(String eMail) {
		geteMail().clear();
		geteMail().sendKeys(eMail);
	}
	public WebElement getCurrentPassword() {
		return driver.findElement(By.id("old_passwd"));
	}
	public void inserCurrentPassword(String currentPassword) {
		getCurrentPassword().sendKeys(currentPassword);
	}
	public WebElement getNewPassword() {
		return driver.findElement(By.id("passwd"));
	}
	public void insertNewPassword(String newPassword) {
		getNewPassword().sendKeys(newPassword);
	}
	public WebElement getConfirmationPassword() {
		return driver.findElement(By.id("confirmation"));
	}
	public void insertConfirmationPassword(String confirmationPassword) {
		getConfirmationPassword().sendKeys(confirmationPassword);
	}
	public WebElement getReceiveSpecialOffersCheckBox() {
		return driver.findElement(By.id("uniform-optin"));
	}
	public void markReceiveSpecialOffersCheckBox() {
		getReceiveSpecialOffersCheckBox().click();
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}
	public void saveButtonClick() {
		getSaveButton().click();
	}
	public void selectDay19() {
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue("19");
	}
	public void selectMonthOctober() {
		Select month = new Select (driver.findElement(By.id("months")));
		month.selectByValue("10");
	}
	public void selectYear1990() {
		Select year = new Select (driver.findElement(By.id("years")));
		year.selectByValue("1990");
	}
	public WebElement getTextInTheGreenFieldAfterEditingPersonaInformation() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}
	public String  textInTheGreenFieldAfterEditingPersonaInformation() {
		return getTextInTheGreenFieldAfterEditingPersonaInformation().getText();
	}
}
