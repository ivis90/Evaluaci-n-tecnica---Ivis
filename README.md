#Evaluación técnica - Ivis Leydis Rodríguez Cabrera
QA Automation
Para la ejecución del proyecto realicé un estudio del funcionamiento del sitio Despegar.com.ar, principalmente de las funcionalidades Buscar un vuelo y Reservar un hotel; también realicé una evaluación de las tecnologías existentes para pruebas automatizadas seleccionando Eclipse como IDE(Integrated Development Enviroment), Selenium Webdriver con el navegador Chrome, Java como lenguaje de programación, además utilicé las librerías Maven y TestNG.

##Guia 
###Consigna 1
Realizar búsqueda de un vuelo.

###Consigna 2
Realizar búsqueda de un vuelo.
Buscar vuelo mayor precio.

###Consigna 3
Realizar búsqueda de un hotel.
Capturar fechas de entrada y de salida del hotel.
Obtener dia y mes de la fecha de entrada y de salida del hotel.

##Explicación funcional 
###1.Inicializar driver.
Localizar el archivo chromedriver y configurar las propiedades del sistema. 
Inicializar driver.
Maximizar la página.

###2. Realizar búsqueda de un vuelo.
Ir a la url deseada.
Cerrar Popup.
Seleccionar la pestaña Vuelos.
Limpiar el campo origen que carga por defecto el sitio.
Escribir las tres primeras letras del origen deseado.
Esperar que aparezca las lista de aeropuertos que contengan esas letras.
Seleccionar de la lista el aeropuerto deseado de origen.
Escribir las tres primeras letras del destino deseado.
Esperar que aparezca las lista de aeropuertos que contengan con esas letras.
Seleccionar de la lista el aeropuerto deseado de destino.
Seleccionar fecha de ida.
Seleccionar fecha de regreso.
Hacer click en Buscar.
Validar que la página de los vuelos correspondiente sea la búsqueda.

###3. Realizar búsqueda de un hotel
Seleccionar la pestaña Hoteles.
Escribir las tres primeras letras del destino deseado.
Esperar que aparezca las lista de ciudades que contengan esas letras.
Seleccionar de la lista de ciudades la ciudad destino deseada.
Seleccionar la fecha de entrada.
Seleccionar la fecha de salida.
Seleccionar 1 habitación con dos adultos y un menor de 12 años.
Hacer click en Buscar.
Esperar la página de hoteles disponibles según los datos deseados.
Filtrar los hoteles 5 estrellas.
Seleccionar el hotel de menor precio.
Hacer click para ver detalles del hotel.
Validar que abra una nueva pestaña con los detalles del hotel.
Validar la visibilidad de la sección habitaciones disponibles.

###4. Capturar fechas de entrada y salidas del hotel.
Obtener fecha actual del sistema.
Crear una fecha de entrada que sea la fecha actual del sistema más 10 días.
Crear una fecha de salida que sea la fecha de entrada más 3 días.

###5. Obtener dia y mes de la fecha de entrada y salida del hotel.
Separar las fechas obtenidas anteriormente utilizando el método split de java.
Guardar los valores dia y mes en distintas variables.

###6. Buscar vuelo mayor precio
Realizar búsqueda de un vuelo.
Obtener los vuelos que aparezcan en la primera pestaña.
Crear lista con los precios de los vuelos visibles en la primera pestaña.
Buscar el mayor precio de todos.
Hacer click en comprar  el vuelo de mayor precio.
Validar que redirecciona a una nueva página.
Validar la visibilidad de las secciones: Pasajeros, Datos para emisión de la factura, Información de contacto.
