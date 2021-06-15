package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourShoppingCart {
	WebDriver driver;
	WebElement qtyFieldOfPrintedDressColorfulDress;
	WebElement qtyFieldOfPrintedDressShortDress;
	WebElement removeProductPrintedDressColorfulDress;
	WebElement printedDressColorfulDressProduct;
	WebElement printedSummerDressMaxiDress;
	WebElement printedSummerDressShortDress;
	WebElement printedChiffonDress;
	WebElement numberInCart;
	
	public YourShoppingCart(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getQtyFieldOfPrintedDressColorfulDress() {
		 return driver.findElement(By.name("quantity_3_13_0_520388"));
	}
	public String valueOfQtyOfPrintedDressColorfulDress() {
		String valueInQuanitityField=getQtyFieldOfPrintedDressColorfulDress().getAttribute("value");
		return valueInQuanitityField;
	}
	public WebElement getQtyFieldOfPrintedDressShortDress(){
		return driver.findElement(By.name("quantity_4_16_0_520388"));
	}
	public String valueOfQtyOfPrintedDressShortDress() {
		String valueInQuanitityField=getQtyFieldOfPrintedDressShortDress().getAttribute("value");
		return valueInQuanitityField;
	}
	public WebElement getRemoveProductPrintedDressColorfulDress() {
		return driver.findElement(By.id("3_13_0_520388"));
	}
	public void removeProductPrintedDressColorfulDressClick() {
		getRemoveProductPrintedDressColorfulDress().click();
	}
	public WebElement getPrintedDressColorfulDressProduct() {
		return printedDressColorfulDressProduct;
	}
	public boolean isPrintedDressColorfulDressProductInTheCart() {
		boolean present;
		try {
			getPrintedDressColorfulDressProduct().getText();
			present= false;	
		} catch (Exception e) {
			present= true;
		}
		return present;
	}
	public WebElement getNumberInCart() {
		return driver.findElement(By.className("ajax_cart_quantity"));
	}
	public int valueOfNumberInCart() {
		int valueOfCartInt;
		String valueInNumberInCartText=getNumberInCart().getText();
		if(valueInNumberInCartText.equals("")) {
			valueOfCartInt=0;
		}else {
			valueOfCartInt=Integer.valueOf(valueInNumberInCartText);
		}
		return valueOfCartInt;
	}
}
