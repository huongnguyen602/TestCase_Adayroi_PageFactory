package Demo.TestCase_Adayroi_PageFactory.TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Demo.TestCase_Adayroi_PageFactory.Pages.CartPage;
import Demo.TestCase_Adayroi_PageFactory.Utiity.ExcelUtils;

public class CartPage_Test extends BaseClass{
	WebDriver driver;
	CartPage cart;
	
	@DataProvider(name = "Authentication")
    public Object[][] Authentication() throws Exception{
         Object[][] testObjArray = ExcelUtils.getTableArray("..\\TestCase_Adayroi_PageFactory\\TestData\\TestData.xlsx","Sheet2");
         return (testObjArray);
	}
	@BeforeTest
	public void setup() throws InterruptedException {
		// driverManager = DrvierManagerFactory.getDrvierManager(DriverType.CHROME);
		driver = BaseClass.getDriver();
		driver.get("https://www.adayroi.com/");
		driver.manage().window().maximize();
		BaseClass.Login();
	}
         
	@Test(dataProvider = "Authentication")
	public void testGioHang(String slectedProduct, String productInCart) throws InterruptedException {
		System.out.println("test testGioHang-----------");
		cart = new CartPage(driver);
		cart.SelectProduct(slectedProduct);
	}
}
