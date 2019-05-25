package Demo.TestCase_Adayroi_PageFactory.Manager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{
	@Override
	protected void createWebDriver()
	{
		System.setProperty("webdriver.chrome.driver", "..\\drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
}
