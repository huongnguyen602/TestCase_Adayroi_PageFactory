package Demo.TestCase_Adayroi_PageFactory.TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Demo.TestCase_Adayroi_PageFactory.Manager.DriverManager;
import Demo.TestCase_Adayroi_PageFactory.Manager.DriverType;
import Demo.TestCase_Adayroi_PageFactory.Manager.DrvierManagerFactory;
import Demo.TestCase_Adayroi_PageFactory.Pages.HomePage;
import Demo.TestCase_Adayroi_PageFactory.Pages.SignInPage;
import Demo.TestCase_Adayroi_PageFactory.Utiity.ExcelUtils;

public class SignInPage_Test {
	WebDriver driver;
	HomePage home;
	SignInPage signIn;
	//DriverManager driverManager;
	
	@DataProvider(name = "Authentication")
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("..\\TestCase_Adayroi_PageFactory\\TestData\\TestData.xlsx",
				"Sheet1");
		return (testObjArray);
	}
	
	@BeforeTest
	public void setup()
	{
		//driverManager = DrvierManagerFactory.getDrvierManager(DriverType.CHROME);
		//driver = driverManager.getWebDriver();
		driver = BaseClass.getDriver();
		driver.get("https://www.adayroi.com/");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "Authentication")
	public void Testdangnhapthanhcong(String email, String password) throws InterruptedException
	{
		HomePage home = new HomePage(driver);
		SignInPage signIn = new SignInPage(driver);
		home.clickToLogin();
		signIn.LoginAccount(email, password);
	}
}
