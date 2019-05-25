package Demo.TestCase_Adayroi_PageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//div[@class ='row']/div[2]/button/div")
	WebElement btnSignIn;
	@FindBy(xpath = "//*[@class = 'header-username']")
	WebElement hover_Account;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}
	
	public void clickToLogin() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(hover_Account).build().perform();
		Thread.sleep(3000);
		btnSignIn.click();
	}
}
