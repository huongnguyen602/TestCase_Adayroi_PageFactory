package Demo.TestCase_Adayroi_PageFactory.Manager;

public class DrvierManagerFactory {
	public static DriverManager getDrvierManager(DriverType type) {
		DriverManager drvierManager = null;
		switch (type) {
		case CHROME:
			drvierManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			drvierManager = new FirefoxDriverManager();
			break;
		default:
			break;
		}
		return drvierManager;
	}
}
