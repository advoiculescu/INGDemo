package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import pages.Index;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(value = Parameterized.class)
public class SimularHipotecaNaranjaTest {

	String articleTitle;
	String articleText;
	StringBuffer verificationErrors = new StringBuffer();

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection testData() throws IOException {
		return getTestData("data\\TestData\\SimularHipotecaNaranjaTest.csv");
	}

	// Add the constructor which maps the instance variables with the test data
	public SimularHipotecaNaranjaTest() {
	}

	public static Collection<String[]> getTestData(String fileName) throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		return records;
	}
	
	@Before
	public void setUp(){
		System.out.println("\t\t--------------------------------------------INICIO DEL TEST--------------------------------------------");
	}

	@Test
	public void newArticleTest() {
		try {
			// Instanciamos la página de bienvenida de ING
			Index index = new Index();
			
			// Instanciamos el navegador 
			index.load();
			
			// Comprobamos que la página ha cargado
			index.isLoaded();
			
			// Hacemos click en 'Hipotecas y Préstamos'
			index.clickHipotecasYPrestamos();
			
			//
			
			//TODO Codigo


		} catch (Exception ex1) {
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				fail(verificationErrorString);
			}
			ex1.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		System.out.println("\t\t--------------------------------------------FIN DEL TEST--------------------------------------------");
	}
}