package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dresses{
	WebDriver driver;
	WebElement printedDressColorfulDressName;
	WebElement printedDressShortDressName;
	WebElement addToCartButton;
	WebElement proceedToCheckOutButton;
	WebElement layerCartProductQuantity;
	WebElement quantityWanted;
	WebElement printedSummerDressMaxiDressName;
	WebElement printedSummerDressShortDressName;
	WebElement printedChiffonDressName;
	WebElement continueShoopingButton;
	
	public Dresses(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getPrintedDressColorfulDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/h5/a"));
	}
	public void printedDressColorfulDressNameClick() {
		getPrintedDressColorfulDressName().click();
	}
	public WebElement getPrintedDressShortDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a"));
	}
	public void printedDressShortDressNameClick() {
		getPrintedDressShortDressName().click();
	}
	public WebElement getAddToCartButton() {
		return driver.findElement(By.id("add_to_cart"));
	}
	public void addToCartButtonClick() {
		getAddToCartButton().click();
	}
	public WebElement getProceedToCheckOutButton() {
		return driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span"));
	}
	public void proceedToCheckOutButtonClick() {
		getProceedToCheckOutButton().click();
	}
	public WebElement getQuantityWanted() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	public void insertWantedQuantity(String WantedQuantity) {
		getQuantityWanted().clear();
		getQuantityWanted().sendKeys(WantedQuantity);
	}
	public WebElement getPrintedSummerDressMaxiDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/h5/a"));
	}
	public void printedSummerDressMaxiDressNameClick() {
		getPrintedSummerDressMaxiDressName().click();
	}
	public WebElement getPrintedSummerDressShortDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[4]/div/div[2]/h5/a"));
	}
	public void printedSummerDressShortDressNameClick() {
		getPrintedSummerDressShortDressName().click();
	}
	public WebElement getPrintedChiffonDressName() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[5]/div/div[2]/h5/a"));
	}
	public void printedChiffonDressNameClick() {
		getPrintedChiffonDressName().click();
	}
	
	public WebElement getContinueShoopingButton() {
		return driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span"));	
	}
	public void continueShoppingButtonClick() {
		getContinueShoopingButton().click();
	}
	public void addPrintedSummerDressMaxiDressToCart() {
		printedSummerDressMaxiDressNameClick();
		addToCartButtonClick();
		continueShoppingButtonClick();
	}
	public void addPrintedSummerDressShortDressToCart() {
		printedSummerDressShortDressNameClick();
		addToCartButtonClick();
		continueShoppingButtonClick();
	}
	public void addPrintedChiffonDressToCart() {
		printedChiffonDressNameClick();
		addToCartButtonClick();
		continueShoppingButtonClick();
}
}