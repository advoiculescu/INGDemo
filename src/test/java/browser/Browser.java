package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Browser {
	private static WebDriver driver;
	
	public static void startDriver(String driverType) {
		System.out.print("Arrancando "+driverType+"...");
		if (driverType.equals("") || driverType.equals("Mozilla Firefox")) {
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile ffprofile = profile.getProfile("default");
			driver = new FirefoxDriver(ffprofile);
		//	driver = new FirefoxDriver();
		} else if (driverType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new WebDriverException(
			        " Broser not found. Please use one of the available browsers.");
			}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public static WebDriver driver() {
		return driver;
	}

	public static void open(String url) {
		driver.get(url);
	}

	public static void close() {
		//driver.close();
		driver.quit();
	}
}
