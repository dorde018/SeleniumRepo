package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateAddressButton;
	WebElement addNewAddressButton;
	WebElement resultAdressUpdatedText;
	WebElement deleteFirstNewAddressButton;
	WebElement resultFirstNewAddressNameText;
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public WebElement getUpdateFirstAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}
	public void updateFirstAddressButtonClick() {
		getUpdateFirstAddressButton().click();
	}
	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}
	public void addNewAddressButtonClick() {
		getAddNewAddressButton().click();
	}
	public WebElement getResultAdressUpdatedText() {
		return driver.findElement(By.cssSelector(".address_address1"));
	}
	public String resultAddressUpdatedText() {
		return getResultAdressUpdatedText().getText();
	}
	public WebElement getDeleteFirstNewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}
	public void deleteFirstNewAddressButtonClick() {
		getDeleteFirstNewAddressButton().click();
		
	}
	public WebElement getResultFirstNewAddressNameText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]"));
	}
	public String resultFirstNewAddressNameText() {
		return getResultFirstNewAddressNameText().getText();
	}
	public boolean firstNewAddressIsDeleted() {
		boolean present;
		 try{
			getDeleteFirstNewAddressButton().isDisplayed();
			present=false;
		} catch (Exception e) {
			present=true;	
	}
		return present;
	}	 
}

