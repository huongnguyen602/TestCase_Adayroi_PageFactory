package Demo.TestCase_Adayroi_PageFactory.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@class ='form-control js-site-search-input  ui-autocomplete-input']")
	WebElement txt_search;
	@FindBy(xpath = "//*[@class='polish-version-icon-search' ]")
	WebElement btn_Submitsearch;
	@FindBy(xpath = "//div[@class ='product-list__container']/div/div")
	List<WebElement> listProduct;
	@FindBy(xpath = "//*[@id='addToCartButton']/span")
	WebElement btn_AddToCart;
	@FindBy(xpath = "//*[@class = 'mini-cart-link js-mini-cart-link']")
	WebElement viewCart;
	@FindBy(xpath = "//div[@class = 'cart-submit']")
	WebElement btnexcutePayment;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void SelectProduct(String proName) throws InterruptedException {
		txt_search.sendKeys("Iphone");
		btn_Submitsearch.click();
		for (int i = 0; i < listProduct.size(); i++) {
			if (listProduct.get(i).getText().contains(proName)) {
				listProduct.get(i).click();
				break;
			} else {
			}
		}
		for (String handle1 : driver.getWindowHandles()) {
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		btn_AddToCart.click();
		Thread.sleep(3000);
		viewCart.click();
		btnexcutePayment.click();

	}
}
