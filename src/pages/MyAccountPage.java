package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAddressesTab;
	WebElement loginMYACCOUNTText;
	WebElement myPersonalInformationTab;
	WebElement myWishListTab;
	WebElement dressesTab;
	WebElement yourShoppingCartTab;
	WebElement signOutButton;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getMyAddressesTab() {
		return driver.findElement(By.cssSelector(".icon-building"));
	}
	public void myAddressesTabClick() {		
		getMyAddressesTab().click();
	}
	public WebElement getLoginMYACCOUNTText() {
		return driver.findElement(By.cssSelector(".page-heading"));
	}
	public String loginMYACCOUNTText() {
		return getLoginMYACCOUNTText().getText();
	}
	public WebElement getMyPersonalInformationTab() {
		return driver.findElement(By.cssSelector(".icon-user"));
	}
	public void myPeronalInformationTabClick() {
		getMyPersonalInformationTab().click();
	}
	public WebElement getMyWishListTab() {
		return driver.findElement(By.cssSelector(".icon-heart"));
	}
	public void myWishListTabClick() {
		getMyWishListTab().click();
	}
	public WebElement getDressesTab() {
		return driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
	}
	public void dressesTabClick() {
		getDressesTab().click();
	}
	public WebElement getYourShoppingCartTab() {
		return driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a"));
	}
	public void yourShoppingCartTabClick() {
		getYourShoppingCartTab().click();
	}
	public WebElement getSignOutButton() {
		return driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
	}
	public void signOutButtonClick() {
		getSignOutButton().click();
	}
}
