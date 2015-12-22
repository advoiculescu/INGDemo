# language: es

@Run
  Característica: Solicitud Hipoteca Naranja

  Esquema del escenario: Solicitud correcta
	Dado que accedemos a la pagina de ING Direct a traves de un "navegador"
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
	
Ejemplos:
	| navegador |
	| Chrome |
	| Mozilla Firefox   |