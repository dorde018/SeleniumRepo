package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAddressTests extends BaseTest{
	@BeforeMethod
	public void beforeEachTest() {
		driver.navigate().to(signInURL);
		driver.manage().window().maximize();
		String eMail=excelReader.getStringData("TSu1", 6, 2);
		loginPage.insertEmail(eMail);
		String password=excelReader.getStringData("TSu1", 7, 2);
		loginPage.insertPassword(password);
		loginPage.submitButtonClick();
	}
	@Test (priority=0)
	public void updateAddress() {
		myAccountPage.myAddressesTabClick();
		myAddressesPage.updateFirstAddressButtonClick();
		String newAddress=excelReader.getStringData("TSu2", 8, 2);
		yourAddressesUpdatePage.address1field(newAddress);
		yourAddressesUpdatePage.saveButtonClick();
		String actualResult=myAddressesPage.resultAddressUpdatedText();
		String expectedResult=excelReader.getStringData("TSu2", 11, 2);
		assertEquals(actualResult, expectedResult);		
	}
	@Test (priority=5)
	public void addNewAddress() {
		myAccountPage.myAddressesTabClick();
		myAddressesPage.addNewAddressButtonClick();
		String newAddress=excelReader.getStringData("TSu2", 21, 2);
		yourAddressesNewPage.address1fieldInput(newAddress);
		String newCity=excelReader.getStringData("TSu2", 22, 2);
		yourAddressesNewPage.cityFieldInput(newCity);
		yourAddressesNewPage.chooseNewYorkState();
		String newZipPostCode=String.valueOf(excelReader.getIntegerData("TSu2", 24, 2));
		yourAddressesNewPage.addNewZipPostCode(newZipPostCode);
		String newHomePhone=String.valueOf(excelReader.getIntegerData("TSu2", 25, 2));
		yourAddressesNewPage.addNewPhoneNumber(newHomePhone);
		String addressTitle=excelReader.getStringData("TSu2", 26, 2);
		yourAddressesNewPage.asignNewAddressTitle(addressTitle);
		yourAddressesUpdatePage.saveButtonClick();
		String actualResult=myAddressesPage.resultFirstNewAddressNameText();
		String expectedResult=excelReader.getStringData("TSu2", 29, 2);
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=10)
	public void removeAddress() throws InterruptedException {
		myAccountPage.myAddressesTabClick();
		myAddressesPage.deleteFirstNewAddressButtonClick();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		boolean expectedResult=myAddressesPage.firstNewAddressIsDeleted();
		assertTrue(expectedResult);
	}

	
	@AfterMethod
	public void afterEachTest() throws InterruptedException {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
