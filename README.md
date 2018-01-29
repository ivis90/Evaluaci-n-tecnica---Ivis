# Evaluacion tecnica - Ivis Leydis Rodriguez Cabrera
QA Automation
Para la construcción del proyecto realicé un estudio del funcionamiento del sitio Despegar.com.ar, principalmente de las funcionalidades Buscar un vuelo y Reservar un hotel; además una evaluación de las tecnologías existentes para pruebas automatizadas seleccionando Eclipse como IDE(Integrated Development Enviroment), Selenium Webdriver con el navegador Chrome, Java como lenguaje de programación, las librerías JUnit de Maven y TestNG.

## Estructura del proyecto
1-Crear nuevo proyecto Maven llamado evaluacion-tecnica-ivis.

2-Dentro de la carpeta src/test/java creo dos paquetes com.despegar(contiene todos los test a realizar) y com.despegar.common (contiene las funcionalidades reutilizables en diferentes tests del paquete com.despegar).

3-Clases del paquete com.despegar

-FlightSearchTest (prueba realizar una búsqueda de un vuelo en donde se le pueda pasar por parámetros los datos de origen, destino, fecha de partida y fecha de regreso; además valida que al completar el formulario y buscar el vuelo se obtiene como resultado una nueva
página con diferentes opciones de vuelo).

-ReservationCheckoutTest (Prueba realizar una búsqueda similar al método FlightSearchTest, dentro de la lista de vuelos selecciona el vuelo que tenga el precio más alto de la primer pestaña de resultados. Verifica que al seleccionar la opción "Comprar" se redirecciona a una nueva página. Valida que en la nueva página esté visible los sectores pasajeros, forma de pago, datos para la emisión de la factura e información de contacto.)

-HotelSearchTest (Prueba realizar una búsqueda de un hotel en Montevideo (Uruguay) en donde se tome como fecha de ingreso al hotel la fecha del Sistema +10 días y que la estadía sea de 3 noches, reservando una habitación para 2 adultos y un menor de 12 años de edad, además verifica que se obtenga como resultado una nueva página en donde se visualiza una lista de hoteles disponibles, también en la nueva página selecciona los hoteles de 5 estrellas y dentro de la nueva lista obtenida seleccionar el hotel que tenga el menor valor por
noche y ver el detalle del mismo. Validar que se obtenga una nueva pestaña y que en la misma esté presente el sector de habitaciones
disponibles.)

4-Clases del paquete com.despegar.common

-BookingFlight (Funcionalidad que realiza la búsqueda de un vuelo).

-BookingHotel  (Funcionalidades que realizan la reserva de un hotel).

-WebDriverFactory (Localizar el archivo chromedriver y configurar las propiedades del sistema, inicializar driver, maximizar la página de navegador, entrar a la url especificada y cierra la ventana emergente(popup)).


## Guia 

## Explicación funcional 

### 1.WebDriverFactory.

Localizar el archivo chromedriver y configurar las propiedades del sistema. 

Inicializar driver.

Maximizar la página.

Ir a la url deseada.

Cerrar Popup.

### 2.BookingFlight

Seleccionar la pestaña Vuelos.

Limpiar el campo origen que carga por defecto el sitio.

Escribir origen deseado.

Esperar que aparezca las lista de aeropuertos.

Seleccionar de la lista el aeropuerto deseado de origen.

Escribir destino deseado.

Esperar que aparezca las lista de aeropuertos.

Seleccionar de la lista el aeropuerto deseado de destino.

Seleccionar fecha de ida.

Seleccionar fecha de regreso.

Hacer click en Buscar.

Validar que la página de los vuelos correspondiente sea la búsqueda.

#### . Buscar vuelo mayor precio

Realizar búsqueda de un vuelo.

Obtener los vuelos que aparezcan en la primera pestaña.

Crear lista con los precios de los vuelos visibles en la primera pestaña.

Buscar el mayor precio de todos.

Hacer click en comprar  el vuelo de mayor precio.

Validar que redirecciona a una nueva página.

Validar la visibilidad de las secciones: Pasajeros, Datos para emisión de la factura, Información de contacto.

### 3. BookingHotel

Seleccionar la pestaña Hoteles.

Escribir destino deseado.

Esperar que aparezca las lista de ciudades.

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

#### . Capturar fechas de entrada y salidas del hotel.

Obtener fecha actual del sistema.

Crear una fecha de entrada que sea la fecha actual del sistema más 10 días.

Crear una fecha de salida que sea la fecha de entrada más 3 días.

#### . Obtener dia y mes de la fecha de entrada y salida del hotel.

Separar las fechas obtenidas anteriormente utilizando el método split de java.

Guardar los valores dia y mes en distintas variables.


