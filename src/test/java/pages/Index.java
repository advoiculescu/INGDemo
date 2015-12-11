package pages;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import browser.*;

public class Index {
	private String url = "http://www.ingdirect.es/";
	private  String title = "ING DIRECT, banco online sin comisiones - People in Progress";
	private ObjectMap map;

	public Index() {
		map = new ObjectMap("data\\PageObjects\\Home.properties");
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void load() {
		Browser.startDriver();
		Browser.open(url);
	}

	public void isLoaded() {
		assertTrue(Browser.driver().getTitle().equals(title));
	}
	
	public void clickHipotecasYPrestamos() throws Exception{
		System.out.print("Filtrando por nombre...");
		WebElement hipotecasYPrestamos = Browser.driver().findElement(map.getLocator("hipotecasYPrestamos"));
		hipotecasYPrestamos.click();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void close() {
		Browser.close();
	}
}
