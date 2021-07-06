package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class WishListTests extends BaseTest {
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
	public void addTheWishList() {
		myAccountPage.myWishListTabClick();
		String baseWishListName = excelReader.getStringData("TSu4", 6, 2);
		myWishListsPage.insertNameOfNewWishList(baseWishListName);
		myWishListsPage.saveButtonClick();
		String actualResult = myWishListsPage.nameOfTheBaseWishListText();
		String expectedResult = excelReader.getStringData("TSu4", 11, 2);
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=5)
	public void removeTheWishList() throws InterruptedException {
		myAccountPage.myWishListTabClick();
		myWishListsPage.deleteBaseWishListButtonClick();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		boolean actualResult = myWishListsPage.baseWishListIsDisplayed();
		assertFalse(actualResult);
	}
	@Test(priority=10)
	public void addMultipleWishLists() {
		myAccountPage.myWishListTabClick();
		for (int i = 22; i <= 26; i+=2) {
			String newWishlistName = excelReader.getStringData("TSu4", i, 2);
			myWishListsPage.insertNameOfNewWishList(newWishlistName);
			myWishListsPage.saveButtonClick();	
		}	
		int expectedResult=excelReader.getIntegerData("TSu4", 30, 2);
		List <WebElement> listOfWishLists = myWishListsPage.getWishListsList();
		int actualResult = listOfWishLists.size();
		assertEquals(actualResult, expectedResult);
	}

	@AfterMethod
	public void afterEachTest() {	
		myAccountPage.signOutButtonClick();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
