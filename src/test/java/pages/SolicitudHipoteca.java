package pages;

import static org.junit.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.*;

public class SolicitudHipoteca {
	private String url = "https://ing.ingdirect.es/signups_lending/#prospect-mortgage-request";
	private String title = "";
	private String titleChrome = "https://ing.ingdirect.es/signups_lending/#prospect-mortgage-request";
	private ObjectMap map;

	public SolicitudHipoteca() {
		map = new ObjectMap("data\\PageObjects\\SolicitudHipoteca.properties");
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

	public void isLoaded() throws InterruptedException {
		//ystem.out.println(title+" != "+Browser.driver().getTitle());
		if (Browser.driver() instanceof FirefoxDriver){
			System.out.println("ES UN FIREFOXDRIVER");
			assertTrue(Browser.driver().getTitle().equals(title));

		} else if(Browser.driver() instanceof ChromeDriver){
			System.out.println("ES UN CHROMEDRIVER");
			assertTrue(Browser.driver().getTitle().equals(titleChrome));
		}
		//assertTrue(Browser.driver().getTitle().equals(title));
	}

	public void setDiaNacimiento(int dia) throws Exception {
		System.out.print("Introduciendo " + dia + " en Día Nacimiento...");
		WebElement diaNacimiento = (new WebDriverWait(Browser.driver(), 20)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("diaNacimiento"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		Thread.sleep(500);
		diaNacimiento.sendKeys(Integer.toString(dia));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void setMesNacimiento(int mes) throws Exception {
		System.out.print("Introduciendo " + mes + " en Día Nacimiento...");
		WebElement mesNacimiento = (new WebDriverWait(Browser.driver(), 20)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("mesNacimiento"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		Thread.sleep(500);
		mesNacimiento.sendKeys(Integer.toString(mes));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void setAñoNacimiento(int año) throws Exception {
		System.out.print("Introduciendo " + año + " en Día Nacimiento...");
		WebElement añoNacimiento = (new WebDriverWait(Browser.driver(), 20)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("añoNacimiento"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		Thread.sleep(500);
		añoNacimiento.sendKeys(Integer.toString(año));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void setNumeroIdentificación(String numero) throws Exception {
		System.out.print("Introduciendo " + numero + " en Día Nacimiento...");
		WebElement numeroIdentificacion = (new WebDriverWait(Browser.driver(), 20))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							return d.findElement(map.getLocator("numeroIdentificacion"));
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		Thread.sleep(500);
		numeroIdentificacion.sendKeys(numero);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void clickEliminarSegundoTitular() throws Exception {
		System.out.print("Click en 'Eliminar segundo titular (x)'...");
		WebElement eliminarSegundoTitular = Browser.driver().findElement(map.getLocator("eliminarSegundoTitular"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				eliminarSegundoTitular);
		Thread.sleep(500);
		if (eliminarSegundoTitular.isEnabled()) {
			eliminarSegundoTitular.click();
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void clickScrollAbajo() throws Exception {
		System.out.print("Click en 'Boton scroll abajo (▽)'...");
		WebElement botonScrollAbajo = Browser.driver().findElement(map.getLocator("botonScrollAbajo"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", botonScrollAbajo);
		Thread.sleep(500);
		if (botonScrollAbajo.isEnabled()) {
				botonScrollAbajo.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}

	public void clickContinuar1() throws Exception {
		System.out.print("Click en 'Continuar'...");
		WebElement continuar1 = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("continuar1"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continuar1);
		Thread.sleep(500);
		if (continuar1.isEnabled() && continuar1.isDisplayed()) {
			continuar1.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}
	
	public void clickContinuar2() throws Exception {
		System.out.print("Click en 'Continuar'...");
		WebElement continuar2 = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("continuar2"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continuar2);
		Thread.sleep(500);
		if (continuar2.isEnabled() && continuar2.isDisplayed()) {
			continuar2.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}
	
	public void clickContinuar3() throws Exception {
		System.out.print("Click en 'Continuar'...");
		WebElement continuar3 = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("continuar3"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continuar3);
		Thread.sleep(500);
		if (continuar3.isEnabled() && continuar3.isDisplayed()) {
			continuar3.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}
	
	public void clickContinuar4() throws Exception {
		System.out.print("Click en 'Continuar'...");
		WebElement continuar4 = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("continuar4"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continuar4);
		Thread.sleep(500);
		if (continuar4.isEnabled() && continuar4.isDisplayed()) {
			continuar4.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}
	
	public void clickContinuar5() throws Exception {
		System.out.print("Click en 'Continuar'...");
		WebElement continuar5 = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				try {
					return d.findElement(map.getLocator("continuar5"));
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", continuar5);
		Thread.sleep(500);
		if (continuar5.isEnabled() && continuar5.isDisplayed()) {
			continuar5.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}

	public boolean verifyPaso1de4() throws Exception {
		System.out.print("Validamos el texto 'Datos personales'...");
		WebElement tituloDatosPersonales = (new WebDriverWait(Browser.driver(), 15))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("tituloDatosPersonales")).getText()
									.equals("Datos personales")) {
								return d.findElement(map.getLocator("tituloDatosPersonales"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (tituloDatosPersonales.isDisplayed()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public boolean verifyPaso2de4() throws Exception {
		System.out.print("Validamos el texto 'Datos de contacto'...");
		WebElement tituloDatosContacto = (new WebDriverWait(Browser.driver(), 15))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("tituloDatosContacto")).getText()
									.equals("Datos de contacto")) {
								return d.findElement(map.getLocator("tituloDatosContacto"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (tituloDatosContacto.isDisplayed()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public boolean verifyPaso3de4() throws Exception {
		System.out.print("Validamos el texto 'Datos Económicos'...");
		WebElement tituloDatosEconomicos = (new WebDriverWait(Browser.driver(), 15))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("tituloDatosEconomicos")).getText()
									.equals("Datos económicos")) {
								return d.findElement(map.getLocator("tituloDatosEconomicos"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (tituloDatosEconomicos.isDisplayed()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public boolean verifyPaso4de4() throws Exception {
		System.out.print("Validamos el texto 'Datos de la vivienda a hipotecar'...");
		WebElement tituloDatosVivienda = (new WebDriverWait(Browser.driver(), 15))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("tituloDatosVivienda")).getText()
									.equals("Datos de la vivienda a hipotecar")) {
								return d.findElement(map.getLocator("tituloDatosVivienda"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (tituloDatosVivienda.isDisplayed()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public boolean verifyCampoNombre() throws Exception {
		System.out.print("Validamos carga del campo 'Nombre'...");
		WebElement textfieldNombre = (new WebDriverWait(Browser.driver(), 10))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("textfieldNombre")).isDisplayed()){
								return d.findElement(map.getLocator("textfieldNombre"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (textfieldNombre.isEnabled()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public boolean verifyDireccion() throws Exception {
		System.out.print("Validamos carga del campo 'Direccion'...");
		WebElement textfieldDireccion = (new WebDriverWait(Browser.driver(), 10))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("textfieldDireccion")).isDisplayed()){
								return d.findElement(map.getLocator("textfieldDireccion"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (textfieldDireccion.isEnabled()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}	
	
	public boolean verifyTamañoUnidadFamiliar() throws Exception {
		System.out.print("Validamos carga del campo 'Tamaño Unidad Familiar'...");
		WebElement textfieldTamañoUnidadFamiliar = (new WebDriverWait(Browser.driver(), 10))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("textfieldTamañoUnidadFamiliar")).isDisplayed()){
								return d.findElement(map.getLocator("textfieldTamañoUnidadFamiliar"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (textfieldTamañoUnidadFamiliar.isEnabled()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}

	public void clickSexoMasculino() throws Exception {
		System.out.print("Click en 'Hombre'...");
		WebElement botonSexoMasculino = Browser.driver().findElement(map.getLocator("botonSexoMasculino"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", botonSexoMasculino);
		Thread.sleep(500);
		if (botonSexoMasculino.isDisplayed()) {
			botonSexoMasculino.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}

	public void clickSexoFemenino() throws Exception {
		System.out.print("Click en 'Mujer'...");
		WebElement botonSexoFemenino = Browser.driver().findElement(map.getLocator("botonSexoFemenino"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", botonSexoFemenino);
		Thread.sleep(500);
		if (botonSexoFemenino.isDisplayed()) {
			botonSexoFemenino.click();
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
		}
	}

	public void setNombre(String nombre) throws Exception {
		System.out.print("Introduciendo " + nombre + " en Nombre...");
		WebElement textfieldNombre = Browser.driver().findElement(map.getLocator("textfieldNombre"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);", textfieldNombre);
		Thread.sleep(500);
		textfieldNombre.sendKeys(nombre);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void setPrimerApellido(String apellido) throws Exception {
		System.out.print("Introduciendo " + apellido + " en Primer Apellido...");
		WebElement textfieldPrimerApellido = Browser.driver().findElement(map.getLocator("textfieldPrimerApellido"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldPrimerApellido);
		Thread.sleep(500);
		textfieldPrimerApellido.sendKeys(apellido);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void setSegundoApellido(String apellido) throws Exception {
		System.out.print("Introduciendo " + apellido + " en Segundo Apellido...");
		WebElement textfieldSegundoApellido = Browser.driver().findElement(map.getLocator("textfieldSegundoApellido"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldSegundoApellido);
		Thread.sleep(500);
		textfieldSegundoApellido.sendKeys(apellido);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}

	public void setResidenciaFiscal(String pais) throws Exception {
		System.out.print("Introduciendo " + pais + " en Residencia Fiscal...");
		WebElement residenciaFiscal = Browser.driver().findElement(map.getLocator("residenciaFiscal"));
		residenciaFiscal.click();
		Thread.sleep(500);
		
		if (pais.equalsIgnoreCase("españa")) {
			WebElement residenciaFiscalEspaña = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("residenciaFiscalEspaña"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			residenciaFiscalEspaña.click();
		} else {
			fail("el método setResidenciaFiscal no acepta dicho país, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setDireccion(String direccion) throws Exception {
		System.out.print("Introduciendo " + direccion + " en Direccion...");
		WebElement textfieldDireccion = Browser.driver().findElement(map.getLocator("textfieldDireccion"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldDireccion);
		Thread.sleep(500);
		textfieldDireccion.sendKeys(direccion);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setNumero(String numero) throws Exception {
		System.out.print("Introduciendo " + numero + " en Numero...");
		WebElement textfieldNumero = Browser.driver().findElement(map.getLocator("textfieldNumero"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldNumero);
		Thread.sleep(500);
		textfieldNumero.sendKeys(numero);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setLocalidad(String localidad) throws Exception {
		System.out.print("Introduciendo " + localidad + " en Localidad...");
		WebElement textfieldLocalidad = Browser.driver().findElement(map.getLocator("textfieldLocalidad"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldLocalidad);
		Thread.sleep(500);
		textfieldLocalidad.sendKeys(localidad);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setProvincia(String provincia) throws Exception {
		System.out.print("Introduciendo " + provincia + " en Provincia...");
		WebElement listaProvincias = Browser.driver().findElement(map.getLocator("listaProvincias"));
		listaProvincias.click();
		Thread.sleep(500);
		
		if (provincia.equalsIgnoreCase("Madrid")) {
			WebElement provinciaMadrid = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("provinciaMadrid"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			provinciaMadrid.click();
		} else {
			fail("el método setProvincia no acepta la provincia proporcionada, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setCodigoPostal(int cp) throws Exception {
		System.out.print("Introduciendo " + cp + " en Codigo Postal...");
		WebElement textfieldCodigoPostal = Browser.driver().findElement(map.getLocator("textfieldCodigoPostal"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldCodigoPostal);
		Thread.sleep(500);
		textfieldCodigoPostal.clear();
		textfieldCodigoPostal.sendKeys(Integer.toString(cp));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setEmail(String email) throws Exception {
		System.out.print("Introduciendo " + email + " en E-mail...");
		WebElement textfieldEmail = Browser.driver().findElement(map.getLocator("textfieldEmail"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldEmail);
		Thread.sleep(500);
		textfieldEmail.sendKeys(email);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setTelefonoMovil(int telefono) throws Exception {
		System.out.print("Introduciendo " + telefono + " en E-mail...");
		WebElement textfieldTelefonoMovil = Browser.driver().findElement(map.getLocator("textfieldTelefonoMovil"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldTelefonoMovil);
		Thread.sleep(500);
		if (String.valueOf(telefono).length() > 8){
			textfieldTelefonoMovil.sendKeys(Integer.toString(telefono));
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			fail("El numero introducido tiene 8 o menos dígitos");
		}
	}
	
	public void setTamañoUnidadFamiliar(int unidadFamiliar) throws Exception {
		System.out.print("Introduciendo " + unidadFamiliar + " en Tamaño Unidad Familiar...");
		WebElement textfieldTamañoUnidadFamiliar = Browser.driver().findElement(map.getLocator("textfieldTamañoUnidadFamiliar"));
		((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
				textfieldTamañoUnidadFamiliar);
		Thread.sleep(500);
		textfieldTamañoUnidadFamiliar.sendKeys(Integer.toString(unidadFamiliar));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setEstadoCivil(String estadoCivil) throws Exception {
		System.out.print("Introduciendo " + estadoCivil + " en Estado Civil...");
		WebElement listaEstadoCivil = Browser.driver().findElement(map.getLocator("listaEstadoCivil"));
		listaEstadoCivil.click();
		Thread.sleep(500);
		
		if (estadoCivil.equalsIgnoreCase("soltero")) {
			WebElement estadoCivilSoltero = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("estadoCivilSoltero"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", estadoCivilSoltero);
			//estadoCivilSoltero.click();
		} else {
			fail("el método setEstadoCivil no acepta el estado proporcionado, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setTipoContrato(String tipoContrato) throws Exception {
		System.out.print("Introduciendo " + tipoContrato + " en Tipo de Contrato...");
		WebElement listaTipoContrato = Browser.driver().findElement(map.getLocator("listaTipoContrato"));
		listaTipoContrato.click();
		Thread.sleep(500);
		
		if (tipoContrato.equalsIgnoreCase("otros")) {
			WebElement tipoContratoOtros = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("tipoContratoOtros"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
					tipoContratoOtros);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", tipoContratoOtros);
			//tipoContratoOtros.click();
		} else {
			fail("el método setTipoContrato no acepta el tipo de contrato proporcionado, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setIngresosMensuales(int euros) throws Exception {
		System.out.print("Introduciendo " + euros + " en Ingresos Mensuales...");
		WebElement textfieldIngresosMensuales = Browser.driver().findElement(map.getLocator("textfieldIngresosMensuales"));
		textfieldIngresosMensuales.sendKeys(Integer.toString(euros));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setNumeroPagas(int numPagas) throws Exception {
		System.out.print("Introduciendo " + numPagas + " en Numero de Pagas...");
		WebElement textfieldNumeroPagas = Browser.driver().findElement(map.getLocator("textfieldNumeroPagas"));
		textfieldNumeroPagas.sendKeys(Integer.toString(numPagas));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setTipoActividad(String tipoActividad) throws Exception {
		System.out.print("Introduciendo " + tipoActividad + " en Tipo de Contrato...");
		WebElement listaTipoActividad = Browser.driver().findElement(map.getLocator("listaTipoActividad"));
		listaTipoActividad.click();
		Thread.sleep(500);
		
		if (tipoActividad.equalsIgnoreCase("estudiante")) {
			WebElement tipoActividadEstudiante = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("tipoActividadEstudiante"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
					tipoActividadEstudiante);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", tipoActividadEstudiante);
			//tipoActividadEstudiante.click();
		} else {
			fail("el método setTipoActividad no acepta el tipo de actividad proporcionado, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public boolean verifyLocalidadVivienda() throws Exception {
		System.out.print("Validamos carga del campo 'Localidad'...");
		WebElement textfieldLocalidadVivienda = (new WebDriverWait(Browser.driver(), 10))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("textfieldLocalidadVivienda")).isDisplayed()){
								return d.findElement(map.getLocator("textfieldLocalidadVivienda"));
							} else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (textfieldLocalidadVivienda.isEnabled()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public void setNumeroInmueblesAHipotecar(String inmuebles) throws Exception {
		System.out.print("Introduciendo " + inmuebles + " en Nº Inmuebles a Hipotecar...");
		WebElement listaNumeroInmueblesAHipotecar = Browser.driver().findElement(map.getLocator("listaNumeroInmueblesAHipotecar"));
		listaNumeroInmueblesAHipotecar.click();
		Thread.sleep(500);
		
		if (inmuebles.equalsIgnoreCase("vivienda")) {
			WebElement inmuebleSoloVivienda = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("inmuebleSoloVivienda"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
					inmuebleSoloVivienda);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", inmuebleSoloVivienda);
			//inmuebleSoloVivienda.click();
		} else {
			fail("el método setNumeroInmueblesAHipotecar no acepta el numero de inmuebles proporcionado, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setTipoVivienda(String tipoVivienda) throws Exception {
		System.out.print("Introduciendo " + tipoVivienda + " en Tipo de Vivienda...");
		WebElement listaTipoVivienda = Browser.driver().findElement(map.getLocator("listaTipoVivienda"));
		listaTipoVivienda.click();
		Thread.sleep(500);
		
		if (tipoVivienda.equalsIgnoreCase("piso")) {
			WebElement tipoViviendaPiso = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("tipoViviendaPiso"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
					tipoViviendaPiso);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", tipoViviendaPiso);
			//tipoViviendaPiso.click();
		} else {
			fail("el método setTipoVivienda no acepta el tipo de vivienda proporcionado, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setEstadoVivienda(String estadoVivienda) throws Exception {
		System.out.print("Introduciendo " + estadoVivienda + " en Estado Vivienda...");
		WebElement listaEstadoVivienda = Browser.driver().findElement(map.getLocator("listaEstadoVivienda"));
		listaEstadoVivienda.click();
		Thread.sleep(500);
		
		if (estadoVivienda.equalsIgnoreCase("usada")) {
			WebElement estadoViviendaUsada = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("estadoViviendaUsada"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
					estadoViviendaUsada);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", estadoViviendaUsada);
			//estadoViviendaUsada.click();
		} else {
			fail("el método setEstadoVivienda no acepta el estado de vivienda proporcionado, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setLocalidadVivienda(String localidad) throws Exception {
		System.out.print("Introduciendo " + localidad + " en Localidad Vivienda...");
		WebElement textfieldLocalidadVivienda = Browser.driver().findElement(map.getLocator("textfieldLocalidadVivienda"));
		textfieldLocalidadVivienda.sendKeys(localidad);
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setProvinciaVivienda(String provincia) throws Exception {
		System.out.print("Introduciendo " + provincia + " en Provincia Vivienda...");
		WebElement listaProvinciaVivienda = Browser.driver().findElement(map.getLocator("listaProvinciaVivienda"));
		listaProvinciaVivienda.click();
		Thread.sleep(500);
		
		if (provincia.equalsIgnoreCase("madrid")) {
			WebElement provinciaViviendaMadrid = (new WebDriverWait(Browser.driver(), 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					try {
						return d.findElement(map.getLocator("provinciaViviendaMadrid"));
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			});
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].scrollIntoView(true);",
					provinciaViviendaMadrid);
			Thread.sleep(500);
			((JavascriptExecutor) Browser.driver()).executeScript("arguments[0].click();", provinciaViviendaMadrid);
			//provinciaViviendaMadrid.click();
		} else {
			fail("el método setProvinciaVivienda no acepta la provincia proporcionada, por favor implementelo");
		}
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setCodigoPostalVivienda(int cp) throws Exception {
		System.out.print("Introduciendo " + cp + " en Código Postal...");
		WebElement textfieldCodigoPostalVivienda = Browser.driver().findElement(map.getLocator("textfieldCodigoPostalVivienda"));
		textfieldCodigoPostalVivienda.clear();
		textfieldCodigoPostalVivienda.sendKeys(Integer.toString(cp));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setMetrosConstruidos(int metros) throws Exception {
		System.out.print("Introduciendo " + metros + " en Metros Construidos...");
		WebElement textfieldMetrosConstruidos = Browser.driver().findElement(map.getLocator("textfieldMetrosConstruidos"));
		textfieldMetrosConstruidos.sendKeys(Integer.toString(metros));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setMesPrevistoFirma(int mes) throws Exception {
		System.out.print("Introduciendo " + mes + " en Mes Previsto para Firma...");
		WebElement textfieldMesPrevistoFirma = Browser.driver().findElement(map.getLocator("textfieldMesPrevistoFirma"));
		textfieldMesPrevistoFirma.sendKeys(Integer.toString(mes));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public void setAñoPrevistoFirma(int año) throws Exception {
		System.out.print("Introduciendo " + año + " en Año Previsto para Firma...");
		WebElement textfieldAñoPrevistoFirma = Browser.driver().findElement(map.getLocator("textfieldAñoPrevistoFirma"));
		textfieldAñoPrevistoFirma.sendKeys(Integer.toString(año));
		System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
	}
	
	public boolean verifyAnalizandoSolicitud() throws Exception {
		System.out.print("Validamos el texto 'Analizando Solicitud'...");
		WebElement tituloAnalizandoSolicitud = (new WebDriverWait(Browser.driver(), 15))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							//if (d.findElement(map.getLocator("tituloAnalizandoSolicitud")).getText()
							//		.equals("Analizando solicitud…")) {
								return d.findElement(map.getLocator("tituloAnalizandoSolicitud"));
							//} else {
							//	return null;
							//}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		if (tituloAnalizandoSolicitud.isDisplayed()) {
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return true;
		} else {
			System.out.println("\u001B[31m" + " ERROR" + "\u001B[0m");
			return false;
		}
	}
	
	public String getMensajeSolicitudDenegada() throws Exception {
		System.out.print("Devolviendo el mensaje de denegación...");
		WebElement mensajeSolicitudNoViable = (new WebDriverWait(Browser.driver(), 15))
				.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver d) {
						try {
							if (d.findElement(map.getLocator("mensajeSolicitudNoViable")).isDisplayed()) {
								return d.findElement(map.getLocator("mensajeSolicitudNoViable"));
							}
							else {
								return null;
							}
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
					}
				});
		
			System.out.println("\u001B[32m" + " LISTO" + "\u001B[0m");
			return mensajeSolicitudNoViable.getText();
	}	
}
