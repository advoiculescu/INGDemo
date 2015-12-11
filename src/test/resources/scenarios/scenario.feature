@Run
Feature: Solicitud Hipoteca Naranja
	Para obtener una Hipoteca Naranja
	Como Persona que no es cliente de ING
	Quiero realizar una solicitud de Hipoteca Naranja

Scenario Outline: Solicitud correcta
	Dado que accedemos a la página de ING Direct a través de un <navegador>
	Cuando hacemos click en Hipotecas y Prestamos
	Entonces aparace un submenú con la opción Hipoteca Naranja
	
	Dado que el submenu con la opción Hipoteca Naranja está visible
	Cuando hacemos click en Hipotecas y Prestamos
	Entonces la pagina del simulador de la hipoteca naranja se cargará
	
	#Hacer click en solicitar 
	Dado que estamos en la pagina del simulador
	Cuando rellenamos los datos obligatorios
	Y hacemos click en Comenzar a Simular 
	#Podemos escribir Pero en vez de Y
	Entonces el cuadro de '¿Cual es la finalidad de la hipoteca?' cargará
	
	# Realizar distintos escenarios en base a la opcion elegida (Comprar una vivienda,Cambiar mi hipoteca, Hipotecar mi casa ...etc)
	Dado que estamos en la página del simulador 
	Y que el cuadro de '¿Cual es la finalidad de la hipoteca?' esta cargado
	Cuando rellenamos los datos obligatorios del cuadro 'Comprar una vivienda' de forma correcta
	Y hacemos click en continuar
	Entonces el cuadro 'Compare nuestras hipotecas aparece'
	
	#INCOMPLETO, FALTA SOLICITAR HIPOTECA NARANJA (Se Abre nueva página y se rellenan varios formularios)
	
Examples:
	| navegador |
	| Chrome |
	| Mozilla Firefox   |