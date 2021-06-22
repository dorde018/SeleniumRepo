package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.Dresses;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyWishListsPage;
import pages.YourAddressesNewPage;
import pages.YourAddressesUpdatePage;
import pages.YourPersonalInformation;
import pages.YourShoppingCart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	WebDriver driver;
	WebDriverWait wait;
	ExcelReader excelReader;
	String homeURL;
	String signInURL;
	HomePage homePage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	LoginPage loginPage;
	YourAddressesUpdatePage yourAddressesUpdatePage;
	YourAddressesNewPage yourAddressesNewPage;
	YourPersonalInformation yourPersonalInformationPage;
	MyWishListsPage myWishListsPage;
	Dresses dressesPage;
	YourShoppingCart yourShoppingCartPage;

	
	@BeforeClass
	public void beforeAllTests() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		excelReader =  new ExcelReader("data/Project.xlsx");
		homeURL = excelReader.getStringData("TestElements", 2, 1);
		signInURL= excelReader.getStringData("TestElements", 3, 1);
		homePage = new HomePage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		loginPage = new LoginPage(driver);
		yourAddressesUpdatePage = new YourAddressesUpdatePage(driver);
		yourAddressesNewPage = new YourAddressesNewPage(driver);
		yourPersonalInformationPage = new YourPersonalInformation(driver);
		myWishListsPage = new MyWishListsPage(driver);
		dressesPage= new Dresses(driver);
		yourShoppingCartPage = new YourShoppingCart(driver);

	}
	@AfterClass
	public void afterAllTests() {
		driver.close();
	}
}
