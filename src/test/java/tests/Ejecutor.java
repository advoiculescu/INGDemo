package tests;

import browser.Browser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.es.*;

import static org.junit.Assert.*;

public class Ejecutor {
	
	@Before
	public void setUp(){
		System.out.println("\t\t--------------------------------------------INICIO DEL TEST--------------------------------------------");
	}	
	
	@Dado("^que accedemos a la pagina de ING Direct a traves de un \"([^\"]*)\"$")
	public void que_accedemos_a_la_pagina_de_ING_Direct_a_traves_de_un(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Pasa por el given");
	}
	
	@After
	public void tearDown(){
		System.out.println("\t\t--------------------------------------------FIN DEL TEST--------------------------------------------");
	}
}
