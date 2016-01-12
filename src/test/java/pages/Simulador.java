package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.*;

import browser.*;

public class Simulador {
	private String url = "http://www.ingdirect.es/hipotecas/simulador/";
	private  String title = "Simulador Hipoteca NARANJA - ING DIRECT";
	private ObjectMap map;

	public Simulador() {
		map = new ObjectMap("data\\PageObjects\\Simulador.properties");
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
	
	public void clickRadioClienteSi() throws Exception{
		System.out.print("Click en 'Sí' (¿Ya eres cliente de ING DIRECT?)...");
		Browser.driver().switchTo().frame("transactional");
		WebElement radioClienteSi = Browser.driver().findElement(map.getLocator("radioClienteSi"));
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(map.getLocator("radioClienteSi")));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", radioClienteSi);
		Thread.sleep(500);
		radioClienteSi.click();
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickRadioClienteNo() throws Exception{
		System.out.print("Click en 'No' (¿Ya eres cliente de ING DIRECT?)...");
		Browser.driver().switchTo().frame("transactional");
		WebElement radioClienteNo = Browser.driver().findElement(map.getLocator("radioClienteNo"));
		WebDriverWait wait = new WebDriverWait(Browser.driver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(map.getLocator("radioClienteNo")));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", radioClienteNo);
		Thread.sleep(500);
		radioClienteNo.click();
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setIngresosMensuales(int euros) throws Exception{
		System.out.print("Introduciendo "+euros+" en Ingresos Mensuales...");
		Browser.driver().switchTo().frame("transactional");
		WebElement ingresosMensuales = Browser.driver().findElement(map.getLocator("ingresosMensuales"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", ingresosMensuales);
		Thread.sleep(500);
		ingresosMensuales.sendKeys(Integer.toString(euros));
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setGastosMensuales(int euros) throws Exception{
		System.out.print("Introduciendo "+euros+" en Gastos Mensuales...");
		Browser.driver().switchTo().frame("transactional");
		WebElement gastosMensuales = Browser.driver().findElement(map.getLocator("gastosMensuales"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", gastosMensuales);
		Thread.sleep(500);
		gastosMensuales.sendKeys(Integer.toString(euros));
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setEdadMayorTitular(int años) throws Exception{
		System.out.print("Introduciendo "+años+" en Ingresos Mensuales...");
		Browser.driver().switchTo().frame("transactional");
		WebElement edadMayorTitular = Browser.driver().findElement(map.getLocator("edadMayorTitular"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", edadMayorTitular);
		Thread.sleep(500);
		edadMayorTitular.sendKeys(Integer.toString(años));
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickComienzaASimular() throws Exception{
		System.out.print("Click en 'Comienza a simular'...");
		Browser.driver().switchTo().frame("transactional");
		WebElement comienzaASimular = Browser.driver().findElement(map.getLocator("comienzaASimular"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", comienzaASimular);
		Thread.sleep(500);
		if(comienzaASimular.isEnabled()){
			comienzaASimular.click();        
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		} 
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public boolean verifyFinalidadHipoteca() throws Exception{
		System.out.print("Validamos cuadro '¿Cuál es la finalidad de la hipoteca?'...");
		Browser.driver().switchTo().frame("transactional");
		WebElement finalidadHipoteca = (new WebDriverWait(Browser.driver(), 5))
			    .until(new ExpectedCondition<WebElement>(){
			        public WebElement apply(WebDriver d) {
							try {
								WebElement contenedorFinalidadHipoteca = d.findElement(map.getLocator("contenedorFinalidadHipoteca"));
								return contenedorFinalidadHipoteca.findElement(map.getLocator("finalidadHipoteca"));
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}				
					}});
		if (finalidadHipoteca.isDisplayed()){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			Browser.driver().switchTo().defaultContent();
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			Browser.driver().switchTo().defaultContent();
			return false;
		}	
	}
	
	public void setValorViviendaAHipotecar(int euros) throws Exception{
		System.out.print("Introduciendo "+euros+" en Valor Viviendo a Hipotecar...");
		Browser.driver().switchTo().frame("transactional");
		WebElement valorViviendaAHipotecar = Browser.driver().findElement(map.getLocator("valorViviendaAHipotecar"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", valorViviendaAHipotecar);
		Thread.sleep(500);
		valorViviendaAHipotecar.sendKeys(Integer.toString(euros));
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void clickContinuar() throws Exception{
		System.out.print("Click en 'Continuar'...");
		Browser.driver().switchTo().frame("transactional");
		WebElement botonContinuar = Browser.driver().findElement(map.getLocator("botonContinuar"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", botonContinuar);
		Thread.sleep(500);
		if(botonContinuar.isEnabled()){
			botonContinuar.click();        
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		} 
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public boolean verifyDatosHipoteca() throws Exception{
		System.out.print("Validamos cuadro datos de la hipoteca");
		Browser.driver().switchTo().frame("transactional");
		WebElement datosHipoteca = (new WebDriverWait(Browser.driver(), 5))
			    .until(new ExpectedCondition<WebElement>(){
			        public WebElement apply(WebDriver d) {
							try {
								return d.findElement(map.getLocator("datosHipoteca"));
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}				
					}});
		if (datosHipoteca.isDisplayed()){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			Browser.driver().switchTo().defaultContent();
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			Browser.driver().switchTo().defaultContent();
			return false;
		}	
	}
	
	public boolean verifyCompareHipotecas() throws Exception{
		System.out.print("Validamos el cuadro 'Compare nuestras hipotecas'");
		Browser.driver().switchTo().frame("transactional");
		WebElement compareHipotecas = (new WebDriverWait(Browser.driver(), 5))
			    .until(new ExpectedCondition<WebElement>(){
			        public WebElement apply(WebDriver d) {
							try {
								return d.findElement(map.getLocator("compareHipotecas"));
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}				
					}});
		if (compareHipotecas.isDisplayed()){
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			Browser.driver().switchTo().defaultContent();
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			Browser.driver().switchTo().defaultContent();
			return false;
		}	
	}
	
	public void clickHipotecaNaranja() throws Exception{
		System.out.print("Click en 'Hipoteca Naranja'...");
		Browser.driver().switchTo().frame("transactional");
		WebElement botonHipotecaNaranja = Browser.driver().findElement(map.getLocator("botonHipotecaNaranja"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", botonHipotecaNaranja);
		Thread.sleep(500);
		if(botonHipotecaNaranja.isEnabled()){
			botonHipotecaNaranja.click();        
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		} 
		Browser.driver().switchTo().defaultContent();
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
}
