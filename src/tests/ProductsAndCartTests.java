package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsAndCartTests extends BaseTest{
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
	public void addOneProductToTheCart() throws InterruptedException {
		myAccountPage.dressesTabClick();
		int cartValueBeforeAddingProduct = yourShoppingCartPage.valueOfNumberInCart();
		dressesPage.printedDressColorfulDressNameClick();
		dressesPage.addToCartButtonClick();
		dressesPage.proceedToCheckOutButtonClick();
		Thread.sleep(3000);
		int numberOfAddedProducts = excelReader.getIntegerData("TSu5", 13, 2);
		int cartValueAfterAddingProduct = yourShoppingCartPage.valueOfNumberInCart();
		assertEquals(cartValueBeforeAddingProduct+numberOfAddedProducts, cartValueAfterAddingProduct);
	}
	@Test (priority=5)
	public void addTheSameProductInTheCartIfTheQuantityIs3(){
		myAccountPage.dressesTabClick();
		dressesPage.printedDressShortDressNameClick();
		String wantedQuantity = String.valueOf(excelReader.getIntegerData("TSu5", 22, 2));
		dressesPage.insertWantedQuantity(wantedQuantity);
		dressesPage.addToCartButtonClick();
		dressesPage.proceedToCheckOutButtonClick();
		String actualResult = yourShoppingCartPage.valueOfQtyOfPrintedDressShortDress();
		String expectedResult = String.valueOf(excelReader.getIntegerData("TSu5", 28, 2));
		assertEquals(actualResult, expectedResult);
	}
	@Test (priority=10)
	public void removeTheProductFromTheCart() {
		myAccountPage.dressesTabClick();
		dressesPage.printedDressColorfulDressNameClick();
		dressesPage.addToCartButtonClick();
		dressesPage.proceedToCheckOutButtonClick();
		yourShoppingCartPage.removeProductPrintedDressColorfulDressClick();
		boolean actualResult = yourShoppingCartPage.isPrintedDressColorfulDressProductInTheCart();	
		assertTrue(actualResult);
	}
	@Test (priority=15)
	public void add3MultipleProductsInTheCart() {
		myAccountPage.dressesTabClick();
		int cartValueBeforeAddingProduct = yourShoppingCartPage.valueOfNumberInCart();
		dressesPage.addPrintedSummerDressMaxiDressToCart();
		myAccountPage.dressesTabClick();
		dressesPage.addPrintedSummerDressShortDressToCart();
		myAccountPage.dressesTabClick();
		dressesPage.addPrintedChiffonDressToCart();
		myAccountPage.yourShoppingCartTabClick();
		int numberOfAddedProducts = excelReader.getIntegerData("TSu5", 66, 2);
		int cartValueAfterAddingProduct = yourShoppingCartPage.valueOfNumberInCart();
		assertEquals(cartValueBeforeAddingProduct+numberOfAddedProducts, cartValueAfterAddingProduct);
	}
	
	@AfterMethod
	public void afterEachTest() {
		myAccountPage.signOutButtonClick();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
