package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditPersonalInfomationTests extends BaseTest {
	@BeforeMethod
	public void beforeEachTest() {
		driver.navigate().to(signInURL);
		driver.manage().window().maximize();
		String eMail = excelReader.getStringData("TSu1", 6, 2);
		loginPage.insertEmail(eMail);
		String password = excelReader.getStringData("TSu1", 7, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
	}
	@Test (priority=0)
	public void verifyThatUserCanEditPerfonalInformation() {
		
		myAccountPage.myPeronalInformationTabClick();
		yourPersonalInformationPage.markMrsSocialTitle();
		String firstName = excelReader.getStringData("TSu3", 8, 2);
		yourPersonalInformationPage.insertFirstName(firstName);
		String lastName = excelReader.getStringData("TSu3", 10, 2);
		yourPersonalInformationPage.insertLastName(lastName);
		String eMail = excelReader.getStringData("TSu3", 12, 2);
		yourPersonalInformationPage.insertEmail(eMail);
		yourPersonalInformationPage.selectDay19();
		yourPersonalInformationPage.selectMonthOctober();
		yourPersonalInformationPage.selectYear1990();
		String currentPassword = excelReader.getStringData("TSu3", 16, 2);
		yourPersonalInformationPage.inserCurrentPassword(currentPassword);
		String newPassword = excelReader.getStringData("TSu3", 17, 2);
		yourPersonalInformationPage.insertNewPassword(newPassword);
		String confirmationPassword = excelReader.getStringData("TSu3", 18, 2);
		yourPersonalInformationPage.insertConfirmationPassword(confirmationPassword);
		yourPersonalInformationPage.markReceiveSpecialOffersCheckBox();
		yourPersonalInformationPage.saveButtonClick();
		String actualResult = yourPersonalInformationPage.textInTheGreenFieldAfterEditingPersonaInformation();
		String expectedResult = excelReader.getStringData("TSu3", 23, 2);
		assertEquals(actualResult, expectedResult);
		
	}
	
	@AfterMethod
	public void afterEachTest() {		
		myAccountPage.signOutButtonClick();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
