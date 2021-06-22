package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tests.BaseTest;

public class LogInTests extends BaseTest{
	@BeforeMethod
	public void beforeEachTest() {
		driver.navigate().to(homeURL);
		driver.manage().window().maximize();
	}
	@Test (priority=0)
	public void logInWithValidCredentials() {
		homePage.signInButtonClick();
		String eMail = excelReader.getStringData("TSu1", 6, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1", 7, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
		String acutalResult = myAccountPage.loginMYACCOUNTText();
		String expectedResult = excelReader.getStringData("TSu1", 10, 2);
		assertEquals(acutalResult, expectedResult);
	}
	@Test (priority=5)
	public void logInWithInvalidPassword() {
		homePage.signInButtonClick();
		String eMail = excelReader.getStringData("TSu1", 19, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1", 20, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
		String actualResult = loginPage.errorMessageText();
		String expectedResult = excelReader.getStringData("TSu1", 23, 2);
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=10)
	public void wrongEmailAddressFormat() {
		homePage.signInButtonClick();
		String eMail = excelReader.getStringData("TSu1", 32, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1",33, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
		String actualResult = loginPage.errorMessageText();
		String expectedResult = excelReader.getStringData("TSu1", 36, 2);
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=15)
	public void emptyEmailAddressField() {
		homePage.signInButtonClick();
		String eMail = excelReader.getStringData("TSu1", 45, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1", 46, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
		String actualResult = loginPage.errorMessageText();
		String expectedResult = excelReader.getStringData("TSu1", 49, 2);
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=20)
	public void emptyPasswordField() {
		homePage.signInButtonClick();
		String eMail = excelReader.getStringData("TSu1", 58, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1", 59, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
		String actualResult = loginPage.errorMessageText();
		String expectedResult = excelReader.getStringData("TSu1", 62, 2);
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=25)
	public void emptyBothFields() {
		homePage.signInButtonClick();
		String eMail = excelReader.getStringData("TSu1", 71, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1", 72, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
		String actualResult = loginPage.errorMessageText();
		String expectedResult = excelReader.getStringData("TSu1", 76, 2);
		assertEquals(actualResult, expectedResult);
	}
	@AfterMethod
	public void afterEachTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
