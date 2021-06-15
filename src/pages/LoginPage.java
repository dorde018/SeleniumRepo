package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcelReader;

public class LoginPage {
	WebDriver driver;
	ExcelReader excelReader;
	WebElement eMailAddressField;
	WebElement passwordField;
	WebElement submitButton;
	WebElement errorMessageText;

	public LoginPage(WebDriver driver) throws IOException {
		super();
		this.driver = driver;
		excelReader =  new ExcelReader("data/Project.xlsx");
	}
	public WebElement geteMailAddressField() {
		return driver.findElement(By.id("email"));
	}
	public void insertEmail(String eMailAddress) {
		geteMailAddressField().sendKeys(eMailAddress);
	}
	public WebElement getPasswordField() {
		return driver.findElement(By.id("passwd"));
	}
	public void insertPassword(String password) {
		getPasswordField().sendKeys(password);
	}
	public WebElement getSubmitButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	public void submitButtonClick() {
		getSubmitButton().click();
	}
	public WebElement getErrorMessageText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}
	public String errorMessageText() {
		return getErrorMessageText().getText();
	}
	
}
