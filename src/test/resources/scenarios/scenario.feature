# language: es

@Run
  Característica: Solicitud Hipoteca Naranja
  Este escenario reproducirá una acción real en ING que consistirá en contratar una hipoteca
  

  Esquema del escenario: Solicitud correcta
	Dado que accedemos a la pagina de ING Direct a traves de <navegador>
	Cuando hacemos click en Hipotecas y Prestamos
	Entonces aparace un submenu con la opcion Hipoteca Naranja
	
	Dado que el submenu con la opcion Hipoteca Naranja esta visible
	Cuando hacemos click en Hipotecas Naranja
	Entonces la pagina del simulador de la hipoteca naranja se cargara
	
	Dado que estamos en la pagina del simulador
	Cuando introducimos datos del cliente en el simulador
	Y hacemos click en Comenzar a Simular 
	Entonces el cuadro '¿Cual es la finalidad de la hipoteca?' cargara
	
	Dado que estamos en la pagina del simulador 
	Y que el cuadro de '¿Cual es la finalidad de la hipoteca?' esta cargado
	Cuando rellenamos los datos obligatorios del cuadro 'Comprar una vivienda'
	Y hacemos click en continuar
	Entonces un cuadro con el resultado de la simulación aparece
	Y el cuadro 'Compare nuestras hipotecas aparece'
	
	Dado que estamos en la página de comprarar las hipotecas
	Y que se ha fijado ya el dinero a necesitar junto a los anhos para pagar
	Cuando elegimos la hipoteca naranja
	Entonces se muestra la pagina para contratar la hipoteca Naranja
	
	Dado que estamos en la página de contratar hipoteca naranja
	Cuando rellenamos los datos del titular
	Y pulsamos el botón de continuar
	Entonces se accede a formulario de datos personales del titular
	
	Dado se está en el paso 1 de 4
	Y que se tienen en pantalla los campos de datos personales del titular
	Cuando rellenamos todas las cajas de texto sobre los datos personales
	Y pulsamos el botón de continuar a los datos de contacto
	Entonces la página se desplaza hacia abajo y muestra los datos de contacto
	
	Dado se está en el paso 2 de 4
	Y que se tienen en pantalla los campos de datos de contacto
	Cuando se rellenan todas las cajas obligatorias con los datos del contacto
	Y se pulsa el botón de continuar
	Entonces se muestra la información sobre los datos económicos
	
	Dado se está en el paso 3 de 4
	Y que se tienen en pantalla los campos de datos económicos
	Cuando rellenamos todos los datos economicos 
	Y se pulsa el botón de continuar tras introducir datos económicos
	Entonces se desplaza la pantalla hacia abajo mostrando los datos de la vivienda a hipotecar
	
	Dado se está en el paso 4 de 4
	Y que se está en la pantalla de datos de la vivienda
	Cuando se rellenar los datos de la vivienda
	Entonces se analiza la solicitud
	Y se obtiene el mensaje de "La Solicitud de su Hipoteca NARANJA es en principio viable."
	Y cerramos instancia de navegador
	
Ejemplos:
	| navegador |
#	| Chrome |
	| Mozilla Firefox   |