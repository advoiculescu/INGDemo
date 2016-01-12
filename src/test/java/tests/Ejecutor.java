package tests;

import browser.Browser;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.*;
import pages.Index;
import pages.Simulador;

import static org.junit.Assert.*;

public class Ejecutor {
	
	Index index;
	Simulador simulador;
	
	@Before
	public void setUp(){
		System.out.println("\t\t--------------------------------------------INICIO DEL TEST--------------------------------------------");
	}	
	
	@Dado("^que accedemos a la pagina de ING Direct a traves de Chrome$")
	public void que_accedemos_a_la_pagina_de_ING_Direct_a_traves_de_Chrome() throws Throwable {
		Browser.startDriver("Chrome");
		index = new Index();
		index.load();
		index.isLoaded();
	}

	@Dado("^que accedemos a la pagina de ING Direct a traves de Mozilla Firefox$")
	public void que_accedemos_a_la_pagina_de_ING_Direct_a_traves_de_Mozilla_Firefox() throws Throwable {
		Browser.startDriver("Mozilla Firefox");
		index = new Index();
		index.load();
		index.isLoaded();
	}
	
	@Cuando("^hacemos click en Hipotecas y Prestamos$")
	public void hacemos_click_en_Hipotecas_y_Prestamos() throws Throwable {
		index.clickHipotecasYPrestamos();
	}

	@Entonces("^aparace un submenu con la opcion Hipoteca Naranja$")
	public void aparace_un_submenu_con_la_opcion_Hipoteca_Naranja() throws Throwable {
		assertTrue(index.verifyHipotecaNaranja());	
	}

	@Dado("^que el submenu con la opcion Hipoteca Naranja esta visible$")
	public void que_el_submenu_con_la_opcion_Hipoteca_Naranja_esta_visible() throws Throwable {
		assertTrue(index.verifyHipotecaNaranja());
	}

	@Cuando("^hacemos click en Hipotecas Naranja$")
	public void hacemos_click_en_Hipotecas_Naranja() throws Throwable {
		index.clickHipotecaNaranja();
	}

	@Entonces("^la pagina del simulador de la hipoteca naranja se cargara$")
	public void la_pagina_del_simulador_de_la_hipoteca_naranja_se_cargara() throws Throwable {
		simulador = new Simulador();
		simulador.isLoaded();
	}

	@Dado("^que estamos en la pagina del simulador$")
	public void que_estamos_en_la_pagina_del_simulador() throws Throwable {
		simulador.isLoaded();
	}

	@Cuando("^introducimos datos del cliente en el simulador$")
	public void introducimos_datos_del_cliente_en_el_simulador() throws Throwable {
		//simulador.clickRadioClienteSi(); // cliente de ing: SI/NO
		simulador.clickRadioClienteNo();
		// titulares: uno/dos+
		simulador.setIngresosMensuales(3000); // ingresos mensuales
		simulador.setGastosMensuales(0);// gastos de otros préstamos
		simulador.setEdadMayorTitular(55);// edad del mayor titular
	}

	@Cuando("^hacemos click en Comenzar a Simular$")
	public void hacemos_click_en_Comenzar_a_Simular() throws Throwable {
	    simulador.clickComienzaASimular();
	}

	@Entonces("^el cuadro '¿Cual es la finalidad de la hipoteca\\?' cargara$")
	public void el_cuadro_Cual_es_la_finalidad_de_la_hipoteca_cargara() throws Throwable {
		assertTrue(simulador.verifyFinalidadHipoteca());
	}

	@Dado("^que el cuadro de '¿Cual es la finalidad de la hipoteca\\?' esta cargado$")
	public void que_el_cuadro_de_Cual_es_la_finalidad_de_la_hipoteca_esta_cargado() throws Throwable {
		assertTrue(simulador.verifyFinalidadHipoteca());
	}

	/* COMPRAR UNA VIVIENDA / CAMBIAR MI HIPOTECA / HIPOTECAR MI CASA */
	
	@Cuando("^rellenamos los datos obligatorios del cuadro 'Comprar una vivienda'$")
	public void rellenamos_los_datos_obligatorios_del_cuadro_Comprar_una_vivienda() throws Throwable {
		simulador.setValorViviendaAHipotecar(80000);// Primera / Segunda vivienda
		// Introducimos importe
	}

	@Cuando("^hacemos click en continuar$")
	public void hacemos_click_en_continuar() throws Throwable {
	    simulador.clickContinuar();
	}

	@Entonces("^un cuadro con el resultado de la simulación aparece$")
	public void un_cuadro_con_el_resultado_de_la_simulación_aparece() throws Throwable {
		assertTrue(simulador.verifyDatosHipoteca());
	}

	@Entonces("^el cuadro 'Compare nuestras hipotecas aparece'$")
	public void el_cuadro_Compare_nuestras_hipotecas_aparece() throws Throwable {
		assertTrue(simulador.verifyCompareHipotecas());
	}

	@Dado("^que estamos en la página de comprarar las hipotecas$")
	public void que_estamos_en_la_página_de_comprarar_las_hipotecas() throws Throwable {
		assertTrue(simulador.verifyCompareHipotecas());
	}

	@Dado("^que se ha fijado ya el dinero a necesitar junto a los anhos para pagar$")
	public void que_se_ha_fijado_ya_el_dinero_a_necesitar_junto_a_los_anhos_para_pagar() throws Throwable {
	    // TODO
	}

	@Cuando("^elegimos la hipoteca naranja$")
	public void elegimos_la_hipoteca_naranja() throws Throwable {
	    simulador.clickHipotecaNaranja();
	}

	@Entonces("^se muestra la pagina para contratar la hipoteca Naranja$")
	public void se_muestra_la_pagina_para_contratar_la_hipoteca_Naranja() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que estamos en la página de contratar hipoteca naranja$")
	public void que_estamos_en_la_página_de_contratar_hipoteca_naranja() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^rellenamos los datos del titular$")
	public void rellenamos_los_datos_del_titular() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^pulsamos el botón de continuar$")
	public void pulsamos_el_botón_de_continuar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^se accede a los datos personales del titular$")
	public void se_accede_a_los_datos_personales_del_titular() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que estamos en la página de relleno de los datos del titular$")
	public void que_estamos_en_la_página_de_relleno_de_los_datos_del_titular() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^se está en el paso (\\d+) de (\\d+)$")
	public void se_está_en_el_paso_de(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^rellenamos todas las cajas de texto sobre los datos personales$")
	public void rellenamos_todas_las_cajas_de_texto_sobre_los_datos_personales() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^la página se desplaza hacia abajo y muestra los datos de contacto$")
	public void la_página_se_desplaza_hacia_abajo_y_muestra_los_datos_de_contacto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que se tienen en pantalla los campos de datos de contacto$")
	public void que_se_tienen_en_pantalla_los_campos_de_datos_de_contacto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^se rellenan todas las cajas obligatorias con los datos del contacto$")
	public void se_rellenan_todas_las_cajas_obligatorias_con_los_datos_del_contacto() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^se pulsa el botón de continuar$")
	public void se_pulsa_el_botón_de_continuar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^se muestra la información sobre los datos económicos$")
	public void se_muestra_la_información_sobre_los_datos_económicos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que se ven los datos económicos$")
	public void que_se_ven_los_datos_económicos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^se rellenar estos datos economicos$")
	public void se_rellenar_estos_datos_economicos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^se pulsa el botón de continuar tras introducir datos económicos$")
	public void se_pulsa_el_botón_de_continuar_tras_introducir_datos_económicos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^se desplaza la pantalla hacia abajo mostrando los datos de la vivienda a hipotecar$")
	public void se_desplaza_la_pantalla_hacia_abajo_mostrando_los_datos_de_la_vivienda_a_hipotecar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que se está en la pantalla de datos de la vivienda$")
	public void que_se_está_en_la_pantalla_de_datos_de_la_vivienda() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^se rellenar los datos de la vivienda$")
	public void se_rellenar_los_datos_de_la_vivienda() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^se analiza la solicitud$")
	public void se_analiza_la_solicitud() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^se obtiene el mensaje de \"([^\"]*)\"$")
	public void se_obtiene_el_mensaje_de(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Entonces("^cerramos instancia de navegador$")
	public void cerramos_instancia_de_navegador() throws Throwable {
	    Browser.close();
	}
	
	@After
	public void tearDown(){
		System.out.println("\t\t--------------------------------------------FIN DEL TEST--------------------------------------------");
	}
}
