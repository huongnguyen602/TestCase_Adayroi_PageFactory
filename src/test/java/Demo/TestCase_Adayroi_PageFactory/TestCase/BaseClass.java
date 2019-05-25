package Demo.TestCase_Adayroi_PageFactory.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Demo.TestCase_Adayroi_PageFactory.Manager.DriverManager;
import Demo.TestCase_Adayroi_PageFactory.Manager.DriverType;
import Demo.TestCase_Adayroi_PageFactory.Manager.DrvierManagerFactory;
import Demo.TestCase_Adayroi_PageFactory.Pages.HomePage;
import Demo.TestCase_Adayroi_PageFactory.Pages.SignInPage;

public class BaseClass {
	static WebDriver driver;
	static DriverManager driverManager;

	public static WebDriver getDriver() {
		if (driver == null) {
			driverManager = DrvierManagerFactory.getDrvierManager(DriverType.CHROME);
			driver = driverManager.getWebDriver();
		}
		return driver;
	}

	public static void Login() throws InterruptedException {
		System.out.println("test login-----------");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		HomePage home = new HomePage(driver);
		SignInPage signIn = new SignInPage(driver);

		//home.clickToLogin();
		//signIn.LoginAccount("0981284843", "YutPip");

	}
}
