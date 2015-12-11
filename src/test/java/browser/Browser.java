package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	private static WebDriver driver;
	
	public static void startDriver(){
		driver = new FirefoxDriver();
	}
	
	public static WebDriver driver() {
		return driver;
	}

	public static void open(String url) {
		driver.get(url);
	}

	public static void close() {
		driver.close();
	}
}
