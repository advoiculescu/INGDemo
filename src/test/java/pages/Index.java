package pages;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

import browser.*;

public class Index {
	private String url = "http://www.ingdirect.es/";
	private  String title = "ING DIRECT, banco online sin comisiones - People in Progress";
	private ObjectMap map;

	public Index() {
		map = new ObjectMap("data\\PageObjects\\Index.properties");
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
		Browser.open(url);
	}

	public void isLoaded() {
		assertTrue(Browser.driver().getTitle().equals(title));
	}
	
	public void clickHipotecasYPrestamos() throws Exception{
		System.out.print("Click en 'Hipotecas y Préstamos'...");
		WebElement hipotecasYPrestamos = Browser.driver().findElement(map.getLocator("hipotecasYPrestamos"));
		hipotecasYPrestamos.click();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public boolean verifyHipotecaNaranja() throws Exception{
		System.out.print("Validamos enlace 'Hipoteca NARANJA'...");
		WebElement hipotecaNaranja = Browser.driver().findElement(map.getLocator("hipotecaNARANJA"));
		if (hipotecaNaranja.isDisplayed()){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}	
	}
	
	public void clickHipotecaNaranja() throws Exception{
		System.out.print("Click en 'Hipoteca NARANJA'...");
		WebElement hipotecaNaranja = Browser.driver().findElement(map.getLocator("hipotecaNARANJA"));
		hipotecaNaranja.click();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
